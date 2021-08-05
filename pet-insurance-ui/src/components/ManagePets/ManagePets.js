import { useReducer } from "react"
import { addPetForOwner } from "../../data/rest"
import { useSelector } from "react-redux";

const ManagePets = () => {

    const initialState = {
        name: "",
        gender: "",
        species: "",
        age: 0
    }

    const newPetReducer = (state, data) => {
        return {...state, [data.field]: data.value}
    }

    const [newPet, dispatch] = useReducer(newPetReducer, initialState);

    const handleChange = (e) => {
        dispatch({field: e.target.id, value:e.target.value})
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        addPetForOwner(newPet)
            .then((response) => {
                if (response.status === 200) {
                    // setMessage("Transactions was saved with id :" + response.data.id);
                    console.log("we did it", response.data);
                }
                else {
                    console.log("Also uh oh got status " + response.status);
                }
            })
            // .catch(error => setMessage("uh oh" + error))
    }

    const {name, age, species, gender} = newPet;

    return (
        <form onSubmit={handleSubmit}>
            <h2>New Pet</h2>
            <label htmlFor="name">Name</label>
            <input type="text" id="name"  onChange={handleChange} value={name}/>
            <br/>
            <label htmlFor="age">Age</label>
            <input type="number" id="age" onChange={handleChange} value={age}/>
            <br/>
            <label htmlFor="species">Species</label>
            <input type="text"  id="species" onChange={handleChange} value={species}/>
            <br/>
            <label htmlFor="gender">Gender</label>
            <input type="text"  id="gender" onChange={handleChange} value={gender}/>
            <br/>
            <button type="submit">Save</button>
            <div >{}</div>
        </form>
    )
}

export default ManagePets;