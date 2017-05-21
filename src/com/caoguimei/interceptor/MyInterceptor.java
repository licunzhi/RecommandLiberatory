package com.caoguimei.interceptor;

import java.util.Map;

import com.caoguimei.model.Admin;
import com.caoguimei.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;
	
	private String name;
	public void setName(String name) {
		this.name = name;
	}



	//重写其中过滤的具体方法的实现   初步是过滤除了某些不需要登陆的界面
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//需要首先得到的是这个加载器
		ActionContext ac = invocation.getInvocationContext(); 
		Map<String,Object> session = ac.getSession();
		//在session中存储的无论是admin还是user都是应该准许通过的
		User user = (User)session.get("user");
		if(user != null){
			return invocation.invoke();
		}
		//否则返回的视图应该是定义的全局的login界面
		session.put("loginmessage", "请先登录！");
		return "loginpage";
	}

}
