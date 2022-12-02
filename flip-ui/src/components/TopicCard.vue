<template>
  <div id="app">
    <SidebarMenu></SidebarMenu>
    <h1>Your Upcoming Goals</h1>
    <div class="topic-contain">
      <div id="topics" style="cursor: pointer;" @click="goToSentenceCards(topic.name)"
           v-for="topic in topics" :key="topic.name">

        <h2 :id="topic.name" ref="header">{{ topic.name }}</h2>
        <img :src="topic.img" width="25%" />
        <p>{{ topic.desc }}</p>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import SidebarMenu from '@/components/SidebarMenu.vue'
import authHeader from '../services/auth-header'
import userService from '../services/user.service'

let sentences
let topic

export default {
  name: 'TopicCard',
  components: {
    SidebarMenu
  },
  props: {
    topics: Array
  },
  data () {
    return {
      sentences: sentences,
      topic
    }
  },
  methods: {
    async goToSentenceCards (topicName) {
      console.log('goToSentenceCards')
      topic = topicName
      console.log('topicName = ', topicName)
      console.log('topic = ', topic)
      try {
        const res = await axios.post(process.env.VUE_APP_SERVER_HOST + '/get-sample', {
          id: userService.getUserId()
        },
        {
          headers: authHeader(),
          params: {
            topic: topicName
          }
        })

        sentences = res.data

        console.log(sentences)
        // console.log(sentences[0].id)
        // console.log(sentences[0].en_sentence)
        // console.log(sentences[0].rus_sentence)
        await this.$router.push('/sentences')
      } catch (e) {
        console.error(e)
      }
    }
  }
}
</script>

<style scoped lang="scss">

$shadow: rgba(0, 0, 0, 0.2);

body {
  width: 100vw;
  height: 100vh;
  font-family: 'NTR', sans-serif;
  background: #eee;
}

h1 {
  text-align: center;
}

.topic-contain {
  display: flex;
  justify-content: center;
}

#topics {
  display: flex;
  flex-direction: column;
  width: 280px;
  height: 320px;
  justify-content: center;
  background: white;
  border: 1px solid #ddd;
  border-radius: 25px;
  box-shadow: 0 0.1875rem 1.5rem $shadow;
  padding: 20px 20px;
  margin: 10px;
  h2 {
    margin: 0;
    text-align: center;
  }
  img {
    margin: 10px;
    align-self: center;
  }
}
</style>
