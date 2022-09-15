begin transaction;
insert into employees (name, department, salary) values('name_4', 'department_4', 50);
savepoint point_1;

select * from employees;

delete from employees where id = 1;
update employees set salary = 500 where name = 'name_4';
savepoint point_2;

select * from employees;

delete from employees where name = 'name_4';

select * from employees;

rollback to savepoint point_2;

select * from employees;

rollback to savepoint point_1;

select * from employees;

commit;

select * from employees;