create database slitV3;
use slitv3;
drop database slitv3;

drop table users;


create table users(
userID int NOT NULL auto_increment,
fName varchar(30),
lName varchar(30),
email varchar(30),
phoneNo varchar(30),
pw varchar(30),
ModNo int(3),
constraint users_userID_pk primary key (userID),
constraint users_ModNo_fk foreign key  (ModNo) references usermodule (ModNo)
);

insert into users (`fname`,`lname`,`email`,`phoneno`, `pw`)
	values ('kristian','Nilsen','karl@gmail.com','87654321', 'lolawq1332');

select * from users;

drop table usermodule;

create table usermodule(
ModNo int NOT NULL auto_increment,
status1 int(30),
ModDesc varchar(255),
ModGoal varchar(500),
Resources varchar(120),
Modcrit varchar(500),
constraint ModNo_pk primary key (ModNo)
);

insert into usermodule(`ModDesc`,`ModGoal`,`Resources`,`ModCrit`)
	values ('kaskask','1234rt','1987-06-01','karl@gmail.com');

select * from usermodule;
drop table state;

/* verdier for status 1=godkjent, 2=ventende(pending), 3=Ikke godkjent */
create table state(
status1 int(3),
ModNo int,
userID int,
constraint status1_pk primary key (status1),
constraint state_userID_fk foreign key  (userID) references users (userID),
constraint state_ModNo_fk foreign key (ModNo) references usermodule (ModNo)
);

insert into state(`status1`)
	values ('1');

insert into state(`status1`)
	values ('2');

insert into state(`status1`)
	values ('3');

select * from state;

drop table course;

create table course(
courseID int auto_increment,
courseName varchar(30),
teacherName varchar(30),
courseDesc varchar(200),
userID int,
ModNo int(3),
constraint courseID_pk primary key (courseID),
constraint course_userID_fk foreign key  (userID) references users(userID),
constraint course_commenNo_fk foreign key  (ModNo) references usermodule (ModNo)
);


insert into course(`courseName`, `teacherName`, `courseDesc`)
	values ('IKT', 'Ola Malnes', 'kaksakskas');

select * from course;

drop table comments;

create table comments(
commentDesc varchar(200),
ModNo int(3),
userID int(3),
constraint commentDesc_pk primary key (commentDesc),
constraint comments_usermodule_fk foreign key  (ModNo) references usermodule (ModNo),
constraint comments_userID_fk foreign key  (userID) references users (userID)
);

insert into comments(`commentDesc`)
	values ('get bitchez fuck money');

select * from comments;