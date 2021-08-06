import {addOwner} from "../../data/rest";
import {useReducer, useState} from "react";
import {useDispatch} from "react-redux";


const AddOwner = () => {

    const [message, setMessage] = useState("");

    const initialState = {
        name: "",
        age: 0,
        address: "",
        email: 0,
        phone: "",
        policyNumber: 0
    }

    const newOwnerReducer = (state, data) => {
        return {...state, [data.field]: data.value}
    }

    const [newOwner, dispatch] = useReducer(newOwnerReducer, initialState);

    const handleChange = (e) => {
        dispatch({field: e.target.id, value:e.target.value})
    }

    const reduxDispatch = useDispatch();

    const handleSubmit = (e) => {
        e.preventDefault();
        addOwner(newOwner)
            .then((response) => {
                if (response.status === 200) {
                    setMessage("Owner was saved with id :" + response.data.id);
                    reduxDispatch({type: "add-pet", value: response.data.id});
                    console.log("we did it", response.data);
                }
                else {
                    console.log("Also uh oh got status " + response.status);
                }
            })
            .catch(error => setMessage("uh oh" + error))
    }

    const {name, age, address, email, phone, policyNumber} = newOwner;

    return (
        <div>
            <p>{message}</p>
            <form onSubmit={handleSubmit} className="form">
                <h2>New Owner</h2>
                <label htmlFor="name">Name</label>
                <input type="text" id="name"  onChange={handleChange} value={name}/>
                <br/>
                <label htmlFor="age">Age</label>
                <input type="number" id="age" onChange={handleChange} value={age}/>
                <br/>
                <label htmlFor="address">Address</label>
                <input type="text"  id="address" onChange={handleChange} value={address}/>
                <br/>
                <label htmlFor="email">Email</label>
                <input type="text"  id="email" onChange={handleChange} value={email}/>
                <br/>
                <label htmlFor="phone">Phone</label>
                <input type="text"  id="phone" onChange={handleChange} value={phone}/>
                <br/>
                <label htmlFor="policyNumber">Policy Number</label>
                <input type="text"  id="policyNumber" onChange={handleChange} value={policyNumber}/>
                <br/>
                <button type="submit">Save</button>
                <div >{}</div>
            </form>
        </div>
    )

};

export default AddOwner;