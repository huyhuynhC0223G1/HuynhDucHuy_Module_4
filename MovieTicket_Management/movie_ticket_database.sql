create database movie_ticket;
use movie_ticket;

create table type_movie (
id_type_movie int primary key auto_increment,
type_movie varchar(500) not null unique
);
	
create table movie_format (
id_movie_format int primary key,
movie_format varchar(50) not null
);
create table status_seat (
id_status_seat int primary key,
status_seat varchar(50) not null
);
create table seat (
id_seat int primary key auto_increment,
number_seat int not null,
price_seat double not null,
id_status_seat int,
foreign key (id_status_seat) references status_seat(id_status_seat) 
);
create table `role` (
id_role int primary key,
name_role varchar(50) not null
);
create table `account` (
id_account int primary key auto_increment,
name_account varchar(50) not null unique,
`password` text not null
);
create table `user` (
id_user int primary key auto_increment,
name_user varchar(50) not null unique,
address varchar(100) not null,
phone_number varchar(50) not null unique,
birthday date,
is_flag boolean,
id_role int,
foreign key (id_role) references `role` ( id_role),
id_account int,
foreign key (id_account) references `account` (id_account) 
);
create table `time` (
id_time int primary key auto_increment,
start_time date not null,
end_time date not null
);
create table services (
id_services int primary key,
name_services varchar(50) not null ,
price double not null,
is_flag boolean,
quality_service int 
);
create table movie (
id_movie int primary key auto_increment,
name_movie varchar(50) not null unique,
`description` longtext not null,
actor varchar(100) not null,
manufaturer varchar(50) not null,
director varchar(50) not null,
duration varchar (20) not null,
is_flag boolean,
id_type_movie int,
foreign key (id_type_movie) references type_movie(id_type_movie),
id_movie_format int,
foreign key (id_movie_format) references movie_format(id_movie_format) ,
id_time int,
foreign key (id_time) references `time` (id_time)
);

create table ticket (
id_ticket int primary key auto_increment,
id_movie int,
is_flag boolean,
foreign key (id_movie) references movie (id_movie),
id_user int,
foreign key (id_user) references `user`(id_user),
id_services int,
foreign key ( id_services ) references services(id_services),
id_seat int,
foreign key (id_seat) references seat(id_seat)
);
