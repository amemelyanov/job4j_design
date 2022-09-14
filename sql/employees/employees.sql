create table employees (
    id serial primary key,
    name varchar(50),
    departnent varchar(50),
    salary integer
);

insert into employees (name, departnent, salary) VALUES ('name_1', 'department_1', 100);
insert into employees (name, departnent, salary) VALUES ('name_2', 'department_2', 150);
insert into employees (name, departnent, salary) VALUES ('name_3', 'department_3', 200);

delete from employees;

ALTER SEQUENCE employees_id_seq RESTART WITH 1;