create database Ahorcado;
use Ahorcado;

create table words(
    idWord int auto_increment,
    word varchar(50),
    primary key (idWord)
);

create table winners(
    idWinner int auto_increment,
    name varchar(255) not null,
    winDate date not null,
    word varchar(50),
    primary key (idWinner)
);

insert into words (word) values ('grind');
insert into words (word) values ('hero');
insert into words (word) values ('unity');
insert into words (word) values ('aware');
insert into words (word) values ('fair');
insert into words (word) values ('linen');
insert into words (word) values ('goat');
insert into words (word) values ('aliquam');
insert into words (word) values ('rebel');
insert into words (word) values ('rich');
insert into words (word) values ('knock');
insert into words (word) values ('core');
insert into words (word) values ('lace');
insert into words (word) values ('deal');
insert into words (word) values ('eaux');
insert into words (word) values ('right');
insert into words (word) values ('lunch');
insert into words (word) values ('bare');
insert into words (word) values ('guess');
insert into words (word) values ('flex');
insert into words (word) values ('ride');
insert into words (word) values ('shark');
insert into words (word) values ('snap');
insert into words (word) values ('video');
insert into words (word) values ('blind');
insert into words (word) values ('body');
insert into words (word) values ('chip');
insert into words (word) values ('knit');
insert into words (word) values ('burn');
insert into words (word) values ('care');
insert into words (word) values ('cabin');
insert into words (word) values ('entry');
insert into words (word) values ('build');
insert into words (word) values ('steak');