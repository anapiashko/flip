insert IGNORE into card (id, en_sentence, rus_sentence, missed_word, topic) values (1, 'Did you get any breakfast?', 'Ты завтракал?', 4, 'HEALTH');

insert IGNORE into progress (id, card_id, probability) values (1, 1, 1.00);