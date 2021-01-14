show databases;
use Agile_Meeting;
show tables;
create table login(name varchar(40),email varchar(50),pass varchar(30));
insert into login values('Narayanan A','anarayanan345@gmail.com','8888');
select * from login;
create table meeting(title varchar(30),description varchar(100),link varchar(300),date varchar(15),starttime varchar(15),endtime varchar(15),peoples varchar(1000));
insert into meeting values('meeing 1','description','wwww','23-02-2000','09:00pm','10:00pm','Narayaanan A,Gunaseelan');
select * from meeting;