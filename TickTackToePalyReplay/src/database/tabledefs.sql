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


drop table t3_location;
create table t3_location(
    x_coor NUMBER(1) not null, 
    y_coor NUMBER(1) not null,
    location_id VARCHAR(10) primary key 
);
ALTER TABLE t3_location ADD CONSTRAINT uk_t3_location_xy UNIQUE (x_coor, y_coor);


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