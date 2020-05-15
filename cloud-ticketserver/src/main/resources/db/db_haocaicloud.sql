DROP TABLE IF EXISTS tb_om_dictionary;
CREATE TABLE tb_om_dictionary(
    id BIGINT NOT NULL AUTO_INCREMENT,
    dictionary_uuid varchar(32),
    dictionary_type varchar(30),
    dictionary_value varchar(30),
    dictionary_name varchar(30),
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_dictionary(id, dictionary_uuid, dictionary_type, dictionary_value, dictionary_name,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','DOPS','DOPS1.0','海豚1.0','A','2020-05-12','caiqing',null,null,0),
(2, 'uuid02','DOPS','DOPS2.2','海豚2.2','A','2020-05-12','caiqing',null,null,0),
(3, 'uuid03','DOPS','DOPS2.3','海豚2.3','A','2020-05-12','caiqing',null,null,0),
(4, 'uuid04','DOPS','DOPS2.4','海豚2.4','A','2020-05-12','caiqing',null,null,0),
(5, 'uuid05','PV','CTSERVER2.6.0','项目版本_CTSERVER2.6.0','A','2020-05-12','caiqing',null,null,0),
(6, 'uuid06','PV','CTSERVER2.6.1','项目版本_CTSERVER2.6.1','A','2020-05-12','caiqing',null,null,0),
(7, 'uuid07','PV','CTSERVER2.7.0','项目版本_CTSERVER2.7.0','A','2020-05-12','caiqing',null,null,0),
(8, 'uuid08','PT','CTSERVER','项目类型_CTSERVER','A','2020-05-12','caiqing',null,null,0),
(9, 'uuid09','PT','KMAPSERVER','项目类型KMAPSERVER科达地图或影像图转发','A','2020-05-12','caiqing',null,null,0),
(10, 'uuid08','ZB','WGS84','84坐标系','A','2020-05-12','caiqing',null,null,0),
(11, 'uuid09','ZB','GCJ02','02坐标系','A','2020-05-12','caiqing',null,null,0),
(12, 'uuid10','DT','REGIONRIVER','数据类型_region和river','A','2020-05-12','caiqing',null,null,0),
(13, 'uuid11','DT','COMMON','数据类型_通用数据','A','2020-05-12','caiqing',null,null,0),
(14, 'uuid12','DT','320000','数据类型_江苏省数据','A','2020-05-12','caiqing',null,null,0);

DROP TABLE IF EXISTS tb_om_deploypackage;
CREATE TABLE tb_om_deploypackage(
    id BIGINT NOT NULL AUTO_INCREMENT,
    package_uuid varchar(32),
    dolphin_version varchar(30),
    project_type varchar(30),
    project_version varchar(30),
    pack_name varchar(30),
    pack_url varchar(500),
    url_expired char(1),
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_deploypackage(id, package_uuid, dolphin_version, project_type, project_version,pack_name,pack_url,url_expired,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','1.0','CTSERVER','2.7.0','CTSERVER2.7.0部署包','https://yunpan.kedacom.com/d/7f18ce74311e4e7894a5/','A','A','2020-05-12','caiqing',null,null,0),
(2, 'uuid02','2.2','CTSERVER','2.7.0','CTSERVER2.7.0部署包','https://yunpan.kedacom.com/d/0a795a7ec3694b1f9fc4/','A','A','2020-05-12','caiqing',null,null,0),
(3, 'uuid03','2.3','CTSERVER','2.7.0','CTSERVER2.7.0部署包','https://yunpan.kedacom.com/d/f636ca9d44684cc195c0/','A','A','2020-05-12','caiqing',null,null,0),
(4, 'uuid04','2.4','CTSERVER','2.7.0','CTSERVER2.7.0部署包','https://yunpan.kedacom.com/d/5cbb2eab7a0b4ea39438/','A','A','2020-05-12','caiqing',null,null,0),
(5, 'uuid05',null,'KMAPSERVER','1.0','KMAPSERVER非鉴权版部署包','https://yunpan.kedacom.com/d/cc3be248dbbc4408b949/','A','A','2020-05-12','caiqing',null,null,0),
(6, 'uuid06',null,'KMAPSERVER','2.0','KMAPSERVER鉴权版部署包','https://yunpan.kedacom.com/d/f8970877cf4b42db9b68/','A','A','2020-05-12','caiqing',null,null,0);

DROP TABLE IF EXISTS tb_om_deployfile;
CREATE TABLE tb_om_deployfile(
    id BIGINT NOT NULL AUTO_INCREMENT,
    file_uuid varchar(32),
    project_type varchar(30),
    file_name varchar(30),
    file_url varchar(500),
    url_expired char(1),
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_deployfile(id, file_uuid, project_type,file_name,file_url,url_expired,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','CTSERVER','CTSERVER部署升级文件','https://yunpan.kedacom.com/d/79fe11c958d54ec8825c/','A','A','2020-05-12','caiqing',null,null,0),
(2, 'uuid02','KMAPSERVER','KMAPSERVER部署升级文件','https://yunpan.kedacom.com/d/cce3567fd1e843e9848e/','A','A','2020-05-12','caiqing',null,null,0);

DROP TABLE IF EXISTS tb_om_deploydata;
CREATE TABLE tb_om_deploydata(
    id BIGINT NOT NULL AUTO_INCREMENT,
		data_uuid varchar(32),
		project_type varchar(30),
		zb_type varchar(30),
		data_type varchar(30),
		data_name varchar(30),
		data_url varchar(500),
		url_expired char(1),
		status char(1),
		created_time datetime,
		created_by varchar(255),
		updated_time datetime,
		updated_by varchar(255),
		version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_deploydata(id, data_uuid, project_type, zb_type, data_type, data_name,data_url,url_expired,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','CTSERVER','WGS84','REGIONRIVER','region和river84坐标系数据','https://yunpan.kedacom.com/d/4756ac2001564ba0859f/','A','A','2020-05-12','caiqing',null,null,0),
(2, 'uuid02','CTSERVER','GCJ02','REGIONRIVER','region和river02坐标系数据','https://yunpan.kedacom.com/d/2a66c213d0ab4e33b1d4/','A','A','2020-05-12','caiqing',null,null,0),
(3, 'uuid03','CTSERVER','WGS84','COMMON','通用数据','https://yunpan.kedacom.com/d/ef04e965af894043a272/','A','A','2020-05-12','caiqing',null,null,0),
(4, 'uuid04','CTSERVER','GCJ02','COMMON','通用数据','https://yunpan.kedacom.com/d/ef04e965af894043a272/','A','A','2020-05-12','caiqing',null,null,0),
(5, 'uuid05','CTSERVER','WGS84','320000','CTSERVER84坐标系数据文件','https://yunpan.kedacom.com/d/36ba1ea74d8740f8ae11/','A','A','2020-05-12','caiqing',null,null,0),
(6, 'uuid06','CTSERVER','GCJ02','320000','CTSERVER02坐标系数据文件','https://yunpan.kedacom.com/d/57c95bd2f52a4a4dbbb6/','A','A','2020-05-12','caiqing',null,null,0),
(7, 'uuid07','KMAPSERVER','WGS84','320000','KMAPSERVER84坐标系数据文件','https://yunpan.kedacom.com/d/1a959f1d7e184dd4aceb/','A','A','2020-05-12','caiqing',null,null,0),
(8, 'uuid08','KMAPSERVER','GCJ02','320000','KMAPSERVER02坐标系数据文件','https://yunpan.kedacom.com/d/eaec26ff8d5f4790b8b1/','A','A','2020-05-12','caiqing',null,null,0);


DROP TABLE IF EXISTS tb_om_exporthistory;
CREATE TABLE tb_om_exporthistory(
    id BIGINT NOT NULL AUTO_INCREMENT,
		export_uuid varchar(32),
		dolphin_version varchar(30),
		project_type varchar(30),
		project_version varchar(30),
		zb_type varchar(30),
		data_type varchar(30),
		export_content varchar(2000),
		status char(1),
		created_time datetime,
		created_by varchar(255),
		updated_time datetime,
		updated_by varchar(255),
		version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_exporthistory(id, export_uuid,dolphin_version,project_type,project_version, zb_type, data_type, export_content,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','DOPS2.4','CTSERVER','CTSERVER2.7.0','WGS84', 'ADCODE320000','导出的内容，提供给现场','A','2020-05-12','caiqing',null,null,0);




DROP TABLE IF EXISTS tb_ticket_category;
CREATE TABLE tb_ticket_category(
    id BIGINT NOT NULL AUTO_INCREMENT,
    tc_uuid VARCHAR(32) NOT NULL,
    name VARCHAR(50),
    PRIMARY KEY(id)
);
INSERT INTO tb_ticket_category(id, tc_uuid, name) values
(1, 'ddfdafadfdgadggadfa','TEST_DLT'),
(2, 'dvgsgsdgdgsfsfdgfgg','TEST_SSC');


