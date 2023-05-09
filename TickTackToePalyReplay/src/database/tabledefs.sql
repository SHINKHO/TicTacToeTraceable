create table t3_user(
    user_id VARCHAR(10) primary key,
    user_name VARCHAR(20) UNIQUE
);
insert into t3_user (
    user_id,
    user_name
)values(
    '0000000COM'
    ,'COMPUTER'
);


create table t3_location(
    x_coor NUMBER(1) not null unique,
    y_coor NUMBER(1) not null unique,
    location_id VARCHAR(10) primary key 
);

create table t3_game(
    game_date TIMESTAMP DEFAULT SYSDATE,
    winner VARCHAR(10) not null,
    loser VARCHAR(10) not null,
    game_id VARCHAR(30) primary key
);


create table t3_notation(  
    notation_id VARCHAR(10) not null,
    game_id VARCHAR(30) not null,
    user_id VARCHAR(10) not null,
    location_id VARCHAR(10) not null
);

select * from t3_notation;
select * from t3_location order by Location_id;
select * from t3_user;
select * from t3_game;
delete from t3_game;
delete from t3_notation;
delete from t3_user;
delete from t3_location;