use slitv1;


create table users(
userID int NOT NULL auto_increment,
fName varchar(30),
lName varchar(30),
email varchar(30),
phoneNo varchar(30),
pw varchar(30),
constraint userID_pk primary key (userID)
);


create table usermodule(
ModNo int(30),
status1 int(30),
ModDesc varchar(999),
ModGoal varchar(999),
Resources varchar(999),
Modcrit varchar(999),
constraint ModNo_pk primary key (ModNo),
constraint usermodule_state_fk foreign key (status1) references state (status1)
constraint course_state_fk foreign key (course) references state (status1)
);


create table state(
status1 int(30),
constraint status1_pk primary key (status1) 
);


create table course(
courseID varchar(30),
courseName varchar(30),
teacherName varchar(30),
courseDesc varchar(999),
constraint courseID_pk primary key (courseID)

);


create table comments(
commentDesc varchar(999),
constraint commentsDesc_pk primary key (commentsDesc),
constraint userID_fk foreign key (userID)
);