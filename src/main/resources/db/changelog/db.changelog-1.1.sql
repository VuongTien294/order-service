-- liquibase formatted sql
-- changeset tienva:1.1

create table "t_orders"
(
    id bigserial
        constraint orders_pk
            primary key,
    order_number varchar(255),
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);

create table "t_order_line_items"
(
    id bigserial
        constraint t_order_line_items_pk
            primary key,
    order_id bigserial
        constraint fk_order_order_line
            references t_orders(id),
    sku_code varchar(255),
    price decimal,
    quantity integer,
    created_at timestamp default now(),
    updated_at timestamp default now(),
    is_deleted boolean default false
);




