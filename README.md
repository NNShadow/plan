数据库建表
CREATE TABLE `record` (
`id`  bigint(15) NOT NULL AUTO_INCREMENT ,
`cash`  varchar(100) NULL COMMENT '金额' ,
`type`  varchar(100) NULL COMMENT '收入或支出' ,
`category`  varchar(100) NULL COMMENT '详细信息' ,
`modifyTime`  datetime NOT NULL COMMENT '修改时间' ,
`createTime`  varchar(100) NULL COMMENT 'createTime' ,
PRIMARY KEY (`id`)
)
;