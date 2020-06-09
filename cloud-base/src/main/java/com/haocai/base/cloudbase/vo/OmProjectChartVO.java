package com.haocai.base.cloudbase.vo;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/4 17:07
 **/
@Data
public class OmProjectChartVO {

    private List<Integer> totals;

    private List<Integer> deals;

    private List<Integer> dealings;
}
