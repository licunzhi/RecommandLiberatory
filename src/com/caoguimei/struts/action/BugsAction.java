package com.caoguimei.struts.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caoguimei.model.Bugs;
import com.caoguimei.model.User;
import com.caoguimei.service.BugsService;
import com.opensymphony.xwork2.Action;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Scope("prototype")
@Controller
public class BugsAction extends BaseAction<Bugs> implements SessionAware,Action{
	//�������session��map
	private Map<String,Object> sessionMap;
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	//ע��bugsservice
	@Resource
	private BugsService bugsService;
	
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	//ȥ�����ռ�����
	public String toCollectBugsPage(){
		return "collectbugspage";
	}
	
	
	//ִ���ռ�����
	public String toCommit(){
		User user = (User)sessionMap.get("user");
		String studentname = user.getUsername();
		date = new Date();
		model.setDate(date);
		String studentid = model.getStudentid();
		if(studentid == null){
			studentid = studentname;
		}else{
			studentid = "�û�" + user.getId();
		}
		Bugs bugs = new Bugs(model.getTitle(), model.getDetial(), date, studentid);
		bugsService.saveEntity(bugs);
		return "successpage";
	}
	//��ʾ���еĲ�����bugs
	public String toBugsListPage(){
		//��ѯ��ʾ���е�bugs
		String hql = "From Bugs b order by b.date desc";
		List<Bugs> bugs = bugsService.findEntityByHQL(hql);
		//ע��session��
		session.setAttribute("bugslist", bugs);
		return "bugslistpage";
	}
	
	///�鿴��ʾ�����������
	public String toModifyBugs(){
		String idd = request.getParameter("id");
		int id = Integer.parseInt(idd);
		Bugs bugs = bugsService.getEntity(id);
		session.setAttribute("bug", bugs);
		return "showdetailpage";
	}
	
	//��ν����Ľ�����ǰ�����ɾ��
	public String toDeleteBugs(){
		String ide = request.getParameter("id");
		System.out.println(ide);
		int id = Integer.parseInt(ide);
		System.out.println(id);
		Bugs b = bugsService.getEntity(id);
		bugsService.deleteEntity(b);
		return "toBugsListAction";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.sessionMap = session;
	}

}
