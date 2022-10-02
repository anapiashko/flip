drop table if exists progress;
drop table if exists card;
drop table if exists users;

create table card (
    id int auto_increment primary key,
    en_sentence varchar(150) NOT NULL,
    rus_sentence varchar(150) NOT NULL,
    missed_word int NOT NULL,
    topic int NOT NULL,
    location varchar(150) NOT NULL
);

create table users (
    id int auto_increment primary key,
    email varchar(150) UNIQUE NOT NULL,
    password varchar(150) NOT NULL,
    user_role varchar(20) NOT NULL default 'USER'
);

create table progress (
    id int auto_increment primary key,
    card_id int NOT NULL,
    probability DECIMAL( 5, 2 ) default 1,
    user_id int not null,
    CONSTRAINT record_to_card_fk
        FOREIGN KEY (card_id) REFERENCES card (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT record_to_user_fk
        FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);