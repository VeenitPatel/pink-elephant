import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { getOwners, getPetsForOwner } from "../../data/rest";
import {useDispatch, useSelector} from "react-redux";
import { useLocation, useHistory } from 'react-router-dom';
import "./PetTable.css"

const PetTable = () => {
    const [pets, setPets] = useState([]);
    const [owners, setOwners] = useState([]);
    const [currentSpecies, setCurrentSpecies] = useState("NONE");
    const [currentOwner, setCurrentOwner] = useState(0);
    const species = pets.map(pet => pet.species);
    let uniqueSpecies = species.filter((item, index) => species.indexOf(item) === index);
    uniqueSpecies.unshift("NONE");

    const reduxDispatch = useDispatch();

    const history = useHistory();
    const location = useLocation();
    const ownerIdFromStore = useSelector(state => state.ownerId);

    const loadPetsForOwner = (ownerId) => {
        getPetsForOwner(ownerId)
        .then((response) => {
            setPets(response.data);
        })
    }

    useEffect(() => {
        getOwners()
        .then((response) => {
            const ownerIdFromURL = new URLSearchParams(location.search).get("ownerId");
            if (ownerIdFromURL != null){
                setCurrentOwner(ownerIdFromURL);
                setOwners(response.data);
                loadPetsForOwner(ownerIdFromURL);
                reduxDispatch({type: "add-pet", value: ownerIdFromURL})
                console.log(ownerIdFromURL);
            } else if (ownerIdFromStore !== 0){
                setCurrentOwner(ownerIdFromStore);
                setOwners(response.data);
                loadPetsForOwner(ownerIdFromStore);
                reduxDispatch({type: "add-pet", value: ownerIdFromStore})
                console.log(ownerIdFromStore);
            } else {
                setCurrentOwner(response.data[0].id);
                setOwners(response.data);
                loadPetsForOwner(response.data[0].id);
                reduxDispatch({type: "add-pet", value: response.data[0].id })
            }

        })
    }, [])
    
    const changeOwner = (e) => {
        loadPetsForOwner(e.target.value);
        setCurrentOwner(e.target.value);
        setCurrentSpecies("NONE");
        reduxDispatch({type: "add-pet", value: e.target.value});
        history.push(`/pet?ownerId=${e.target.value}`);
    }

    const changeSpecies = (e) => {
        setCurrentSpecies(e.target.value);
    }

    const addPet = () => {
        reduxDispatch({type: "add-pet", value: currentOwner })
    }

    return (
        <div className="petTable">
            <label htmlFor="ownerSelect" > Select Owner: </label>
            <select value={currentOwner} id="ownerSelect" onChange={changeOwner}>
                {owners.map((owner) => {
                    return (<option key={owner.id}  value={owner.id}> {owner.id} </option>)
                })}
            </select>
            <label htmlFor="speciesSelect"> Select species: </label>
            <select value={currentSpecies} id="speciesSelect" onChange={changeSpecies}>
                {/* <option disabled >SELECT</option> */}
                {uniqueSpecies.map((species, index) => {
                    return (<option key={index}  value={species}> {species} </option>)
                })}
            </select>

            { (pets.length === 0) ? <p>No pets for this owner! :(</p> :
            <div>
                <h3 className="tableTitle">Pets Table</h3>
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
        </div>
    );
}

export default PetTable;