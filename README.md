# uestc_Longhu
面向校园的定制消费系统
开发工具 ：  IntelliJ IDEA 、postman、Jmeter、CentOS7、Maven
技术选型： Springboot+Mybatis-plus+RabbitMQ+Redis+MySQL+Nginx+Vue
项目描述： 搭建该平台作为学校学生对龙湖商城的购物消费指南，保证数据完备的同时满足抢购等活动时系统的稳定性
主要工作： ①采用前后端分离技术，使用SpringBoot整合SpringMvc和Mybatis搭建后端部分。采用Mysql做数据的持久化存储，redis做热点数据缓存。Nginx 将页面请求负载均衡到后台服务器集群。
	  	    ②使用redis解决分布式场景下的session共享问题。并实现热点blog、热点对象、商品及商铺查询缓存，提高静态页面的访问速度。实现个人信息管理、关注列表，并使用Feed流推模式实现简单的关注推送功能。
		      ③在抢购场景下使用Redis预减库存，减少对数据库的访问，Lua脚本解决分布式锁的原子性问题，使用Stream实现异步下单提高并发场景下的性能，查询及抢购功能的QPS从原始的1200提高至2500左右。

