# 基于Spring Cloud + seata (AT模式) 实现分布式事务的一致性
基于Spring Cloud + seata (AT模式) 实现分布式事务的一致性，用于验证分布式事务的demo，
这里仅仅是为了测试分布式事务，使用到的组件有eureka注册中心、feign远程调用

如果不了解分布式事务，可以先去了解CAP定理，XA协议等知识

我了解的实现分布式事务一致性的方式
    
    1、基于2PC（XA协议）
    2、TCC（代码补偿）
    3、MQ（像RabbitMQ，这类暂不支持事务消息的MQ） + 本地事务表，实现事务的最终一致
    4、使用RocketMQ事务消息
    
这个demo模拟的是用户下单，然后减库存的操作，订单服务和商品服务是两个独立的服务，使用的是2个不同的数据库。
流程是：用户下单，调用订单服务生成订单，然后feign远程调用商品减库存服务
（实际上不止2个服务，还有用户积分等服务，这里仅仅是用于测试分布式事务）。


## Seata
>[seata官网](http://seata.io/zh-cn/)
>
>[seata-server下载](https://github.com/seata/seata/releases)
>
>[seata示例](https://github.com/seata/seata-samples)

### MySql
> MySql5.7的安装，我使用的是二进制包进行安装，它的安装看自己习惯
>
> MySql可以参考我的 mysql-install.sh 进行安装

## 目录说明
    learn-seata-eureka # 注册中心模块
    learn-seata-goods # 商品服务模块（减库存）
    learn-seata-order # 订单服务模块（用户下单）

### 测试步骤
    
1、首先，配置2台不同MySql5.7服务器，一台作为商品服务（192.168.88.129），另一台作为订单服务（192.168.88.130）

2、分别执行目录下的sql文件，我测试的配置是：

    服务器：192.168.88.129 商品服务 
        192.168.88.129.sql
    服务器：192.168.88.130 订单服务
        192.168.88.130.sql
    MySql授权：
        mysql-grant.sql

3、启动[seata-server](https://github.com/seata/seata/releases)

    linux下执行shell  sh ./bin/seata-server.sh
    windows下双击 seata-server.bat

4、启动几个服务，商品服务与订单服务

    LearnSeataEurekaApplication
    LearnSeataGoodsApplication    
    LearnSeataOrderApplication
    
5、浏览器访问 http://localhost:12350/order/create 生成订单

    可以使用postman、ab、wrk、jmeter等工具去测试

#### 说明
    项目下的2张图，是我做的简单测试的截图
    由于先使用PHP实现的MQ的分布式事务，沿用的是PHP测试时的表结构，时间戳我习惯用的是int，字符串等可能和java习惯不符
    大家可以改成自己习惯的格式

