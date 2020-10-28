# 订单数据库 在服务器 192.168.88.130
set names utf8;
drop database if exists `ellen_shop`;
create database /*!32312 if not exists*/ `ellen_shop` /*!40100 default character set utf8 */;
use ellen_shop;
drop table if exists `order`;
create table `order` (
    `id` int unsigned auto_increment primary key,
    `order_no` varchar(32) not null default '' comment '订单号',
    `out_order_no` varchar(32) not null default '' comment '外部订单号',
    `goods_id` int unsigned not null default 0 comment '商品id',
    `buy_number` int unsigned not null default 0 comment '购买数量',
    `create_time` int unsigned not null default 0 comment '订单创建时间',
    `status` tinyint not null default 0 comment '状态',
    key (`goods_id`)
) engine=InnoDB charset=utf8 comment '订单表';

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



