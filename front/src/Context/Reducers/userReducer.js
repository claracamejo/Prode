const userReducer = (state, action = {}) => {
    const { type } = action;
    switch(type) {
        case 'ADD_USER':
            return {
                ...state,
                user: action.user
            };
        case 'DELETE_USER':
            return {...state, user: {}};
        default:
            return state;
    } 
}

export default userReducer;