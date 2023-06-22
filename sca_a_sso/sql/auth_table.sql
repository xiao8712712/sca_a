Drop table  if exists oauth_client_details;
create table oauth_client_details (
                                      client_id VARCHAR(255) PRIMARY KEY,
                                      resource_ids VARCHAR(255),
                                      client_secret VARCHAR(255),
                                      scope VARCHAR(255),
                                      authorized_grant_types VARCHAR(255),
                                      web_server_redirect_uri VARCHAR(255),
                                      authorities VARCHAR(255),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information TEXT,
                                      create_time timestamp default now(),
                                      archived tinyint(1) default '0',
                                      trusted tinyint(1) default '0',
                                      autoapprove VARCHAR (255) default 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Drop table  if exists oauth_access_token;
create table oauth_access_token (
                                    create_time timestamp default now(),
                                    token_id VARCHAR(255),
                                    token BLOB,
                                    authentication_id VARCHAR(255) UNIQUE,
                                    user_name VARCHAR(255),
                                    client_id VARCHAR(255),
                                    authentication BLOB,
                                    refresh_token VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Drop table  if exists oauth_refresh_token;
create table oauth_refresh_token (
                                     create_time timestamp default now(),
                                     token_id VARCHAR(255),
                                     token BLOB,
                                     authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Drop table  if exists oauth_code;
create table oauth_code (
                            create_time timestamp default now(),
                            code VARCHAR(255),
                            authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Add indexes
create index token_id_index on oauth_access_token (token_id);
create index authentication_id_index on oauth_access_token (authentication_id);
create index user_name_index on oauth_access_token (user_name);
create index client_id_index on oauth_access_token (client_id);
create index refresh_token_index on oauth_access_token (refresh_token);

create index token_id_index on oauth_refresh_token (token_id);

create index code_index on oauth_code (code);


-- auto-generated definition
create table sys_user
(
    id              varchar(64)   not null
        primary key,
    user_name       varchar(50)   null,
    age             int           null,
    email           varchar(30)   null,
    roles           varchar(1000) null,
    salt            varchar(4)    null,
    unit_code       varchar(1000) null comment '单位编码',
    post_type_code  varchar(1000) null comment '岗位编码',
    department_code varchar(40)   null comment '部门编码',
    password        varchar(100)  not null,
    create_tiemed datetime default null,
    create_user_id varchar(100) null ,
    create_user_name varchar(100) null,
    updtae_time datetime default null,
    update_user_id varchar(100) null,
    updtae_user_name varchar(100) null,
    constraint sys_user_id_uindex
        unique (id)
);
INSERT INTO sca.sys_user (id, user_name, age, email, roles, salt, unit_code, post_type_code, department_code, password) VALUES ('11111111', 'admin', 12, '1232qq.com', null, '1233', '00', '00', '00', '$2a$10$9WGO4Z3/plUSPHraO0xvTOhx3VBgbl2D3/77ejggKLMQaQKXerms.');
-- auto-generated definition
create table sys_roles
(
    id               varchar(64)   not null
        primary key,
    role_name        varchar(100)  null,
    role_description varchar(1000) null,
    role_code        varchar(10)   null,
    role_level       varchar(100)  null comment '权限等级',
    user_id          varchar(64)   not null,
    create_tiemed datetime default null,
    create_user_id varchar(100) null ,
    create_user_name varchar(100) null,
    updtae_time datetime default null,
    update_user_id varchar(100) null,
    updtae_user_name varchar(100) null,
    constraint sys_roles_id_uindex
        unique (id)
);

INSERT INTO sca.sys_roles (id, role_name, role_description, role_code, role_level, user_id) VALUES ('fbdsjfdkjfgdsfhdusfdsfjdsk', 'admin', 'admin', '00', '1', '11111111');

