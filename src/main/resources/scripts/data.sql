insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
            values (1, 'Sorry, I did not understand what you just said.',
                    'Извините, я не понял, что вы только что сказали.', 2, 0, 'media/1038.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (2, 'I am so sorry to see you go.',
        'Очень жаль, что Вы уходите.', 1, 0, 'media/1042.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (3, 'On the contrary, it is a deep and heave responsibility.',
        'Напротив, это глубокая и тяжелая ответственность.', 2, 0, 'media/0001.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (4, 'I have not the faintest notion.',
        'Не имею ни малейшего представления.', 5, 0, 'media/0002.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (5, 'Just where the steep ascent of the mountain began, he stopped.',
        'Там, где начинается крутой подъем на гору, он остановился.', 4, 0, 'media/0003.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (6, 'The company intends to cut 400 jobs.',
        'Компания намеревается сократить 400 рабочих мест.', 2, 0, 'media/0004.mp3');

insert into card (id, en_sentence, rus_sentence, missed_word, topic, location)
values (7, 'I wish I had a brother to reciprocate.',
        'Жаль, что у меня нет брата, чтобы ответить взаимностью.', 7, 0, 'media/0005.mp3');

insert into progress (id, card_id, probability) values (1, 1, 1.00);
insert into progress (id, card_id, probability) values (2, 2, 1.00);
insert into progress (id, card_id, probability) values (3, 3, 1.00);
insert into progress (id, card_id, probability) values (4, 4, 1.00);
insert into progress (id, card_id, probability) values (5, 5, 1.00);
insert into progress (id, card_id, probability) values (6, 6, 1.00);
insert into progress (id, card_id, probability) values (7, 7, 1.00);