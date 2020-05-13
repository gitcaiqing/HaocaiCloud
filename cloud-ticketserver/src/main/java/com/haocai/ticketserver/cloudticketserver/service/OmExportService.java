package com.haocai.ticketserver.cloudticketserver.service;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 18:31
 **/
public interface OmExportService {
    String listAllResource(String dolphinVersion, String projectType, String projectVersion, String zbType, String dataType);

    String validate();
}
