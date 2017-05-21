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



	//��д���й��˵ľ��巽����ʵ��   �����ǹ��˳���ĳЩ����Ҫ��½�Ľ���
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//��Ҫ���ȵõ��������������
		ActionContext ac = invocation.getInvocationContext(); 
		Map<String,Object> session = ac.getSession();
		//��session�д洢��������admin����user����Ӧ��׼��ͨ����
		User user = (User)session.get("user");
		if(user != null){
			return invocation.invoke();
		}
		//���򷵻ص���ͼӦ���Ƕ����ȫ�ֵ�login����
		session.put("loginmessage", "���ȵ�¼��");
		return "loginpage";
	}

}
