package com.haocai.ticketserver.cloudticketserver.service;

import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;

import java.util.List;



/**
 * 用户Service
 * @author https://blog.csdn.net/caiqing116
 *
 */
public interface BasicUserService {
	
	Integer insert(BasicUser basicUser);
	
	Integer deleteById(Integer id);
	
	BasicUser selectById(Integer id);
	
	Integer updateById(BasicUser basicUser);
	
	BasicUser selectByUsername(String username);

	Page<List<BasicUser>> listBasicUser(BasicUser basicUser, Page<BasicUser> page);

}
