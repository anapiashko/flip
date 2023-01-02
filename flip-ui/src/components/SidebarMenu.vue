<template>
  <div class="sidebar" :class="isOpened ? 'open' : ''" :style="cssVars">
    <div class="logo-details">
      <img v-if="menuLogo" :src="menuLogo" alt="menu-logo" class="menu-logo icon">
      <i v-else class="bx icon" :class="menuIcon" />
      <div class="logo_name">
        {{ menuTitle }}
      </div>
      <i class="bx" :class="isOpened ? 'bx-menu-alt-right' : 'bx-menu'" id="btn" @click="statisticsRequest()" />
    </div>

    <perfect-scrollbar style="height: 87vh;" :options="{ suppressScrollX: true }">

      <div id="progressCircles" v-if="isOpened">
        <div id="healthProgress">
          <Progress :radius=circleRadius :strokeWidth=lineWidth :strokeColor=lineColor :value="statistics.healthPercentage">
            <template v-slot:footer>
              <b>Health</b>
            </template>
          </Progress>
          <span class="tooltip">Seen from Health Topic</span>
        </div>
        <div id="travelProgress">
          <Progress :radius=circleRadius :strokeWidth=lineWidth :strokeColor=lineColor :value="statistics.travelPercentage">
            <template v-slot:footer>
              <b>Travel</b>
            </template>
          </Progress>
          <span class="tooltip">Seen from Travel Topic</span>
        </div>
        <div id="phrasalVerbsProgress">
          <Progress :radius=circleRadius :strokeWidth=lineWidth :strokeColor=lineColor :value="statistics.phrasalVerbsPercentage">
            <template v-slot:footer>
              <b>Phrasal Verbs</b>
            </template>
          </Progress>
          <span class="tooltip">Seen from Phrasal Verbs Topic</span>
        </div>
        <div id="collocationsProgress">
          <Progress :radius=circleRadius :strokeWidth=lineWidth :strokeColor=lineColor :value="statistics.collocationsPercentage">
            <template v-slot:footer>
              <b>Collocations</b>
            </template>
          </Progress>
          <span class="tooltip">Seen from Collocations Topic</span>
        </div>
      </div>

      <ul class="nav-list">
        <span v-for="(menuItem, index) in menuItems" :key="index">
          <li>
            <a :href="menuItem.link">
              <i class="bx" :class="menuItem.icon || 'bx-square-rounded'" />
              <span class="links_name">{{ menuItem.name }}</span>
            </a>
            <span class="tooltip">{{ menuItem.tooltip || menuItem.name }}</span>
          </li>
        </span>
      </ul>
    </perfect-scrollbar>

    <div class="profile">
      <div class="profile-details">
        <i class="bx bxs-user-rectangle" />
        <div class="name_job">
          <div class="name"> {{ profileName }} </div>
          <div class="job"> {{ profileRole }} </div>
        </div>
      </div>
      <i v-if="isExitButton" class="bx bx-log-out" id="log_out" @click.stop="$emit('button-exit-clicked')"
       href @click.prevent="logOut" />
    </div>
  </div>
</template>

<script>
import { PerfectScrollbar } from 'vue2-perfect-scrollbar'
import Progress from 'easy-circular-progress'
import axios from 'axios'
import authHeader from '../services/auth-header'

export default {
  name: 'Test',
  components: {
    PerfectScrollbar,
    Progress
  },
  props: {
    //! Menu settings
    isMenuOpen: {
      type: Boolean,
      default: false
    },
    menuTitle: {
      type: String,
      default: 'Flip'
    },
    menuLogo: {
      type: String,
      default: ''
    },
    menuIcon: {
      type: String,
      default: 'bxl-foursquare'
    },

    //! Progress circle
    circleRadius: {
      type: Number,
      default: 40
    },
    lineWidth: {
      type: Number,
      default: 15
    },
    lineColor: {
      type: String,
      default: '#2c3e50'
    },

    //! Menu items
    menuItems: {
      type: Array,
      default: () => [
        // {
        //   link: '#',
        //   name: 'Dashboard',
        //   tooltip: 'Dashboard',
        //   icon: 'bx-grid-alt'
        // },
        // {
        //   link: '#',
        //   name: 'User',
        //   tooltip: 'User',
        //   icon: 'bx-user'
        // },
        // {
        //   link: '#',
        //   name: 'Messages',
        //   tooltip: 'Messages',
        //   icon: 'bx-chat'
        // },
        // {
        //   link: '#',
        //   name: 'Analytics',
        //   tooltip: 'Analytics',
        //   icon: 'bx-pie-chart-alt-2'
        // },
        // {
        //   link: '#',
        //   name: 'File Manager',
        //   tooltip: 'Files',
        //   icon: 'bx-folder'
        // },
        // {
        //   link: '#',
        //   name: 'Order',
        //   tooltip: 'Order',
        //   icon: 'bx-cart-alt'
        // },
        // {
        //   link: '#',
        //   name: 'Saved',
        //   tooltip: 'Saved',
        //   icon: 'bx-heart'
        // },
        // {
        //   link: '#',
        //   name: 'Setting',
        //   tooltip: 'Setting up',
        //   icon: 'bx-cog'
        // }
      ]
    },

    //! Profile detailes
    profileImg: {
      type: String,
      default: require('../assets/logo.png')
    },
    profileName: {
      type: String,
      default: 'Anastasiya Piashko'
    },
    profileRole: {
      type: String,
      default: 'anapiashko@gmail.com'
    },
    isExitButton: {
      type: Boolean,
      default: true
    },

    //! Styles
    bgColor: {
      type: String,
      default: '#bde0ff'
    },
    secondaryColor: {
      type: String,
      // default: '#1d1b31'
      default: '#d7ecff'
    },
    // homeSectionColor: {
    //   type: String,
    //   default: '#e4e9f7'
    // },
    logoTitleColor: {
      type: String,
      default: '#2c3e50'
    },
    iconsColor: {
      type: String,
      default: '#2c3e50'
    },
    itemsTooltipColor: {
      type: String,
      default: '#bde0ff'
    },
    menuItemsHoverColor: {
      type: String,
      default: '#fff'
    },
    menuItemsTextColor: {
      type: String,
      default: '#2c3e50'
    },
    menuFooterTextColor: {
      type: String,
      default: '#2c3e50'
    }
  },
  data () {
    return {
      isOpened: false,
      statistics: {
        healthPercentage: 0,
        travelPercentage: 0,
        phrasalVerbsPercentage: 0,
        collocationsPercentage: 0
      }
    }
  },
  mounted () {
    this.isOpened = this.isMenuOpen
  },
  computed: {
    cssVars () {
      return {
        '--bg-color': this.bgColor,
        '--secondary-color': this.secondaryColor,
        // '--home-section-color': this.homeSectionColor,
        '--logo-title-color': this.logoTitleColor,
        '--icons-color': this.iconsColor,
        '--items-tooltip-color': this.itemsTooltipColor,
        '--menu-items-hover-color': this.menuItemsHoverColor,
        '--menu-items-text-color': this.menuItemsTextColor,
        '--menu-footer-text-color': this.menuFooterTextColor
      }
    }
  },
  methods: {
    statisticsRequest () {
      this.isOpened = !this.isOpened
      axios
        .get(process.env.VUE_APP_SERVER_HOST + '/get-statistics', { headers: authHeader() })
        .then(response => (this.statistics = response.data))
        .catch(function (error) {
          if (error.response && error.response.status === 401) {
            localStorage.removeItem('user')
            this.$router.push('/login')
          }
        })
    },
    logOut () {
      this.$store.dispatch('auth/logout')
      this.$router.push('/login')
    }
  }
}
</script>
<style>
/* Google Font Link */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
@import url('https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

.menu-logo {
  width: 30px;
  margin: 0 10px 0 10px;
}

.vue-circular-progress .percent__int {
  font-size: 20px;
}

#healthProgress:hover .tooltip,
#travelProgress:hover .tooltip,
#phrasalVerbsProgress:hover .tooltip,
#collocationsProgress:hover .tooltip {
  opacity: 1;
  pointer-events: auto;
  transition: all 0.4s ease;
  top: 50%;
  transform: translateY(-50%);
}

#healthProgress .tooltip,
#travelProgress .tooltip,
#phrasalVerbsProgress .tooltip,
#collocationsProgress .tooltip {
  position: relative;
  bottom: 150px;
  left: calc(80%);
  z-index: 3;
  background: var(--items-tooltip-color);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
  padding: 6px 12px;
  border-radius: 4px;
  font-size: 15px;
  font-weight: 400;
  opacity: 0;
  white-space: nowrap;
  pointer-events: none;
  transition: 0s;
}

.sidebar {
  position: fixed;
  left: 0;
  top: 0;
  height: 100%;
  min-height: min-content;
  width: 78px;
  background: var(--bg-color);
  padding: 6px 14px;
  z-index: 99;
  transition: all 0.5s ease;
}

.sidebar.open {
  width: 250px;
}

.sidebar .logo-details {
  height: 60px;
  display: flex;
  align-items: center;
  position: relative;
}

.sidebar .logo-details .icon {
  opacity: 0;
  transition: all 0.5s ease;
}

.sidebar .logo-details .logo_name {
  color: var(--logo-title-color);
  font-size: 20px;
  font-weight: 600;
  opacity: 0;
  transition: all 0.5s ease;
}

.sidebar.open .logo-details .icon,
.sidebar.open .logo-details .logo_name {
  opacity: 1;
}

.sidebar .logo-details #btn {
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
  font-size: 22px;
  transition: all 0.4s ease;
  font-size: 23px;
  text-align: center;
  cursor: pointer;
  transition: all 0.5s ease;
}

.sidebar.open .logo-details #btn {
  text-align: right;
}

.sidebar i {
  color: var(--icons-color);
  height: 60px;
  min-width: 50px;
  font-size: 28px;
  text-align: center;
  line-height: 60px;
}

.sidebar .nav-list {
  margin-top: 20px;
  /* margin-bottom: 60px; */
  /* height: 100%; */
  /* min-height: min-content; */
}

.sidebar li {
  position: relative;
  margin: 8px 0;
  list-style: none;
}

.sidebar li .tooltip {
  position: absolute;
  top: -20px;
  left: calc(100% + 15px);
  z-index: 3;
  background: var(--items-tooltip-color);
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
  padding: 6px 12px;
  border-radius: 4px;
  font-size: 15px;
  font-weight: 400;
  opacity: 0;
  white-space: nowrap;
  pointer-events: none;
  transition: 0s;
}

.sidebar li:hover .tooltip {
  opacity: 1;
  pointer-events: auto;
  transition: all 0.4s ease;
  top: 50%;
  transform: translateY(-50%);
}

.sidebar.open li .tooltip {
  display: none;
}

.sidebar {
  position: absolute;
  top: 50%;
  left: 0;
  transform: translateY(-50%);
  font-size: 15px;
  background: var(--secondary-color);
  color: var(--icons-color);
}

.sidebar.open {
  background: var(--secondary-color);
  color: var(--icons-color);
}

.sidebar li a {
  display: flex;
  height: 100%;
  width: 100%;
  border-radius: 12px;
  align-items: center;
  text-decoration: none;
  transition: all 0.4s ease;
  background: var(--bg-color);
}

.sidebar li a:hover {
  background: var(--menu-items-hover-color);
}

.sidebar li a .links_name {
  color: var(--menu-items-text-color);
  font-size: 15px;
  font-weight: 400;
  white-space: nowrap;
  opacity: 0;
  pointer-events: none;
  transition: 0.4s;
}

.sidebar.open li a .links_name {
  opacity: 1;
  pointer-events: auto;
}

.sidebar li a:hover .links_name,
.sidebar li a:hover i {
  transition: all 0.5s ease;
  color: var(--bg-color);
}

.sidebar li i {
  height: 50px;
  line-height: 50px;
  font-size: 18px;
  border-radius: 12px;
}

.sidebar div.profile {
  position: fixed;
  height: 60px;
  width: 78px;
  left: 0;
  bottom: 0;
  padding: 1px 14px;
  background: var(--secondary-color);
  transition: all 0.5s ease;
  overflow: hidden;
}

.sidebar.open div.profile {
  width: 250px;
}

.sidebar div .profile-details {
  display: flex;
  align-items: center;
  flex-wrap: nowrap;
}

.sidebar div img {
  height: 45px;
  width: 45px;
  object-fit: cover;
  border-radius: 6px;
  margin-right: 10px;
}

.sidebar div.profile .name,
.sidebar div.profile .job {
  font-size: 15px;
  font-weight: 400;
  color: var(--menu-footer-text-color);
  white-space: nowrap;
}

.sidebar div.profile .job {
  font-size: 12px;
}

.sidebar .profile #log_out {
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
  background: var(--secondary-color);
  width: 100%;
  height: 60px;
  line-height: 60px;
  border-radius: 0px;
  transition: all 0.5s ease;
}
.sidebar.open .profile #log_out {
  width: 50px;
  background: var(--secondary-color);
  opacity: 0;
}
.sidebar.open .profile:hover #log_out {
  opacity: 1;
}
.sidebar.open .profile #log_out:hover {
  opacity: 1;
  color: red;
}

.home-section {
  position: relative;
  background: var(--home-section-color);
  min-height: 100vh;
  top: 0;
  left: 78px;
  width: calc(100% - 78px);
  transition: all 0.5s ease;
  z-index: 2;
}

.sidebar.open~.home-section {
  left: 250px;
  width: calc(100% - 250px);
}

.home-section .text {
  display: inline-block;
  color: var(--bg-color);
  font-size: 25px;
  font-weight: 500;
  margin: 18px;
}

@media (max-width: 420px) {
  .sidebar li .tooltip {
    display: none;
  }
}
</style>
