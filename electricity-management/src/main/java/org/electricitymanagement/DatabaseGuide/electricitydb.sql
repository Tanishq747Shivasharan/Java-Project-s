-- create database electricitydb;

-- \c electricitydb    -->(Used to connect to the database name as electricitydb).

-- truncate table payment, bill, customer restart identity cascade    -->this query deletes all data from `payment`, `bill`, and `customer` tables, resets their ID counters, and handles foreign key dependencies automatically.


create table customer(
    custid int primary key,
    name varchar(100) not null,
    address text not null,
    phone varchar(15) not null
);

create table bill(
    billid serial primary key,
    custid int references customer(custid),
    units double precision not null,
    total double precision not null
);

create table payment(
    payid serial primary key,
    custid int references customer(custid),
    amountpaid double precision not null
);

/* Server [localhost]:
Database [postgres]:
Port [5432]:
Username [postgres]:
Password for user postgres:

psql (17.5)
WARNING: Console code page (437) differs from Windows code page (1252)
         8-bit characters might not work correctly. See psql reference
         page "Notes for Windows users" for details.
Type "help" for help.

postgres=# create database electricitydb;
CREATE DATABASE
postgres=# \c electricitydb
You are now connected to database "electricitydb" as user "postgres".
electricitydb=# create table customer(
electricitydb(#     custid int primary key,
electricitydb(#     name varchar(100) not null,
electricitydb(#     address text not null,
electricitydb(#     phone varchar(15) not null
electricitydb(# );
CREATE TABLE
electricitydb=# create table bill(
electricitydb(#     billid serial primary key,
electricitydb(#     custid int references customer(custid),
electricitydb(#     units double precision not null,
electricitydb(#     total double precision not null
electricitydb(# );
CREATE TABLE
electricitydb=# create table payment(
electricitydb(#     payid serial primary key,
electricitydb(#     custid int references customer(custid),
electricitydb(#     amountpaid double precision not null
electricitydb(# );
CREATE TABLE
electricitydb=# */