import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { getOwners, getPetsForOwner } from "../../data/rest";
import { useDispatch } from "react-redux";

const PetTable = () => {
    const [pets, setPets] = useState([]);
    const [owners, setOwners] = useState([]);
    const [currentSpecies, setCurrentSpecies] = useState("NONE");
    const [currentOwner, setCurrentOwner] = useState(0);
    const species = pets.map(pet => pet.species);
    let uniqueSpecies = species.filter((item, index) => species.indexOf(item) === index);
    uniqueSpecies.unshift("NONE");

    const reduxDispatch = useDispatch();

    const loadPetsForOwner = (ownerId) => {
        getPetsForOwner(ownerId)
        .then((response) => {
            setPets(response.data);
        })
    }

    useEffect(() => {
        getOwners()
        .then((response) => {
            setOwners(response.data);
            loadPetsForOwner(response.data[0].id);
        })
    }, [])
    
    const changeOwner = (e) => {
        loadPetsForOwner(e.target.value);
        setCurrentOwner(e.target.value);
        setCurrentSpecies("NONE");
    }

    const changeSpecies = (e) => {
        setCurrentSpecies(e.target.value);
    }

    const addPet = () => {
        reduxDispatch({type: "add-pet", value: currentOwner })
    }

    return (
        <>
            <label htmlFor="ownerSelect" > Select Owner: </label>
            <select id="ownerSelect" onChange={changeOwner}>
                {owners.map((owner) => {
                    return (<option key={owner.id}  value={owner.id}> {owner.id} </option>)
                })}
            </select>
            <label htmlFor="speciesSelect"> Select species: </label>
            <select id="speciesSelect" onChange={changeSpecies}>
                {/* <option disabled >SELECT</option> */}
                {uniqueSpecies.map((species, index) => {
                    return (<option key={index}  value={species}> {species} </option>)
                })}
            </select>
            <Link to="/addPet"><button onClick={addPet}>Add Pet</button></Link>
            { (pets.length === 0) ? <p>No pets for this owner! :(</p> : 
            <div>
                <p>Pets</p>
                <table>
                    <thead>
                        <tr>
                            <th> Id </th>
                            <th> Species </th>
                            <th> Age </th>
                            <th> Name </th>
                            <th> Gender </th>
                        </tr>
                    </thead>

                    <tbody>
                        {pets.map((pet, index) => {
                            return (
                                (currentSpecies === "NONE" || pet.species === currentSpecies) &&
                                <tr key={index}>
                                    <td>{pet.id}</td>
                                    <td>{pet.species}</td>
                                    <td>{pet.age}</td>
                                    <td>{pet.name}</td>
                                    <td>{pet.gender}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </div>
            }
        </>
    );
}

export default PetTable;