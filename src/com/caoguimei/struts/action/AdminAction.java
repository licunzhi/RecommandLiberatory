package com.caoguimei.struts.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caoguimei.model.Admin;
import com.caoguimei.model.User;
import com.caoguimei.service.AdminService;
import com.opensymphony.xwork2.Action;

/**
 * ����Ա��½������ص�action������
 * @author LiCunzhi
 *
 */
@Scope("prototype")
@Controller
public class AdminAction extends BaseAction<Admin> implements SessionAware,Action {
	private static final long serialVersionUID = 1L;
	
	
	//�������session��map
	private Map<String,Object> sessionMap;
	
	@Resource
	private AdminService adminsService;
	
	//�������Ա��½�Ľ���
	public String toAdminPage(){
		return "adminpage";
	}
	
	//ȥ����Ա��½��������
	public String toAdminIndexPage(){
		return "toAdminIndexPage";
	}
	

	//��½ʱ��Ĵ���ʵ��
	public String doAdminLoginProcess(){
		String adminid = model.getAdminid();
		String password = model.getPassword();
		System.out.println(adminid + "  " + password );
		 String hql = "FROM Admin a where a.adminid = ? and a.password = ?";
		 List<Admin> list  = adminsService.findEntityByHQL(hql,adminid,password);
		 if(list.size() == 0 && adminid != "" && password != ""){
			 sessionMap.put("errormessageinf", "�˺Ż����벻��ȷ");
			 return "adminLoginAction";
		 }
		 System.out.println(list.get(0));
		 sessionMap.put("admin", list.get(0));
		return "toAdminSuccessPage";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
			this.sessionMap = session;	
	}



}
