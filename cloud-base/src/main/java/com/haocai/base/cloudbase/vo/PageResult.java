package com.haocai.base.cloudbase.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/7 17:05
 **/
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -6171751136953308027L;
    private long total = 0L;
    private long totalPages = 0L;
    private int pageNo = 0;
    private int pageSize = 0;
    private List<T> data = new ArrayList();

    public static <T> PageResult<T> empty() {
        return new PageResult(0L, Collections.emptyList());
    }

    public static <T> PageResult<T> of(int total, List<T> list) {
        return new PageResult((long)total, list);
    }

    public PageResult() {
    }

    public PageResult(long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public void setTotal(long total) {
        this.total = total;
        if (this.pageSize > 0) {
            this.totalPages = this.total % (long)this.pageSize == 0L ? this.total / (long)this.pageSize : this.total / (long)this.pageSize + 1L;
        }

    }

    public long getTotal() {
        return this.total;
    }

    public long getTotalPages() {
        return this.totalPages;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResult)) {
            return false;
        } else {
            PageResult<?> other = (PageResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotal() != other.getTotal()) {
                return false;
            } else if (this.getTotalPages() != other.getTotalPages()) {
                return false;
            } else if (this.getPageNo() != other.getPageNo()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else {
                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageResult;
    }

    public int hashCode() {
        int result = 1;
        long $total = this.getTotal();
        result = result * 59 + (int)($total >>> 32 ^ $total);
        long $totalPages = this.getTotalPages();
        result = result * 59 + (int)($totalPages >>> 32 ^ $totalPages);
        result = result * 59 + this.getPageNo();
        result = result * 59 + this.getPageSize();
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "PageResult(total=" + this.getTotal() + ", totalPages=" + this.getTotalPages() + ", pageNo=" + this.getPageNo() + ", pageSize=" + this.getPageSize() + ", data=" + this.getData() + ")";
    }

    public static <T> PageResult resultPager(int pageNo, int pageSize, long total, List<T> dataList) {
        PageResult result = new PageResult();
        result.setPageNo(pageNo);
        result.setPageSize(pageSize);
        result.setTotal(total);
        result.setData(dataList);
        return result;
    }
}
