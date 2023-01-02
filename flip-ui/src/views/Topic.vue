<template>
  <div id="app">
    <TopicCard
      :topics="[{
          name: 'Vocabulary',
          img: 'img/icons/dictionary.png',
          desc: `Learning vocabulary will help you improve your language level and communicate confidently and effectively.`,
          internal_name: 'Vocabulary'
        },
        {
          name: 'Idioms',
          img: 'img/icons/discussion.png',
          desc: `An idiom is an expression or phrase whose meaning does not relate to the literal meaning of its words.`,
          internal_name: 'Idioms'
        },
        {
          name: 'Phrasal Verbs',
          img: 'img/icons/rinse.png',
          desc: `Phrasal verbs are two or more words that together act as a completely new word, with a different meaning.`,
          internal_name: 'Phrasal_Verbs'
        },
        {
          name: 'Collocations',
          img: 'img/icons/puzzle.png',
          desc: `A collocation is a group of words that are almost always put together to create a specific meaning.`,
          internal_name: 'Collocations'
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
