<template>
  <div>
    <a href="/user">사용자 목록</a>
    
  </div>
  <button @click="getDate">데이터 호출</button>
</template>
  
<script>
import axios from 'axios';
const uForm = {
  no: 1,
  name: '테스트',
  email: 'test@email.com',
  pwd: '1234',
  gender: true
}
const params = {
  'params': { no: 1 }
}
params
export default {
  name: 'HomeView',
  methods:{
    getDate(){
      axios
      .put('http://localhost:8080/save',uForm)
      .then((Response) => {
        console.log(Response)
      })
      .catch((error) => {
        console.log(error)
      })
    }
  }
};
</script>

<style scoped>

a {
  color: black;
  text-decoration: none;
  font-weight: bold;
  font-size: 1.5rem;
}

</style>