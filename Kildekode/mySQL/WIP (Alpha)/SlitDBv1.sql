use slitv1;

drop table users;

create table users(
userID int NOT NULL auto_increment,
fName varchar(30),
lName varchar(30),
email varchar(30),
phoneNo varchar(30),
pw varchar(30),
ModNo int(3),
constraint userID_pk primary key (userID),
constraint userID_fk foreign key  (ModNo) references usermodule (ModNo),
constraint usermodule_fk foreign key  (ModNo) references comments (ModNo),
constraint usermoduleID_fk foreign key  (userID) references comments (ModNo),
constraint courseID_fk foreign key  (userID) references course (userID),
constraint courseNo_fk foreign key  (ModNo) references course (ModNo),
constraint commentID_fk foreign key  (userID) references comments (userID),
constraint commentNo_fk foreign key  (ModNo) references comments (ModNo)
);

drop table usermodule;

create table usermodule(
ModNo int(3),
status1 int(30),
ModDesc varchar(255),
ModGoal varchar(500),
Resources varchar(120),
Modcrit varchar(500),
constraint ModNo_pk primary key (ModNo)
);

drop table state;

create table state(
status1 int(3),
ModNo int(3),
constraint status1_pk primary key (status1),
constraint ModNo_fk foreign key  (ModNo) references comments (ModNo),
);

drop table course;

create table course(
courseID varchar(30),
courseName varchar(30),
teacherName varchar(30),
courseDesc varchar(200),
userID int (3),
ModNo int(3),
constraint courseID_pk primary key (courseID)

);

drop table comments;

create table comments(
commentDesc varchar(200),
ModNo int(3),
userID int(3),
constraint commentDesc_pk primary key (commentDesc)
);