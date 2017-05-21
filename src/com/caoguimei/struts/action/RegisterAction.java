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
 * 注册操作相关的action处理类
 * @author LiCunzhi
 *
 */
@Controller
@Scope("prototype")
public class RegisterAction extends BaseAction<User> implements Action{

	private static final long serialVersionUID = 1L;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	//注入操作的服务层的方法
	@Resource
	private UserService userService;
	
	
	//处理注册信息 存储数据库操作
	public String doRegister(){
		//注册之前总要验证吧
		//学号验证
		if(!userService.isRegisted(model.getStudentid(),model.getEmail()) && model.getStudentid() != "" && model.getEmail() != ""){
			System.out.println(model.getStudentid());
				session.setAttribute("errormessage", "学 号 或 邮 箱 被 注 册");
			return "toRegisterAction";
		}
		if(!userService.isNumber(model.getStudentid())){
			session.setAttribute("errormessage", "学 号 必 须 是  数 字 组 成");
			return "toRegisterAction";
		}
			
			System.out.println(model.getMajor());
			userService.saveEntity(model);
			return SUCCESS;
		
	}


		




}
