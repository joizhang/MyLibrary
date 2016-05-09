drop table if exists sys_log;

drop table if exists sys_resource;

drop table if exists sys_role;

drop table if exists sys_role_resource;

drop table if exists sys_user;

drop table if exists sys_user_role;

drop table if exists t_book;

drop table if exists t_bookType;

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
  log_id               varchar(64) not null,
  operate_man          varchar(64) not null,
  operate_table        varchar(16) not null,
  content              text not null,
  create_time          timestamp not null,
  ipadress             varchar(32),
  type                 varchar(16) not null,
  primary key (log_id)
);

alter table sys_log comment '日志表';

/*==============================================================*/
/* Table: sys_resource                                          */
/*==============================================================*/
create table sys_resource
(
  resource_id          varchar(64) not null,
  parent_id            varchar(64) not null,
  resource_name        varchar(32) not null,
  sort                 int,
  permission           varchar(32) not null,
  primary key (resource_id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
  role_id              varbinary(64) not null,
  role                 varchar(32) not null,
  description          varchar(1024) not null,
  available            int not null,
  primary key (role_id)
);

alter table sys_role comment '角色表';

/*==============================================================*/
/* Table: sys_role_resource                                     */
/*==============================================================*/
create table sys_role_resource
(
  resource_id          varchar(64) not null,
  role_id              varbinary(64) not null,
  primary key (resource_id, role_id)
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
  user_id              varchar(64) not null,
  username             varchar(32) not null,
  password             varchar(64) not null,
  salt                 varchar(64) not null,
  create_time          timestamp not null,
  primary key (user_id)
);

alter table sys_user comment '用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
  user_id              varchar(64) not null,
  role_id              varbinary(64) not null,
  primary key (user_id, role_id)
);

/*==============================================================*/
/* Table: t_book                                                */
/*==============================================================*/
create table t_book
(
  book_id              varchar(64) not null,
  book_number          varchar(32) not null,
  book_name            varchar(32) not null,
  book_photo           varchar(32),
  create_time          timestamp not null,
  description          text,
  lend                 int not null,
  lend_time            timestamp not null DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  borrow_id            varchar(64),
  sell_address         varchar(1024),
  book_type            varchar(64) not null,
  primary key (book_id)
);

/*==============================================================*/
/* Table: t_bookType                                            */
/*==============================================================*/
create table t_bookType
(
  bookTypeId           int auto_increment,
  bookType             varchar(100) not null,
  primary key (bookTypeId)
);

alter table sys_role_resource add constraint FK_Reference_3 foreign key (resource_id)
references sys_resource (resource_id) on delete restrict on update restrict;

alter table sys_role_resource add constraint FK_Reference_4 foreign key (role_id)
references sys_role (role_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_1 foreign key (user_id)
references sys_user (user_id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_2 foreign key (role_id)
references sys_role (role_id) on delete restrict on update restrict;
