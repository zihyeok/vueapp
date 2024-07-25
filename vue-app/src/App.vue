<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/user">UserList</router-link> |
      <router-link to="/user/findById">UserSelect</router-link> |
      <router-link to="/user/editById">UserUpdate</router-link> |
      <router-link to="/user/save">UserCreate</router-link> 
    </nav>
    <router-view></router-view>
  </div>
  
</template>

<script>
export default {
  created() {
    const user = sessionStorage.getItem('setUser')
    if (user) {
      //console.log(user, this.base64(user))
      this.$store.commit('setUser', this.base64(user))
    }
  },
  methods: {
    base64(user) {
      return JSON.parse(decodeURIComponent(window.atob(user)))
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
nav {
  padding: 1em;
}

nav a {
  margin: 0 1em;
  text-decoration: none;
  color: #42b983;
}

nav a.router-link-exact-active {
  font-weight: bold;
}
</style>
