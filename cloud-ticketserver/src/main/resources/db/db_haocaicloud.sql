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




DROP TABLE IF EXISTS tb_om_project;
CREATE TABLE tb_om_project(
    id BIGINT NOT NULL AUTO_INCREMENT,
		project_uuid varchar(32),
		work_id varchar(32),
		project_type varchar(30),
		title varchar(300),
		communication_group varchar(200),
		docking_people varchar(50),
		deployment_status varchar(32) comment '部署状态',
		acceptance_status varchar(32) comment '验收状态',
		memo varchar(200) comment '备注',
		complete_time datetime comment '完成时间',
		status char(1),
		created_time datetime comment '创建时间或开始时间',
		created_by varchar(255),
		updated_time datetime,
		updated_by varchar(255),
		version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_project(id, project_uuid,work_id,project_type,title, communication_group, docking_people, deployment_status,acceptance_status,memo,complete_time,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','104','CTSERVER','连云港公安执法规范化平台新增部署江苏省科达地图服务（KMap-Server 未加鉴权）','连云港公安执法平台', '李绪栋','START','UNSEND','备注','2020-06-01','A','2020-06-01','caiqing',null,null,0);



DROP TABLE IF EXISTS tb_om_config;
CREATE TABLE tb_om_config(
    id BIGINT NOT NULL AUTO_INCREMENT,
		config_uuid varchar(32),
		project_type varchar(30),
		project_version varchar(30),
		config_type varchar(30),
		config_name varchar(200),
		config_url varchar(200),
		config_content mediumtext,
		status char(1),
		created_time datetime,
		created_by varchar(255),
		updated_time datetime,
		updated_by varchar(255),
		version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
INSERT INTO tb_om_config(id, config_uuid,project_type,project_version, config_type, config_name, config_url, config_content,
	status, created_time,created_by,updated_time,updated_by,version ) values
(1, 'uuid01','CTSERVER','CTSERVER2.7.0', 'search-server','kfront-ctserver-usermng-server-dev-2.4.1-2020040301','https://yunpan.kedacom.com/f/1171f6b0590c4ff58215/','{
	"configMigrations":[
		{
			"configs":[
				{
					"configKey":"spring.datasource.druid.max-active",
					"configValue":"10",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.driverClassName",
					"configValue":"org.postgresql.Driver",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.min-idle",
					"configValue":"5",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"currentVersion",
					"configValue":"v1.2.8",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.password",
					"configValue":"fKEvA_MA216qBl$v",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.username",
					"configValue":"user_ctserver",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.url",
					"configValue":"jdbc:postgresql://XXX.6:5432/ctserver_plus",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.initial-size",
					"configValue":"8",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.remove-abandoned-timeout",
					"configValue":"1800",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.query-timeout",
					"configValue":"6000",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.filters",
					"configValue":"stat,\n\t\t\t\t\tconfig",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"elasticsearch.clusterName",
					"configValue":"es-dev",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.type",
					"configValue":"com.alibaba.druid.pool.DruidDataSource",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.datasource.druid.transaction-query-timeout",
					"configValue":"6000",
					"projectId":"kfront-ctserver-search-server",
					"version":"1.0.0"
				},
				{
					"configKey":"default.coordinate.type",
					"configValue":"1",
					"projectId":"kfront-ctserver-search-server",
					"remark":"坐标系 1：02 2：09 3： 84",
					"version":"1.0.0"
				},
				{
					"configKey":"adminIds",
					"configValue":"320000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"江苏省",
					"version":"1.0.0"
				},
				{
					"configKey":"source.type",
					"configValue":"02",
					"projectId":"kfront-ctserver-search-server",
					"remark":"改成poi_02",
					"version":"1.0.0"
				},
				{
					"configKey":"poi.prefix",
					"configValue":"poi_",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.policy",
					"configValue":"3",
					"projectId":"kfront-ctserver-search-server",
					"remark":"#地理位置聚合查询返回策略\n#0:返回各个网格距离屏幕中心点最近的点作为聚合点\n#1:返回各个网格距离每个网格最近的点作为聚合点\n#2:返回各个网格的中心点作为聚合点\n#3:返回各个网格内的任意一点作为聚合点",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.database",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.host",
					"configValue":"172.21.188.12",
					"projectId":"kfront-ctserver-search-server",
					"remark":"10.68.8.81",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.password",
					"configValue":"iWMZ0SPCjPG3E4xXVnvi",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.pool.max-active",
					"configValue":"50",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.pool.max-wait",
					"configValue":"6000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.pool.min-idle",
					"configValue":"100",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.port",
					"configValue":"7379",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.timeout",
					"configValue":"3000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"spring.redis.pool.max-idle",
					"configValue":"200",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"river.prefix",
					"configValue":"river_",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.province",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.city",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"是编码聚合对应层级",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.district",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"区县级编码聚合对应层级",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.geo",
					"configValue":"2,3,4,5,6,7,8,9,10,11,12",
					"projectId":"kfront-ctserver-search-server",
					"remark":"网格聚合对应层级",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.precision.default",
					"configValue":"6",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.precision.map",
					"configValue":"2=3,3=3,4=3,5=3,6=3,7=3,8=3,9=4,10=4,11=4,12=4,13=5,14=5",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"kafka.bootstrap.servers",
					"configValue":"XXX.30:19092,XXX.31:19092,XXX.32:19092",
					"projectId":"kfront-ctserver-search-server",
					"remark":"kafka地址修改",
					"version":"1.0.0"
				},
				{
					"configKey":"kafka.bootstrap.concurrency",
					"configValue":"16",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"section.adminIds",
					"configValue":"320000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"路段行政区域编码：安徽省,江苏省",
					"version":"1.0.0"
				},
				{
					"configKey":"access.adminIds",
					"configValue":"320000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"路口行政区域编码：江苏省",
					"version":"1.0.0"
				},
				{
					"configKey":"road.adminIds",
					"configValue":"320000",
					"projectId":"kfront-ctserver-search-server",
					"remark":"道路行政区域编码",
					"version":"1.0.0"
				},
				{
					"configKey":"kedacom.elasticsearch.urls",
					"configValue":"XXX.33:9200",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"back.visit.limit.second",
					"configValue":"15",
					"projectId":"kfront-ctserver-search-server",
					"remark":"新增配置  限流，15秒访问一次",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.aggsType",
					"configValue":"1",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.twicePrecision.default",
					"configValue":"7",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.twicePrecision.map",
					"configValue":"2=3,3=3,4=4,5=4,6=4,7=4,8=4,9=5,10=5,11=6,12=6,13=6,14=7,15=7",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.zoom.twicePrecision.propertyMode",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"back.included.unlimit.uris",
					"configValue":"/back/layer/query,/back/layer/geometry",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"base.data.zoom.province",
					"configValue":"5",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"base.data.zoom.city",
					"configValue":"8",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"base.data.zoom.district",
					"configValue":"11",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"base.data.zoom.geo",
					"configValue":"15",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"base.data.zoom.nonaggs",
					"configValue":"16",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"location.aggregation.propertyMode",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"rtic_type",
					"configValue":"1",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"logging.level.root",
					"configValue":"error",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"unlimit.uris",
					"configValue":"{\"/layer/distance\": -1,\"/back/layer/query\": 10,\"/back/layer/geometry\": 1,\"/back/device/gps/query\": 10,\"/back/device/gps/geometry\": 1}",
					"projectId":"kfront-ctserver-search-server",
					"remark":"限流接口 默认 10s",
					"version":"1.0.0"
				},
				{
					"configKey":"annulus.level.size",
					"configValue":"5",
					"projectId":"kfront-ctserver-search-server",
					"remark":"环形区聚合查询 环数  默认5",
					"version":"1.0.0"
				},
				{
					"configKey":"mvtTag",
					"configValue":"0",
					"projectId":"kfront-ctserver-search-server",
					"remark":"",
					"version":"1.0.0"
				},
				{
					"configKey":"kedacom.sqlite.path",
					"configValue":"tiles.db",
					"projectId":"kfront-ctserver-search-server",
					"remark":"热力图\n/data/share/kfront-ctserver/tiles.db",
					"version":"1.0.0"
				}
			],
			"profile":{
				"category":"PERSONAL",
				"name":"kfront-ctserver-search-server-1545790380872",
				"profileRealType":"yml",
				"profileType":"bootstrap",
				"projectId":"kfront-ctserver-search-server",
				"version":"1.0.0",
				"visible":0
			}
		}
	],
	"mark":"kfront-ctserver-search-server",
	"projectVersion":"1.0.0"
}','A','2020-05-12','caiqing',null,null,0);

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


--  分布式事务 基于可靠消息的最终一致性方案
DROP TABLE IF EXISTS tb_trans_order;
CREATE TABLE tb_trans_order(
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_uuid varchar(32),
	order_no varchar(32),
    amount BIGINT,
	user_id varchar(32),
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
DROP TABLE IF EXISTS tb_trans_task;
CREATE TABLE tb_trans_task(
    id BIGINT NOT NULL AUTO_INCREMENT,
    task_uuid varchar(32),
    task_type varchar(50),
    mq_exchange varchar(200),
	mq_routing_key varchar(200),
    mq_request_body varchar(2000),
	error_message varchar(2000),
	status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
DROP TABLE IF EXISTS tb_trans_task_his;
CREATE TABLE tb_trans_task_his(
    id BIGINT NOT NULL AUTO_INCREMENT,
    task_his_uuid varchar(32),
    task_type varchar(50),
    mq_exchange varchar(200),
	mq_routing_key varchar(200),
    mq_request_body varchar(2000),
	error_message varchar(2000),
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);
DROP TABLE IF EXISTS tb_trans_learning_course;
CREATE TABLE tb_trans_learning_course(
    id BIGINT NOT NULL AUTO_INCREMENT,
    course_uuid varchar(32),
	user_id varchar(32),
	order_no varchar(32),
    price BIGINT,
	charge INT comment '收费规则  如 90 为 9折  90/100',
    status char(1),
    created_time datetime,
    created_by varchar(255),
    updated_time datetime,
    updated_by varchar(255),
    version BIGINT NOT NULL DEFAULT 0,
    PRIMARY KEY(id)
);


--  分布式事务 事务补偿型方案（tcc解决方案） 创建数据库
DROP TABLE IF EXISTS `tb_trans_tcc_account_info`;
CREATE TABLE `tb_trans_tcc_account_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(100) COMMENT '户主姓名',
  `account_no` varchar(100) COMMENT '银行卡号',
  `account_password` varchar(100) COMMENT '帐户密码',
  `account_balance` bigint(20) DEFAULT NULL COMMENT '帐户余额 单位分',
  PRIMARY KEY (`id`)
);
INSERT INTO `tb_trans_tcc_account_info` VALUES (1, '张三的账户', '1', '', 10000);
INSERT INTO `tb_trans_tcc_account_info` VALUES (2, '李四的账户', '2', '', 10000);


DROP TABLE IF EXISTS `tb_trans_tcc_local_try_log`;
CREATE TABLE `tb_trans_tcc_local_try_log` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`service_name` varchar(200) NOT NULL COMMENT '服务名',
    `tx_no` varchar(64) NOT NULL COMMENT '事务id',
    `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_trans_tcc_local_confirm_log`;
CREATE TABLE `tb_trans_tcc_local_confirm_log` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`service_name` varchar(200) NOT NULL COMMENT '服务名',
    `tx_no` varchar(64) NOT NULL COMMENT '事务id',
    `create_time` datetime DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_trans_tcc_local_cancel_log`;
CREATE TABLE `tb_trans_tcc_local_cancel_log` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`service_name` varchar(200) NOT NULL COMMENT '服务名',
    `tx_no` varchar(64) NOT NULL COMMENT '事务id',
    `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;