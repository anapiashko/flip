<template>
  <div id="app">
    <TopicCard
      :topics="[{
          name: 'Health',
          img: 'img/icons/yoga-position.png',
          desc: `Vocabulary set to help learn words related to health. Learn useful health and healthcare vocabulary in English, including common diseases, medical supplies and equipment.`
        },
        {
          name: 'Travel',
          img: 'img/icons/plane.png',
          desc: `The travel-related words are the most important terms to know when talking about travel or taking vacations. You'll find example sentences to help provide context for learning.`
        }]"
    />
  </div>
</template>

<script>
// @ is an alias to /src
import TopicCard from '@/components/TopicCard.vue'

export default {
  name: 'Topic',
  components: {
    TopicCard
  }
}
</script>
