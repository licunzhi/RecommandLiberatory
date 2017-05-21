package com.caoguimei.struts.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caoguimei.model.Books;
import com.caoguimei.model.User;
import com.caoguimei.service.BooksService;
import com.caoguimei.service.UserService;
import com.caoguimei.tools.StringUtil;
import com.opensymphony.xwork2.Action;

/**
 * 登陆操作相关的action处理类
 * @author LiCunzhi
 *
 */
@Scope("prototype")
@Controller
public class LoginAction extends BaseAction<User> implements SessionAware,Action {
	private static final long serialVersionUID = 1L;
	
	
	//定义接受session的map
	private Map<String,Object> sessionMap;
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	@Resource
	private UserService userService;
	@Resource
	private BooksService booksService;
	
	
	private String lablevalue;
	private String lable;
	public String getLablevalue() {
		return lablevalue;
	}
	public void setLablevalue(String lablevalue) {
		this.lablevalue = lablevalue;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}

	//主页界面的显示
	public String doIndex(){
		return "indexpage";
	}
	
	//到达登陆界面
	public String doLogin(){
		return "loginpage";
	}
	

	//到达注册界面
	public String toRegisterPage(){
		return "registerpage";
	}
	
	//登陆时候的处理实现
	public String doLoginProcess(){
		String studentid = model.getStudentid();
		String password = model.getPassword();
		System.out.println(studentid + "  " + password );
		 String hql = "FROM User u where u.studentid = ? and u.password = ?";
		 List<User> list  = userService.findEntityByHQL(hql,studentid,password);
		 if(list.size() == 0 && studentid != "" && password != ""){
			 sessionMap.put("errormessageinf", "账号或密码不正确");
			 return "loginPageAction";
		 }
		 System.out.println(list.get(0));
		 sessionMap.put("user", list.get(0));
		 //移除显示信息
		 session.removeAttribute("loginmessage");
		return "toIndexAction";
	}
	
	//注销用户实现
	public String doLogout(){
		sessionMap.remove("user");
		return "loginPageAction";
	}
	public String doLogoutAdmin(){
		sessionMap.remove("admin");
		return "adminloginPageAction";
		
	}
	
	//去个性推荐的界面
	public String toUserFavor(){
		//1.检查用户是否登陆
		User user = (User) sessionMap.get("user");
		if(user == null){
			session.setAttribute("loginmessage", "使用个性推荐功能首先需要进行用户登陆！");
			return "loginpage";
		}
		//2.用户已经登陆  检测用户的标签信息是否已经存在
		if(user != null){
			//清除没有登陆的条件
//			session.removeAttribute("loginmessage");
			String interests = (String) userService.uniqueResult("Select u.interest From User u where u.studentid = ?", user.getStudentid());
			System.out.println(interests);
			if(interests == null || interests == ""){
				session.setAttribute("choosemessage", "个性推荐系统，请定制属于你自己的个性标签！");
				return "choosefavorpage";
			}
		}
		//属于自己的个性标签也有   用户的信息也有  这个时候需要查询所有在符合标签的信息的书籍信息存起来
		//书籍显示的属性的顺序 就是按照浏览的次数显示吧
		String strs = user.getInterest();
		if(strs.contains(",")){
			String[] interests = StringUtil.str2Arr(user.getInterest(), ",");
			strs = StringUtil.arr2specialstr(interests);
		}else{
			strs = "('" + strs + "')";
		}
		System.out.println(strs);
		String hql = "from Books b where b.bookkind in " + strs + " order by b.viewtimes desc";
		List<Books> books = booksService.findEntityByHQL(hql);
		System.out.println(books);
		session.setAttribute("intbooks", books);
		return "touserfavorpage";
	}
	
	//修改标签
	public String toChangeLable(){
		session.setAttribute("choosemessage", "请重新选择你喜欢的个性标签，并确认！");
		return "choosefavorpage";
	}
	
	
	//存储个性推荐标签的信息
	public String addInterests(){
		sessionMap.remove("intbooks");
		String interest = model.getInterest();
		User user = (User) sessionMap.get("user");
		String studentid = user.getStudentid();
		String hql = "Update User u set u.interest = ? where u.studentid = ?";
		userService.batchEntityByHQL(hql, interest, studentid);
		user.setInterest(interest);
		sessionMap.remove("user");
		sessionMap.put("user", user);
		System.out.println(interest);
		return "touserfavorpageaction";
	}
	
	
	//到达用户显示的界面
	public String toUserListPage(){
		String hql = "From User u order by u.id";
		List<User> userq  = userService.findEntityByHQL(hql);
		session.setAttribute("userq", userq);
		return "userListPage";
	}
	
	//达到用户修改信息的界面
	public String toModifyInfo(){
		String studentid = request.getParameter("studentid");
		String hql = "from User u where u.studentid = ?";
		List<User> u = userService.findEntityByHQL(hql, studentid);
		User user  = u.get(0);
		System.out.println(user);
		session.setAttribute("userinfo", user);
		return "modifypage";
	}
	
	//操作修改用户信息的过程
	public String doModify(){
		System.out.println(model);
		userService.updateEntity(model);;
		return "toUserListAction";
	}
	
	//删除指定用户的信息
	public String deleteuserinfo(){
		String studentid = request.getParameter("studentid");
		String hql = "delete from User u where u.studentid = ?";
		userService.batchEntityByHQL(hql, studentid);
		return "toUserListAction";
	}
	
	//限制查询显示
	public String toUserLimitPage(){
		lablevalue = lablevalue.trim();
		if(!lablevalue.equals("") ){
			System.out.println("=========" + lablevalue);
			List<User> userq = userService.findPagesEntityByHql("User", lable, lablevalue, 0, 1);
			session.setAttribute("userqq", userq);
			session.setAttribute("eein", lablevalue);
			session.setAttribute("eeon", lable);
			return "userListPageCopy";
		}else{
			System.out.println("-------------");
			String hql = "From User u order by u.id";
			List<User> userq  = userService.findEntityByHQL(hql);
			session.setAttribute("userq", userq);
			return "userListPage";
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
			this.sessionMap = session;	
	}

	

}
