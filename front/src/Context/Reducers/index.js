import matchesReducer from "./matchesReducer"
import userReducer from "./userReducer"

const combineReducers = reducers => {
    return (state, action) => {
        return Object.keys(reducers).reduce(
            (acc, prop) => {
                return ({
                    ...acc,
                    ...reducers[prop]({ [prop]: acc[prop] }, action),
                })
            },
            state
        )
    }
}

const appReducers = combineReducers({
    matches: matchesReducer,
    user: userReducer
})

export {combineReducers, appReducers}