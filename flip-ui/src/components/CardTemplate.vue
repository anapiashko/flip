<template>
  <div id="app">
    <h1>Your Upcoming Destinations</h1>
    <div class="location-contain">
      <div class="locations" v-for="location in locations" :key="location.name">
        <h2>{{ location.name }}</h2>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CardTemplate',
  props: {
    locations: Array
  }
}
</script>
