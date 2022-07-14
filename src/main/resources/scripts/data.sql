insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
            values (1, 'Sorry, I did not understand what you just said.',
                    'Извините, я не понял, что вы только что сказали.', 2, 0, 'media/1038.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (2, 'I am so sorry to see you go.',
        'Очень жаль, что Вы уходите.', 1, 0, 'media/1042.mp3');

insert into progress (id, card_id, probability) values (1, 1, 1.00);
insert into progress (id, card_id, probability) values (2, 2, 1.00);