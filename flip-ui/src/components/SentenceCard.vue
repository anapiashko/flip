<template>
  <div id="container">
    <a class="card-link" >
      <article class="blog-card">
        <img class="post-image" :src="image"/>
        <div class="article-details" style="cursor: pointer;" >
          <h2>{{ counter }}</h2>
          <h4 class="post-category">{{ category }}</h4>
          <h3 class="post-title">{{ info[counter].en_sentence }}</h3>
          <p class="post-description">{{ info[counter].rus_sentence }}</p>
          <input v-model="name" placeholder="Enter Name" v-on:keyup.enter="onEnter()">
          <p class="post-description">{{ info[counter].missedWord }}</p>
          <p class="post-author">By {{ author }}</p>
        </div>
      </article>
    </a>
   </div>
</template>

<script>
import TopicCard from '@/components/TopicCard.vue'
import axios from 'axios'

let info
let topic
const counter = 0

export default {
  name: 'SentenceCard',
  data: () => ({
    info: info,
    counter: counter,
    name: '10 Best Things to Do in Seattle',
    category: 'Travel',
    image: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1159990/pike-place.jpg',
    author: 'Anastasiya Piashko',
    desc: 'Seattle is a seaport city on the west coast of the United States...'
  }),
  beforeCreate () {
    console.log('beforeCreate. Nothing gets called before me!')
    info = TopicCard.data().info
    console.log(info)
  },
  methods: {
    onEnter: function () {
      console.log('onEnter')
      if ((this.counter + 1) < info.length) {
        this.counter += 1
      } else {
        console.log('else')
        this.send()
        this.counter = 0
      }
    },
    async send () {
      console.log('send')
      topic = TopicCard.data().topic
      console.log('topic = ', topic)
      try {
        const res = await axios.get('http://localhost:8000/a', {
          params: {
            title: topic
          }
        })
        info = res.data
        console.log(info)
      } catch (e) {
        console.error(e)
      }
    }
  }
}
</script>

<style scoped lang="scss">
@import url('https://fonts.googleapis.com/css?family=Roboto:400,700');

$bg: #eedfcc;
$text: #777;
$black: #121212;
$white: #fff;
$red: #e04f62;
$border: #ebebeb;
$shadow: rgba(0, 0, 0, 0.2);

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

#container {
  width: 30rem;
  height: 13.625rem;
}

.blog-card {
  display: flex;
  flex-direction: row;
  background: $white;
  box-shadow: 0 0.1875rem 1.5rem $shadow;
  border-radius: 0.375rem;
  overflow: hidden;
}

.card-link {
  position: relative;
  display: block;
  color: inherit;
  text-decoration: none;

  &:hover .post-title {
    @include transition(color 0.3s ease);
    color: $red;
  }

  &:hover .post-image {
    @include transition(opacity 0.3s ease);
    opacity: 0.9;
  }
}

.post-image {
  @include transition(opacity 0.3s ease);
  display: block;
  width: 100%;
  object-fit: cover;
}

.article-details {
  padding: 1.5rem;
}

.post-category {
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

.post-title {
  @include transition(color 0.3s ease);
  font-size: 1.125rem;
  line-height: 1.4;
  color: $black;
  font-weight: 700;
  margin: 0 0 0.5rem 0;
}

.post-author {
  font-size: 0.875rem;
  line-height: 1;
  margin: 1.125rem 0 0 0;
  padding: 1.125rem 0 0 0;
  border-top: 0.0625rem solid $border;
}

@media (max-width: 40rem) {
  #container {
    width: 18rem;
    height: 27.25rem;
  }

  .blog-card {
    flex-wrap: wrap;
  }
}

@supports (display: grid) {
  body {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-gap: 0.625rem;
    grid-template-areas: ". main main ." ". main main .";
  }

  #container {
    grid-area: main;
    align-self: center;
    justify-self: center;
  }

  .post-image {
    height: 100%;
  }

  .blog-card {
    display: grid;
    grid-template-columns: 1fr 2fr;
    grid-template-rows: 1fr;
  }

  @media (max-width: 40rem) {
    .blog-card {
      grid-template-columns: auto;
      grid-template-rows: 12rem 1fr;
    }
  }
}
</style>