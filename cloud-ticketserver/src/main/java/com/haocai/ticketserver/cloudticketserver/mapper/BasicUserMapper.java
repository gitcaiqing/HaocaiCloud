package com.haocai.ticketserver.cloudticketserver.mapper;

import java.util.List;

import com.haocai.base.cloudbase.entity.BasicUser;
import com.haocai.base.cloudbase.entity.Page;
import org.apache.ibatis.annotations.Param;


/**
 * @author https://blog.csdn.net/caiqing116 2018-11-28
 */
public interface BasicUserMapper{
   
	int deleteByPrimaryKey(Integer id);

    int insert(BasicUser record);

    int insertSelective(BasicUser record);

    BasicUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicUser record);

    int updateByPrimaryKey(BasicUser record);

    /**
    * 根据用户名查询
    */
	BasicUser selectByUsername(String username);

	int countData(@Param("basicUser") BasicUser basicUser);

	List<BasicUser> listData(@Param("basicUser") BasicUser basicUser, @Param("page") Page<BasicUser> page);
}