--создание таблиц
create table body(
    id serial primary key,
    name varchar(255)
);

create table engine(
    id serial primary key,
    name varchar(255)
);

create table transmission(
    id serial primary key,
    name varchar(255)
);

create table vehicle(
    id serial primary key,
    name varchar(255),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

--Заполнение таблиц данными
insert into body(name) values ('bmw b1');
insert into body(name) values ('toyota b2');
insert into body(name) values ('honda b3');
insert into body(name) values ('subaru b4');
insert into body(name) values ('nissan b5');
insert into engine (name) values ('toyota e1');
insert into engine (name) values ('nissan e2');
insert into engine (name) values ('kia e3');
insert into engine (name) values ('honda e4');
insert into engine (name) values ('bmw e5');
insert into transmission (name) values ('bmw t1');
insert into transmission (name) values ('toyota t2');
insert into transmission (name) values ('bmw t3');
insert into transmission (name) values ('subaru t4');
insert into transmission (name) values ('honda t5');

insert into vehicle (name, body_id, engine_id, transmission_id) values ('honda civic', 3, 4, 5);
insert into vehicle (name, body_id, engine_id, transmission_id) values ('toyota corolla', 2, 1, 2);
insert into vehicle (name, body_id, engine_id, transmission_id) values ('bmw x3', 1, 5, 1);

--Вывести список всех машин и все привязанные к ним детали
SELECT V.NAME, B.NAME, E.NAME, T.NAME
FROM VEHICLE AS V
JOIN BODY AS B ON V.BODY_ID = B.ID
JOIN ENGINE AS E ON V.ENGINE_ID = E.ID
JOIN TRANSMISSION AS T ON V.TRANSMISSION_ID = T.ID;

--Вывести отдельно детали (1 деталь - 1 запрос), которые не используются в машине, кузова, двигатели, коробки передач
SELECT B.ID, B.NAME AS "Неиспользуемые кузова"
FROM BODY AS B
LEFT JOIN VEHICLE AS V ON B.ID = V.BODY_ID
WHERE V.ID IS NULL;

SELECT E.ID, E.NAME AS "Неиспользуемые двигатели"
FROM ENGINE AS E
LEFT JOIN VEHICLE AS V ON E.ID = V.ENGINE_ID
WHERE V.ID IS NULL;

SELECT T.ID, T.NAME AS "Неиспользуемые коробки передач"
FROM TRANSMISSION AS T
LEFT JOIN VEHICLE AS V ON T.ID = V.TRANSMISSION_ID
WHERE V.ID IS NULL;