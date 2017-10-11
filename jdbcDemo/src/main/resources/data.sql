create table person(

id long not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

insert into person
     (id, name, location, birth_date)
     values (10001, 'Jessica', '11171 Westport Station Dr. Maryland Heights', sysdate() );

insert into person
     (id, name, location, birth_date)
     values (10002, 'Rachel', '16826 Crystal Springs Dr. Chesterfield', sysdate());
     
insert into person
     (id, name, location, birth_date)
     values (10003, 'Catherine', 'New York City', sysdate());