create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

--Заполнение таблицы данными
insert into devices (name, price) values ('Camera', 30000);
insert into devices (name, price) values ('Memory', 4000);
insert into devices (name, price) values ('Smartphone', 20000);
insert into devices (name, price) values ('Flashcard', 2000);

insert into people (name) values ('Alex');
insert into people (name) values ('Sergey');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (3, 1);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (4, 2);

--Использование агрегатной функции для выведения средней цены устройств
SELECT AVG(PRICE) FROM DEVICES;

--Использование группировки для выведения для каждого человека средней цены его устройств
SELECT PEOPLE.NAME AS "Имя", AVG(DEVICES.PRICE) AS "Цена"
FROM PEOPLE
JOIN DEVICES_PEOPLE ON PEOPLE.ID = DEVICES_PEOPLE.PEOPLE_ID
JOIN DEVICES ON DEVICES_PEOPLE.DEVICE_ID = DEVICES.ID
GROUP BY PEOPLE.NAME;

--Дополнение предыдущего запроса условием, что средняя стоимость устройств должна быть больше 5000
SELECT PEOPLE.NAME AS "Имя", AVG(DEVICES.PRICE) AS "Цена"
FROM PEOPLE
JOIN DEVICES_PEOPLE ON PEOPLE.ID = DEVICES_PEOPLE.PEOPLE_ID
JOIN DEVICES ON DEVICES_PEOPLE.DEVICE_ID = DEVICES.ID 
GROUP BY PEOPLE.NAME HAVING AVG(DEVICES.PRICE) > 5000;