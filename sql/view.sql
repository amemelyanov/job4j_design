create table students (
    id serial primary key,
    name varchar(50)
);

insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');

create table authors (
    id serial primary key,
    name varchar(50)
);

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');


create table books (
    id serial primary key,
    name varchar(200),
    price int,
    author_id integer references authors(id)
);

insert into books (name, price, author_id) values ('Евгений Онегин', 100, 1);
insert into books (name, price, author_id) values ('Капитанская дочка',150, 1);
insert into books (name, price, author_id) values ('Дубровский',125, 1);
insert into books (name, price, author_id) values ('Мертвые души', 350, 2);
insert into books (name, price, author_id) values ('Вий',200, 2);


create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (4, 2);
insert into orders (book_id, student_id) values (2, 2);

-- Скрипты по созданию view
create view show_sum_price_of_student_books as
select s.name, sum(b.price) from students as s
                                              join orders o on s.id = o.student_id
                                              join books b on o.book_id = b.id
                                              join authors a on b.author_id = a.id
group by s.name
;

create view show_students_who_have_books_with_max_price as
(select s.name as student_name, a.name as author_name, b.name as book_name, b.price  from students as s
                                                 join orders o on s.id = o.student_id
                                                 join books b on o.book_id = b.id
                                                 join authors a on b.author_id = a.id
where b.price = (select b.price from books b order by b.price desc limit 1))
;

