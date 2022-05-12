import api from './api';

function authenticate (user) {
    return api.request({
        method: 'post',
        url: 'authenticate',
        data: user
    })
}

export {
    authenticate
}