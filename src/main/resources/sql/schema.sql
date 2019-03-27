-- auto-generated definition
create table oauth_access_token
(
id serial not null constraint oauth_access_token_pkey primary key,
authentication bytea,
authentication_id varchar(255),
client_id varchar(255),
refresh_token varchar(255),
token bytea,
token_id varchar(255),
user_name varchar(255)
);

-- auto-generated definition
create table table_user
(
id serial not null
constraint table_user_pkey
primary key,
activated boolean,
email varchar(255)
constraint uk_5r6j19hclnw5vcv8sqrnwuyx2
unique,
password varchar(500) not null,
username varchar(50) not null
);

create table oauth_refresh_token
(
id serial not null
constraint oauth_refresh_token_pkey
primary key,
authentication bytea,
token bytea,
token_id varchar(255)
);

create table table_role
(
id serial not null
constraint table_role_pkey
primary key,
name varchar(255)
);