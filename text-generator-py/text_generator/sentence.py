class Sentence:
    en_sentence = ""
    rus_sentence = ""

    def __init__(self, en_sentence, rus_sentence):
        """ Create a new sentence """
        self.en_sentence = en_sentence
        self.rus_sentence = rus_sentence

    def dump(self):
        return {'en_sentence': self.en_sentence,
                'rus_sentence': str(self.rus_sentence)}
