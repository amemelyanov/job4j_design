--создание таблиц
create table departments(
    id serial primary key,
    name varchar(255)
);

create table emploees(
    id serial primary key,
    name varchar(255),
	department_id int REFERENCES departments(id)
);

--Заполнение таблиц данными
insert into departments (name) values ('A');
insert into departments (name) values ('B');
insert into departments (name) values ('C');
insert into departments (name) values ('D');
insert into departments (name) values ('E');

insert into emploees (name, department_id) values ('Alex', 1);
insert into emploees (name, department_id) values ('Sergey', 1);
insert into emploees (name, department_id) values ('Artem', 2);
insert into emploees (name, department_id) values ('Petr', 2);
insert into emploees (name, department_id) values ('Pavel', 3);
insert into emploees (name, department_id) values ('Olga', 3);
insert into emploees (name, department_id) values ('Svetlana', 4);
insert into emploees (name, department_id) values ('Denis', 4);

--Выполнить запросы с left, rigth, full, cross соединениями
select * from emploees as e left join departments as d on e.department_id = d.id;
select * from emploees as e right join departments as d on e.department_id = d.id;
select * from emploees as e full join departments as d on e.department_id = d.id;
select * from emploees as e cross join departments as d;

--Используя left join найти департаменты, у которых нет работников
select * from departments as d left join emploees as e on e.department_id = d.id where e.id is null;

--Используя left и right join написать запросы, которые давали бы одинаковый результат
select * from emploees as e left join departments as d on e.department_id = d.id;
select * from departments as d right join emploees as e on e.department_id = d.id;

--Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens(
    id serial primary key,
    name varchar(255),
	gender varchar(255)
);

insert into teens (name, gender) values ('Alex', 'М');
insert into teens (name, gender) values ('Sergey', 'М');
insert into teens (name, gender) values ('Artem', 'М');
insert into teens (name, gender) values ('Petr', 'М');
insert into teens (name, gender) values ('Pavel', 'М');
insert into teens (name, gender) values ('Olga', 'W');
insert into teens (name, gender) values ('Svetlana', 'W');
insert into teens (name, gender) values ('Denis', 'М');

select t1.name, t1.gender, t2.name, t2.gender from teens t1 cross join teens t2 where t1.gender <> t2.gender;