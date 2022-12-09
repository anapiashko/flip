insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
            values (1, 'Sorry, I did not understand what you just said.',
                    'Извините, я не понял, что вы только что сказали.', 2, 1, 'media/1038.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (2, 'I am so sorry to see you go.',
        'Очень жаль, что Вы уходите.', 1, 0, 'media/1042.mp3');

insert into users (id, email, password, user_role)
 values (1, 'admin@admin.com', '$2a$12$nRKrtJpoPXonmfoTxNS9c.Gi56j6XmnmJM38.JlinVb7/rxwLWyVy', 'ADMIN');

insert into progress (id, card_id, probability, user_id) values (1, 1, 1.00, 1);
insert into progress (id, card_id, probability, user_id) values (2, 2, 1.00, 1);