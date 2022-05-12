const matchesReducer = (state, action = {}) => {
    const { type } = action;
    switch (type) {
        case 'ADD_MATCHES': {
            return {
                ...state,
                marches: action.matches
            }
        }
        case 'ADD_MATCH': {
            const newMatches = state.matches.push(action.match)
            return {
                ...state,
                matches: newMatches
            }
        }
        case 'DELETE_MATCH': {
            const newMatches = state.matches.filter(match => match.id !== action.match.id)
            return {
                ...state,
                matches: newMatches
            }
        }
        default:
            return state;
    }
}

export default matchesReducer;