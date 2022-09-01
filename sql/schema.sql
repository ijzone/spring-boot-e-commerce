drop table CUSTOMER if exists cascade;
create table CUSTOMER (
id BIGINT NOT NULL,
first_name VARCHAR NOT NULL,
last_name VARCHAR NOT NULL,
age SMALLINT,
gender CHARACTER,
cellphone VARCHAR NOT NULL,
tel VARCHAR,
email VARCHAR,
street VARCHAR,
city VARCHAR,
zip VARCHAR,
password VARCHAR,
level VARCHAR NOT NULL DEFAULT 'ONE',
active BOOLEAN NOT NULL DEFAULT FALSE,
edit BOOLEAN NOT NULL DEFAULT FALSE,
reg_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
reg_id BIGINT NOT NULL,
mod_date TIMESTAMP WITH TIME ZONE,
mod_id BIGINT,
primary key (id)
);
insert into customer(id, first_name, last_name, cellphone, reg_date, reg_id) 
values (1, 'user1 first name', 'user1 last name', '00000000000', current_timestamp, 1);

insert into customer(id, first_name, last_name, cellphone, reg_date, reg_id) 
values (2, 'user2 first name', 'user2 last name', '00000000000', current_timestamp, 2);
