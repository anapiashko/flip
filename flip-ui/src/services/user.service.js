import axios from 'axios'
import authHeader from './auth-header'

const API_URL = 'http://localhost:8000/api/test/'

class UserService {
  getUserId () {
    const user = JSON.parse(localStorage.getItem('user'))
    return user.userId
  }

  getPublicContent () {
    return axios.get(API_URL + 'all')
  }

  getUserBoard () {
    return axios.get(API_URL + 'user', { headers: authHeader() })
  }

  getModeratorBoard () {
    return axios.get(API_URL + 'mod', { headers: authHeader() })
  }

  getAdminBoard () {
    return axios.get(API_URL + 'admin', { headers: authHeader() })
  }
}

export default new UserService()
