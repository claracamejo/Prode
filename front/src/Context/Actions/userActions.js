const saveUser = (user) => {
    return {
        type: 'ADD_USER',
        user
    }
}

export {
    saveUser
}