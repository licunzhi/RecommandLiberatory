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
 * ��½������ص�action������
 * @author LiCunzhi
 *
 */
@Scope("prototype")
@Controller
public class LoginAction extends BaseAction<User> implements SessionAware,Action {
	private static final long serialVersionUID = 1L;
	
	
	//�������session��map
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

	//��ҳ�������ʾ
	public String doIndex(){
		return "indexpage";
	}
	
	//�����½����
	public String doLogin(){
		return "loginpage";
	}
	

	//����ע�����
	public String toRegisterPage(){
		return "registerpage";
	}
	
	//��½ʱ��Ĵ���ʵ��
	public String doLoginProcess(){
		String studentid = model.getStudentid();
		String password = model.getPassword();
		System.out.println(studentid + "  " + password );
		 String hql = "FROM User u where u.studentid = ? and u.password = ?";
		 List<User> list  = userService.findEntityByHQL(hql,studentid,password);
		 if(list.size() == 0 && studentid != "" && password != ""){
			 sessionMap.put("errormessageinf", "�˺Ż����벻��ȷ");
			 return "loginPageAction";
		 }
		 System.out.println(list.get(0));
		 sessionMap.put("user", list.get(0));
		 //�Ƴ���ʾ��Ϣ
		 session.removeAttribute("loginmessage");
		return "toIndexAction";
	}
	
	//ע���û�ʵ��
	public String doLogout(){
		sessionMap.remove("user");
		return "loginPageAction";
	}
	public String doLogoutAdmin(){
		sessionMap.remove("admin");
		return "adminloginPageAction";
		
	}
	
	//ȥ�����Ƽ��Ľ���
	public String toUserFavor(){
		//1.����û��Ƿ��½
		User user = (User) sessionMap.get("user");
		if(user == null){
			session.setAttribute("loginmessage", "ʹ�ø����Ƽ�����������Ҫ�����û���½��");
			return "loginpage";
		}
		//2.�û��Ѿ���½  ����û��ı�ǩ��Ϣ�Ƿ��Ѿ�����
		if(user != null){
			//���û�е�½������
//			session.removeAttribute("loginmessage");
			String interests = (String) userService.uniqueResult("Select u.interest From User u where u.studentid = ?", user.getStudentid());
			System.out.println(interests);
			if(interests == null || interests == ""){
				session.setAttribute("choosemessage", "�����Ƽ�ϵͳ���붨���������Լ��ĸ��Ա�ǩ��");
				return "choosefavorpage";
			}
		}
		//�����Լ��ĸ��Ա�ǩҲ��   �û�����ϢҲ��  ���ʱ����Ҫ��ѯ�����ڷ��ϱ�ǩ����Ϣ���鼮��Ϣ������
		//�鼮��ʾ�����Ե�˳�� ���ǰ�������Ĵ�����ʾ��
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
	
	//�޸ı�ǩ
	public String toChangeLable(){
		session.setAttribute("choosemessage", "������ѡ����ϲ���ĸ��Ա�ǩ����ȷ�ϣ�");
		return "choosefavorpage";
	}
	
	
	//�洢�����Ƽ���ǩ����Ϣ
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
	
	
	//�����û���ʾ�Ľ���
	public String toUserListPage(){
		String hql = "From User u order by u.id";
		List<User> userq  = userService.findEntityByHQL(hql);
		session.setAttribute("userq", userq);
		return "userListPage";
	}
	
	//�ﵽ�û��޸���Ϣ�Ľ���
	public String toModifyInfo(){
		String studentid = request.getParameter("studentid");
		String hql = "from User u where u.studentid = ?";
		List<User> u = userService.findEntityByHQL(hql, studentid);
		User user  = u.get(0);
		System.out.println(user);
		session.setAttribute("userinfo", user);
		return "modifypage";
	}
	
	//�����޸��û���Ϣ�Ĺ���
	public String doModify(){
		System.out.println(model);
		userService.updateEntity(model);;
		return "toUserListAction";
	}
	
	//ɾ��ָ���û�����Ϣ
	public String deleteuserinfo(){
		String studentid = request.getParameter("studentid");
		String hql = "delete from User u where u.studentid = ?";
		userService.batchEntityByHQL(hql, studentid);
		return "toUserListAction";
	}
	
	//���Ʋ�ѯ��ʾ
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
