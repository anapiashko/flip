drop table if exists progress;
drop table if exists card;

create table card (
    id int auto_increment primary key,
    en_sentence varchar(150) NOT NULL,
    rus_sentence varchar(150) NOT NULL,
    missed_word int NOT NULL,
    topic int NOT NULL,
    location varchar(150) NOT NULL
);

create table progress (
    id int auto_increment primary key,
    card_id int UNIQUE NOT NULL,
    probability DECIMAL( 5, 2 ) default 1,
    CONSTRAINT record_to_card_fk
        FOREIGN KEY (card_id) REFERENCES card (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);