package com.caoguimei.struts.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.caoguimei.model.User;
import com.caoguimei.service.UserService;
import com.opensymphony.xwork2.Action;

/**
 * ע�������ص�action������
 * @author LiCunzhi
 *
 */
@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction<User> implements Action{

	private static final long serialVersionUID = 1L;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	//ע������ķ����ķ���
	@Resource
	private UserService userService;
	
	
	//����ע����Ϣ �洢���ݿ����
	public String doRegister(){
		//ע��֮ǰ��Ҫ��֤��
		//ѧ����֤
		if(!userService.isRegisted(model.getStudentid(),model.getEmail()) && model.getStudentid() != "" && model.getEmail() != ""){
			System.out.println(model.getStudentid());
				session.setAttribute("errormessage", "ѧ �� �� �� �� �� ע ��");
			return "toRegisterAction";
		}
		if(!userService.isNumber(model.getStudentid())){
			session.setAttribute("errormessage", "ѧ �� �� �� ��  �� �� �� ��");
			return "toRegisterAction";
		}
			
			System.out.println(model.getMajor());
			userService.saveEntity(model);
			return SUCCESS;
		
	}


		




}
