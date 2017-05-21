package com.caoguimei.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caoguimei.dao.BaseDao;
import com.caoguimei.model.User;
import com.caoguimei.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	/**
	 * ��д�÷���,Ŀ����Ϊ�˸��ǳ����и÷�����ע��,ָ��ע��ָ����Dao����,����spring
	 * �޷�ȷ��ע���ĸ�Dao---���ĸ�����������Dao.
	 */
	@Resource(name="userDao")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
	}

	/**
	 * �ж�ѧ���Ƿ�ռ��
	 */
	@Override
	public boolean isRegisted(String studentid,String email) {
		String hql = "FROM User u WHERE u.studentid = ? or u.email = ?";
		List<User> list = this.findEntityByHQL(hql, studentid, email);
		if(list.size() == 0 || list == null){
			return true;
		}
		return false;
	}


	/**
	 * �ж������ѧ���ǲ���ȫ��������
	 */
	@Override
	public boolean isNumber(String studentid) {
		
	            Pattern pattern = Pattern.compile("[0-9]*");
	            Matcher isNum = pattern.matcher(studentid);
	            if( !isNum.matches() )
	            {
	                  return false;
	            }
	            return true;
	      }

	

}
