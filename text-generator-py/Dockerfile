FROM tensorflow/tensorflow:1.15.0-py3
#FROM python:3.6.2
#FROM ubuntu:20.04
#FROM python:3.6-alpine

ENV LANG=C.UTF-8


#RUN apt-get update -y
#RUN apt-get install -y python3.6

RUN mkdir /gpt-2
WORKDIR /gpt-2
#COPY . /gpt-2
COPY ./text_generator /gpt-2/text_generator
COPY requirements.txt /gpt-2

#RUN pip install --upgrade pip
RUN pip install -r requirements.txt
#RUN pip3 install --no-cache-dir tensorflow==1.15.0
#RUN apt install openssl
RUN python3 -m pip install googletrans==3.1.0a0

EXPOSE 5000

CMD ["python3","-m","flask", "run", "--host=0.0.0.0"]