package com.haocai.base.cloudbase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.haocai.base.cloudbase.entity.OmProject;
import com.haocai.base.cloudbase.util.TimeUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/3 9:37
 **/
@Data
public class OmProjectPageDTO extends OmProject {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdTimeStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdTimeEnd;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date completeTimeStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date completeTimeEnd;

}
