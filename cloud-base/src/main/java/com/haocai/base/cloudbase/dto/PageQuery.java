package com.haocai.base.cloudbase.dto;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 16:05
 **/

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class PageQuery implements Serializable {
    public static final int DEFAULT_PAGE_NO = 0;
    public static final int DEFAULT_PAGE_SIZE = 1000;
    @Min(
            value = 0L,
            message = "pageNo最小值不允许小于0"
    )
    @Max(
            value = 1000L,
            message = "pageNo最大值不允许超过1000"
    )
    private Integer pageNo;
    @Min(
            value = 0L,
            message = "pageSize最小值不允许小于0"
    )
    @Max(
            value = 10000L,
            message = "pageSize最大值不允许超过10000"
    )
    private Integer pageSize;

    public PageQuery() {
        this.pageNo = 0;
        this.pageSize = 1000;
    }

    public PageQuery(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageFrom() {
        return this.pageNo == null ? 0 : this.pageNo * this.pageSize;
    }

    public int getPageTo() {
        return this.getPageFrom() + this.pageSize;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public String toString() {
        return "PageQuery(pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ")";
    }
}
