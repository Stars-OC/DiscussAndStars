create database replay character set utf8mb4;

use replay;
set character set utf8mb4;

create table reply(
    content_id BIGINT auto_increment primary key      not null,
    discuss_id BIGINT                                 not null,
    username BIGINT not null ,
    content    text                                    not null,
    resources text,
    create_time BIGINT not null,
    update_time BIGINT not null,
    stars      int default 0 not null,
    score     int default 0 not null,
    reply_id BIGINT default 0 not null,
    deleted  tinyint(1) default 0 not null
);

create index idx_discuss_id on reply (discuss_id);
create index idx_username on reply (username);
create index idx_create_time on reply (create_time);
create index idx_replay_id on reply (reply_id);

create table reply_star(
    content_id BIGINT not null,
    username  BIGINT not null,
    primary key (content_id, username)
);

create table discuss(
    discuss_id BIGINT auto_increment primary key      not null,
    username BIGINT not null,
    title    varchar(64),
    content    text,
    create_time BIGINT not null,
    update_time BIGINT not null,
    course_id BIGINT default 0 not null,
    deleted  tinyint(1) default 0 not null
);

create index idx_username on discuss (username);
create index idx_course_id on discuss (course_id);

create table user
(
    username    BIGINT auto_increment primary key      not null,
    nickname   char(16)                            not null,
    password   char(100)                           not null,
    description varchar(255) default null        ,
    avatar_url varchar(255) default null         ,
    role       int        default 0                not null,
    create_time  bigint   not null comment '秒级',
    deleted    tinyint(1) default 0                not null
)AUTO_INCREMENT = 100000000;


create index idx_username on user (username);
create index idx_time on user (create_time);