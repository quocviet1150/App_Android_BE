CREATE TABLE public.users (
id bigserial NOT NULL,
isactive bool NOT NULL,
created_date timestamp NULL,
date_of_birth timestamp NULL,
directory_path varchar(255) NULL,
email varchar(100) NULL,
firstname varchar(255) NOT NULL,
lastname varchar(255) NOT NULL,
"password" varchar(255) NOT NULL,
sex int4 NULL,
updated_date timestamp NULL,
username varchar(100) NULL,
CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username),
CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE public.verify_account (
id bigserial NOT NULL,
created_date timestamp NULL,
expired_data_token timestamp NULL,
"token" text NULL,
user_id int8 NULL,
CONSTRAINT uk_eyndd23d0p6qx0t07slpf4u0m UNIQUE (token),
CONSTRAINT verify_account_pkey PRIMARY KEY (id),
CONSTRAINT fk5obhountl03qkiono0solwd99 FOREIGN KEY (user_id) REFERENCES public.users(id)
);