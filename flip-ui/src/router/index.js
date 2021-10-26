import Vue from 'vue'
import VueRouter from 'vue-router'
import Topic from '../views/Topic.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Topic',
    component: Topic
  },
  {
    path: '/sentences',
    name: 'Sentences',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Sentence.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
