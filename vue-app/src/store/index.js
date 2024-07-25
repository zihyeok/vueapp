import { createStore } from 'vuex'

const store = createStore({
    state() {
        return {
                user: {}
            }
        },
    mutations: {
        setUser(state, value) {
                state.user = value
            }
        },
})

export default store