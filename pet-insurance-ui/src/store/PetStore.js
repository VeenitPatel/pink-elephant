import { createStore } from "redux";

const initialState = {
    ownerId: 0
}

const petSystemReducer = (state = initialState, action) => {
    if(action.type === "add-pet") {
        return {...state, ownerId: action.value}
    }
    else {
        return state;
    }
}

const store = createStore(petSystemReducer);

export default store;