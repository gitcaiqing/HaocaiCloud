package com.haocai.ticketserver.cloudticketserver.mapper;


import com.haocai.base.cloudbase.dto.OmProjectPageDTO;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.entity.Page;
import com.haocai.base.cloudbase.entity.TbOmConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OmProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OmProject record);

    int insertSelective(OmProject record);

    OmProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OmProject record);

    int updateByPrimaryKey(OmProject record);

    int countData(@Param("omProjectPageDTO") OmProjectPageDTO omProjectPageDTO);

    List<OmProject> listData(@Param("omProjectPageDTO") OmProjectPageDTO omProjectPageDTO, @Param("page") Page<OmProjectPageDTO> page);

    List<OmProject> listByProjectType(@Param("omProjectPageDTO") OmProjectPageDTO omProjectPageDTO);
}