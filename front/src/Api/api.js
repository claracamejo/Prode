import axios from 'axios';

const api = axios.create({
    baseURL: process.env.REACT_APP_SERVER_HOST
})

api.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem('token')
        if (token) {
            config.headers['authorization'] = `Bearer ${token}`
        };
        return config
    }
);

console.log(process.env)
export default api;