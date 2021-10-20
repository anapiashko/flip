from flask import Blueprint, render_template, request, redirect, jsonify, Response
from .generator import ai
# from translate import Translator
from .sentence import Sentence
import json
# import googletrans
from googletrans import Translator
import string

generator = Blueprint('generator', __name__)


# @generator.route('/')
# def index():
#     # 18. Now add route index
#     return render_template('index.html')


@generator.route('/analyze', methods=['GET'])
def analyze():
    title = request.args.get('title')
    text = ai.generate_text(title)
    print("------>full generated text -->", text)
    # text = "The maximum character limit on a single text is 15k.You can use another google translate domain for " \
    #        "translation "
    text = split_text(text)
    translator = Translator()
    new = []
    for sen in text:
        translation = translator.translate(sen, dest='ru').text
        print("-------->translation", translation)
        new.append(Sentence(sen, str(translation), title.upper()))

    # print("text", text)
    # print("new[0].rus_sentence", new[0].rus_sentence)

    json_string = json.dumps(new, default=obj_dict, ensure_ascii=False)

    # json_str = json.dumps([o.dump() for o in new], ensure_ascii=False)
    # print("json_str", json_str)

    return Response(json_string, content_type='application/json')


def obj_dict(obj):
    return obj.__dict__


@generator.route('/query-example')
def query_example():
    return 'Query String Example'


@generator.route('/json-example', methods=['POST'])
def json_example():
    return 'JSON Object Example'


def split_text(text):
    print("SPLITTING")
    text = text.split(".")
    # punctuation_set = set(string.punctuation)
    punctuation_set = ['&', '<', '$', "'", '(', '|', '=', '\\', '%', ';', '~', '*', ']', '_', '{', '[', '+', '>',
                       '^', '"', '}', ')', '/', '#', '-', '`', ':', '@']
    result = []
    for s in text:
        string_set = set(s)
        if not string_set.intersection(punctuation_set):
            result.append(s)

    return result
