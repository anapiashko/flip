import axios from 'axios'
import authHeader from '../services/auth-header'
import userService from '../services/user.service'

const API_URL = process.env.VUE_APP_SERVER_HOST

class CardService {
  getNewSample (topic) {
    return axios.post(API_URL + '/get-sample', {
      id: userService.getUserId()
    },
    {
      headers: authHeader(),
      params: {
        topic: topic
      }
    })
  }
}
export default new CardService()
