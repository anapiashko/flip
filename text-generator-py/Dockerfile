#FROM tensorflow/tensorflow:1.15.0-py3
FROM python:3.9.1

ENV LANG=C.UTF-8
RUN mkdir /gpt-2
WORKDIR /gpt-2
#COPY . /gpt-2
COPY ./text_generator /gpt-2/text_generator
COPY temp/ /gpt-2
RUN pip3 install -r requirements.txt
RUN pip install googletrans