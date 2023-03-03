create table quotes(

    id bigint not null auto_increment,
    symbol varchar(100) not null,
    price DECIMAL(65) ,
    country varchar(4) not null,
    primary key(id)

);