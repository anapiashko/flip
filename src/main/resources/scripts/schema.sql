create table IF NOT EXISTS card (
    id int primary key,
    en_sentence varchar(150) NOT NULL,
    rus_sentence varchar(150) NOT NULL
);