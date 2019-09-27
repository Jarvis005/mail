
DROP DATABASE IF EXISTS mail;
CREATE DATABASE IF NOT EXISTS mail DEFAULT CHARSET utf8 COLLATE utf8_general_ci;


CREATE TABLE `t_mail_user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(20) NULL COMMENT '用户名' ,
`password`  varchar(128) NULL COMMENT 'md5加密的密码' ,
`user_role`  varchar(128) NULL COMMENT '用户角色  多个以，隔开' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`update_time`  datetime NULL COMMENT '修改时间' ,
`enabled`  tinyint(1) NULL COMMENT '是否可用' ,
`delete_flag`  tinyint(1) NULL COMMENT '逻辑删除符' ,
PRIMARY KEY (`id`)
)
COMMENT='mail 用户表'
;

