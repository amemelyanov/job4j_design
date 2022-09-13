--Хранимая процедура
create or replace procedure delete_data_from_products(u_count integer, u_id integer)
language 'plpgsql'
as $$
    BEGIN
        if u_count > 0 THEN
            delete from products where count < u_count;
        end if;
        if u_id > 0 THEN
            delete from products where id = u_id;
        end if;
    END;
$$;


--Функция аналогичная по функционалу хранимой процедуре, но возвращающая в качестве результата или
--кол-во удаленных строк (при передаче u_count) или сумму стоимости товара при удалении по u_id
create or replace function f_delete_data(u_count integer, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        before_count integer;
        after_count integer;
        result integer;
    begin
        if u_count > 0 THEN
            select into before_count count(*) from products;
            delete from products where count < u_count;
            select into after_count count(*) from products;
            result = before_count - after_count;
        end if;
        if u_id > 0 THEN
            select into result price * count from products where id = u_id;
            delete from products where id = u_id;
        end if;
        return result;
    end;
$$;