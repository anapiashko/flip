<template>
  <div id="app">
    <h1>Your Upcoming Destinations</h1>
    <div class="location-contain">
      <div id="place" class="locations" v-for="location in locations" :key="location.name">
        <place :location="location">
          <h2>{{ location.name }}</h2>
           <img :src="location.img" width="25%" />
           <p>{{ location.desc }}</p>
        </place>
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
