# 商品数据库 在服务器 192.168.88.129
set names utf8;
drop database if exists `ellen_shop`;
create database /*!32312 if not exists*/ `ellen_shop` /*!40100 default character set utf8 */;
use ellen_shop;
drop table if exists `goods`;
create table `goods` (
    `id` int unsigned auto_increment primary key,
    `name` varchar(210) not null default '' comment '商品名称',
    `stock` int unsigned not null default 0 comment '库存',
    `create_time` int unsigned not null default 0 comment '添加时间',
    `update_time` int unsigned not null default 0 comment '修改时间'
) engine=InnoDB charset=utf8 comment '商品表';

insert into `goods` (`name`, `stock`) values ('华为Mate40', 50000000), ('iphone 12', 20000000), ('小米 10', 30000000), ('realme Q2', 10000000);

CREATE TABLE `undo_log`
(
    `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `branch_id`     BIGINT(20)   NOT NULL,
    `xid`           VARCHAR(100) NOT NULL,
    `context`       VARCHAR(128) NOT NULL,
    `rollback_info` LONGBLOB     NOT NULL,
    `log_status`    INT(11)      NOT NULL,
    `log_created`   DATETIME     NOT NULL,
    `log_modified`  DATETIME     NOT NULL,
    `ext`           VARCHAR(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;


