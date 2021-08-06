import axios from "axios"

export const getOwners = () => {
    return axios({url: "http://localhost:8080/api/owner", headers: {'Accept': 'application/json'}, method: "GET"})
}

export const addOwner = (owner) => {
    return axios({url: `http://localhost:8080/api/owner`, header: {'Accept': 'application/json', 'Content-Type': 'application/json'}, data: owner , method: "POST"})
}

export const getPets = () => {
    return axios({url: "http://localhost:8080/api/pet", headers: {'Accept': 'application/json'}, method: "GET"})
}

export const getPetsForOwner = (ownerId) => {
    return axios({url: `http://localhost:8080/api/owner/${ownerId}/pet`, headers: {'Accept': 'application/json'}, method: "GET"})
}

export const addPetForOwner = (ownerId, pet) => {
    return axios({url: `http://localhost:8080/api/owner/${ownerId}/pet`, header: {'Accept': 'application/json', 'Content-Type': 'application/json'}, data: pet , method: "POST"})
}