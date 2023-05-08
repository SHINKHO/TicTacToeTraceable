create table t3_user(
    user_id VARCHAR(10) primary key,
    user_name VARCHAR(20) not null
);

create table t3_location(
    x_coor NUMBER(1) not null,
    y_coor NUMBER(1) not null,
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
    location_id VARCHAR(10) not null,
    constraint notaion_of_game primary key (notation_id,game_id)
);
select * from t3_location;

 SELECT user_id
 FROM t3_user
 WHERE user_id = '1';