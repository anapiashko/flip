<template>
  <div id="container">
      <article class="blog-card">
        <div class="article-details" >
<!--          <h2>{{ counter }}</h2>-->
          <h4 class="card-category">{{ category }}</h4>
          <div id="english_sentence" :missed="getMissedWord(sentences[counter])">
            <h3 class="en-sentence">{{ getFirstSentencePart(sentences[counter]) }}
            <input id="input-word" v-model.lazy.trim="typedWord"
                   :style="{width: missedWord.length * 1.5 + 'ch'}"
                   v-on:keyup.enter="onEnter()">
            {{ getLastSentencePart(sentences[counter]) }}</h3>
          </div>
          <p class="rus-sentence">{{ sentences[counter].rus_sentence }}</p>
        </div>
      </article>
   </div>
</template>

<script>
import TopicCard from '@/components/TopicCard.vue'
import axios from 'axios'

let sentences
let topic

let sentenceId
let missedWord
let firstSentencePart
let lastSentencePart

export default {
  name: 'SentenceCard',
  data: () => ({
    sentences: sentences,
    counter: 0,
    typedWord: '',
    missedWord: missedWord,
    firstSentencePart: firstSentencePart,
    lastSentencePart: lastSentencePart,
    category: topic,
    author: 'Anastasiya Piashko'
  }),
  beforeCreate () {
    console.log('beforeCreate. Nothing gets called before me!'.toUpperCase())
    topic = TopicCard.data().topic
    sentences = TopicCard.data().sentences
    console.log(sentences)

    console.log('getMissedWord beforeCreate'.toUpperCase())
    const arr = (sentences[0] !== null) ? sentences[0].en_sentence.split(/[ ,.?!]+/) : ''
    const word = arr[sentences[0].missedWord]
    missedWord = (word !== null) ? word : ''
    console.log('missed word = ', missedWord)
    return (word !== null) ? word : ''
  },
  methods: {
    getFirstSentencePart (sentence) {
      console.log('getFirstSentencePart')
      const arr = (sentence !== null) ? sentence.en_sentence.split(' ') : ''
      const subArr = arr.splice(0, sentence.missedWord)
      firstSentencePart = subArr.join(' ')
      console.log('firstSentencePart = ', firstSentencePart)
      sentenceId = sentence.id
      return firstSentencePart
    },
    getLastSentencePart (sentence) {
      console.log('getLastSentencePart')
      const arr = (sentence !== null) ? sentence.en_sentence.split(' ') : ''
      const subArr = arr.splice(sentence.missedWord + 1, arr.length)
      lastSentencePart = subArr.join(' ')
      if (this.isBlank(lastSentencePart)) {
        lastSentencePart = sentence.en_sentence[sentence.en_sentence.length - 1]
      }
      console.log('lastSentencePart = ', lastSentencePart)
      return lastSentencePart
    },
    getMissedWord (sentence) {
      console.log('getMissedWord')
      console.log('sentence = ', sentence)
      const arr = (sentence !== null) ? sentence.en_sentence.split(/[ ,.?!]+/) : ''
      const word = arr[sentence.missedWord]
      missedWord = (word !== null) ? word : ''
      console.log('missed word = ', missedWord)
      return (word !== null) ? word : ''
    },
    onEnter: async function () {
      console.log('onEnter')
      console.log('typedWord = ', this.typedWord)
      const isTypedWordCorrect = (this.typedWord.toLowerCase() === missedWord.toLowerCase())
      console.log(isTypedWordCorrect)
      const audio = new Audio(require('../../../src/main/resources/media/1038.mp3'))
      let audioDuration = 1
      audio.onloadedmetadata = () => {
        console.log(audio.duration)
        audioDuration = audio.duration
      }
      if (isTypedWordCorrect) {
        await audio.play()
        audio.addEventListener('ended', () => {
          console.log('ended')
          if ((this.counter + 1) < sentences.length) {
            this.counter += 1
          } else {
            this.requestForAdditionalSentenceSet()
            this.counter = 0
          }
          document.getElementById('input-word').placeholder = ''
        })
      } else {
        document.getElementById('input-word').placeholder = missedWord
      }
      await this.sleep(audioDuration * 1000)
      this.updateProgress(isTypedWordCorrect)
      this.typedWord = ''

      this.getMissedWord(this.$data.sentences[this.counter])
      console.log(' missedWord.length = ', missedWord.length)
      document.getElementById('input-word').style.width = missedWord.length * 1.5 + 'ch'
    },
    async requestForAdditionalSentenceSet () {
      console.log('requestForAdditionalSentenceSet')
      topic = TopicCard.data().topic
      console.log('topic = ', topic)
      try {
        const res = await axios.get(process.env.VUE_APP_SERVER_HOST + '/get-sample', {
          params: {
            topic: topic
          }
        })
        this.$data.sentences = res.data
        console.log('new sample : ', this.$data.sentences)

        this.getMissedWord(this.$data.sentences[this.counter])
        console.log(' missedWord.length = ', missedWord.length)
        document.getElementById('input-word').style.width = missedWord.length * 1.5 + 'ch'
      } catch (e) {
        console.error(e)
      }
    },
    async updateProgress (isTypedWordCorrect) {
      console.log('updateProgress')
      console.log('sentenceId = ', sentenceId)
      try {
        await axios.post(process.env.VUE_APP_SERVER_HOST + '/change-progress', {
          card_id: sentenceId,
          typed_correct: isTypedWordCorrect
        })
      } catch (e) {
        console.error(e)
      }
    },
    async sleep (ms) {
      return new Promise((resolve) => {
        setTimeout(resolve, ms)
      })
    },
    isBlank (str) {
      return (!str || /^\s*$/.test(str))
    }
  }
}
</script>

<style scoped lang="scss">
@import url('https://fonts.googleapis.com/css?family=Roboto:400,700');

$bg: #eedfcc;
$text: #777;
$black: #2c3e50;
$white: #fff;
$red: #e04f62;
$border: #ebebeb;
$shadow: rgba(0, 0, 0, 0.2);

$char-w: 1ch;
$gap: .5*$char-w;
$n-char: 15;
$in-w: $n-char*($char-w + $gap);

@mixin transition($args...) {
  transition: $args;
}

* {
  box-sizing: border-box;

  &::before, &::after {
    box-sizing: border-box;
  }
}

body {
  display: flex;
  font-family: 'Roboto', sans-serif;
  font-weight: 400;
  color: $text;
  background: $bg;
  font-size: 0.9375rem;
  min-height: 100vh;
  margin: 0;
  line-height: 1.6;
  align-items: center;
  justify-content: center;
  text-rendering: optimizeLegibility;
}

input {
  color: $black;
  margin: 0 0 0.5rem 0;
  outline:0 solid transparent;
  border: none;
  padding: 0;
  width: $in-w;
  background: repeating-linear-gradient(90deg,
    $black 0, $black $char-w,
    transparent 0, transparent $char-w + $gap)
  0 100%/ #{$in-w - $gap} 2px no-repeat;
  font: 2ch droid sans mono, consolas, monospace;
  letter-spacing: $gap;
}

#english_sentence {
  display:flex
}

#container {
  width: 35rem;
  height: 13.625rem;
  position: absolute;
  top: 35%;
  left: 50%;
  margin-right: -50%;
  transform: translate(-50%, -50%);
}

.blog-card {
  display: flex;
  flex-direction: row;
  background: $white;
  box-shadow: 0 0.1875rem 1.5rem $shadow;
  border-radius: 0.375rem;
  overflow: hidden;
}

.article-details {
  padding: 1.5rem;
}

.card-category {
  display: inline-block;
  text-transform: uppercase;
  font-size: 0.75rem;
  font-weight: 700;
  line-height: 1;
  letter-spacing: 0.0625rem;
  margin: 0 0 0.75rem 0;
  padding: 0 0 0.25rem 0;
  border-bottom: 0.125rem solid $border;
}
</style>
