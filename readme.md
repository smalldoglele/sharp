####数据库通用字段定义
```$xslt
id 主键
create_by 创建人
create_time 创建时间
update_by 更新人
update_time 更新时间
deleted 是否删除 1/0
blocked 启用/停用 0/1
```
#### 例子`sys_user`
```mysql
drop table if exists `sys_user`;
create table `sys_user`
(
	`id` bigint not null comment '主键',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	create_by bigint not null comment '创建人',
	update_by bigint not null comment '更新人',
	deleted bit not null default b'0' comment '是否删除',
	blocked bit not null default b'0' comment '是否禁用',
	user_name varchar(50) comment '用户名',
	nick_name varchar(50) comment '昵称',
	true_name varchar(50) comment '真实姓名',
	salt varchar(80) comment '盐',
	`password` varchar(80) comment '密码',
	email varchar(100) comment '邮箱',
	mobile varchar(20) comment '手机号',
	sex tinyint comment '性别 0-未知;1-男;2-女',
	birth_date datetime comment '出生日期',
	primary key(`id`)
);
```