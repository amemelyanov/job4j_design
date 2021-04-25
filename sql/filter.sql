--создане таблиц
create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int REFERENCES type(id),
	expired_date date,
    price float
);

--Заполнение таблицы данными
insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('КОЛБАСЫ');
insert into type (name) values ('БАКАЛЕЯ');
insert into type (name) values ('РЫБА');

insert into product (name, type_id, expired_date, price) values ('Плавленный сырок', 1, '2021-05-25', 50);
insert into product (name, type_id, expired_date, price) values ('Ламбер', 1, '2021-05-27', 600);
insert into product (name, type_id, expired_date, price) values ('Простоквашино', 2, '2021-05-02', 70);
insert into product (name, type_id, expired_date, price) values ('Морозко мороженное', 2, '2021-05-03', 50);
insert into product (name, type_id, expired_date, price) values ('Вареная Останкино', 3, '2021-05-01', 300);
insert into product (name, type_id, expired_date, price) values ('Сырокопченая Черкизово', 3, '2021-05-15', 450);
insert into product (name, type_id, expired_date, price) values ('Печенье шоколадное', 4, '2021-09-15', 100);
insert into product (name, type_id, expired_date, price) values ('Бублики', 4, '2021-07-01', 120);
insert into product (name, type_id, expired_date, price) values ('Скумбрия мороженая', 5, '2021-12-01', 500);
insert into product (name, type_id, expired_date, price) values ('Селедка соленая', 5, '2021-10-12', 200);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id where t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id where p.name like '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id 
where extract(month from p.expired_date) = extract(month from (CURRENT_DATE + INTERVAL '1 month'));

--4. Написать запрос, который выводит самый дорогой продукт.
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id order by price desc limit 1;

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name as "Имя_типа", count(p.name) as "Количество" from product as p join type as t on p.type_id = t.id group by t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id where t.name in ('СЫР', 'МОЛОКО');

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name as "Имя_типа", count(p.name) as "Количество" from product as p join type as t on p.type_id = t.id group by t.name having count(p.name) < 10;

--8. Вывести все продукты и их тип.
select p.name, p.expired_date, p.price, t.name as type from product as p join type as t on p.type_id = t.id;