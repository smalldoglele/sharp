####数据库通用字段定义
```$xslt
id 主键
create_by 创建人
create_time 创建时间
update_by 更新人
update_time 更新时间
deleted 是否删除 1/0
varlid 是否有效 0/1
blocked 启用/停用 0/1
```
#### 例子`sys_user`
```mysql
drop table if exists `sys_user`;
create table `sys_user`
(
	`id` bigint not null auto_increment comment '主键',
	create_time timestamp not null default current_timestamp comment '创建时间',
	update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
	create_by bigint not null comment '创建人',
	update_by bigint not null comment '更新人',
	deleted bit not null default b'0' comment '是否删除',
	valid bit not null default b'0' comment '是否有效',
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
) comment='用户信息表';
```
#### 规范和规则
1. mybatis plus中的wrapper类 禁止在 RPC 调用中把 Wrapper 进行传输,wrapper类不能上浮到controller中,可以自定义参数对象传值;
2. 查询分页列表参数对象,直接继承PageParams 一个实体对应一个对象;
3. templates/user-demo 文件夹中是crud的例子,可以参考风格
4. jquery validation 推荐使用data-rule-*和data-msg-*来实现,如果需要额外逻辑,使用js方式来实现
5. common.js是工具类js和项目相关性不大,base.js是项目相关性的js基础类;
6. breadcrumbs的第一参数是模块名称,第二个页面是三级页面名称,base.js中可以根据2个参数定位左侧菜单焦点;
```
<div th:replace="fragment::breadcrumbs('系统管理','用户管理')"/>
```