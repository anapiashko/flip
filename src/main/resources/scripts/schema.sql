create table IF NOT EXISTS card (
    id int auto_increment primary key,
    en_sentence varchar(150) NOT NULL,
    rus_sentence varchar(150) NOT NULL,
    missed_word int not null
);
