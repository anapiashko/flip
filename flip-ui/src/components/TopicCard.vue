<template>
  <div id="app">
    <h1>Your Upcoming Destinations</h1>
    <p>{{ this.sentences }}</p>
    <div class="location-contain">
      <div id="place"
        style="cursor: pointer;" @click="redirectToHome(location.name)"
        class="locations" v-for="location in locations" :key="location.name">

        <h2 :id="location.name" ref="header">{{ location.name }}</h2>
        <img :src="location.img" width="25%" />
        <p>{{ location.desc }}</p>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

let sentences
let topic

export default {
  name: 'TopicCard',
  props: {
    locations: Array
  },
  data () {
    return {
      sentences: sentences,
      topic
    }
  },
  methods: {
    async redirectToHome (locationName) {
      console.log('redirectToHome')
      topic = locationName
      console.log('locationName = ', locationName)
      console.log('topic = ', topic)
      try {
        const res = await axios.get('http://localhost:8000/a', {
          params: {
            title: locationName
          }
        })

        sentences = res.data

        console.log(sentences)
        console.log(sentences[0].id)
        console.log(sentences[0].en_sentence)
        console.log(sentences[0].rus_sentence)
        await this.$router.push('/sentences')
      } catch (e) {
        console.error(e)
      }
    }
  }
}
</script>

<style scoped lang="scss">
body {
  width: 100vw;
  height: 100vh;
  font-family: 'NTR', sans-serif;
  background: #eee;
}

h1 {
  text-align: center;
}

.location-contain {
  display: flex;
  justify-content: center;
}

#place {
  display: flex;
  flex-direction: column;
  width: 280px;
  height: 320px;
  justify-content: center;
  background: white;
  border: 1px solid #ddd;
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
