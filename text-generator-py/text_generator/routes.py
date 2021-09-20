from flask import Blueprint, render_template, request, redirect, jsonify
from .generator import ai
# from translate import Translator
from .sentence import Sentence
import json
# import googletrans
from googletrans import Translator

generator = Blueprint('generator', __name__)

# @generator.route('/')
# def index():
#     # 18. Now add route index
#     return render_template('index.html')


@generator.route('/analyze', methods=['POST'])
def analyze():
    request_data = request.get_json()
    title = request_data['title']
    text = ai.generate_text(title)
    # text = "The maximum character limit on a single text is 15k.You can use another google translate domain for " \
    #        "translation "
    text = split_text(text)
    translator = Translator()
    new = []
    for sen in text:
        translation = translator.translate(sen, dest='ru').text
        print("-------->translation", translation)
        new.append(Sentence(sen, str(translation)))

    # print("text", text)
    # print("new[0].rus_sentence", new[0].rus_sentence)

    json_string = json.dumps(new, default=obj_dict, ensure_ascii=False)

    # json_str = json.dumps([o.dump() for o in new], ensure_ascii=False)
    # print("json_str", json_str)

    return json_string


def obj_dict(obj):
    return obj.__dict__


@generator.route('/query-example')
def query_example():
    return 'Query String Example'


@generator.route('/json-example', methods=['POST'])
def json_example():
    return 'JSON Object Example'


def split_text(text):
    return text.split(".")