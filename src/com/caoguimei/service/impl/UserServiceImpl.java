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
	 * 重写该方法,目的是为了覆盖超类中该方法的注解,指明注入指定的Dao对象,否则spring
	 * 无法确定注入哪个Dao---有四个满足条件的Dao.
	 */
	@Resource(name="userDao")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
	}

	/**
	 * 判断学号是否被占用
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
	 * 判断输入的学号是不是全部是数字
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
