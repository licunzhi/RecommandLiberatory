package com.caoguimei.struts;

import com.caoguimei.model.User;

/**
 * 用户操作较多  实现用户关注
 * @author LiCunzhi
 *
 */
public interface UserAware {
	public void setUser(User user);

}
