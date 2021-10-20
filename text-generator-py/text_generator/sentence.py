class Sentence:
    en_sentence = ""
    rus_sentence = ""
    topic = ""

    def __init__(self, en_sentence, rus_sentence, topic):
        """ Create a new sentence """
        self.en_sentence = en_sentence
        self.rus_sentence = rus_sentence
        self.topic = topic
