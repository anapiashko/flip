create table IF NOT EXISTS card (
    id int auto_increment primary key,
    en_sentence varchar(150) NOT NULL,
    rus_sentence varchar(150) NOT NULL,
    missed_word int NOT NULL,
    topic ENUM ('HEALTH', 'TRAVEL')
);

create table IF NOT EXISTS progress (
    id int auto_increment primary key,
    card_id int UNIQUE NOT NULL,
    probability DECIMAL( 5, 2 ) default 1,
    CONSTRAINT record_to_card_fk
        FOREIGN KEY (card_id) REFERENCES card (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);