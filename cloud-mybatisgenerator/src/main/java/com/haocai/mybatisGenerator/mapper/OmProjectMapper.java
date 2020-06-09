package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.OmProject;

public interface OmProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmProject record);

    int insertSelective(OmProject record);

    OmProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmProject record);

    int updateByPrimaryKey(OmProject record);
}