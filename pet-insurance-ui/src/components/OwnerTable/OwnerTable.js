import {getOwners} from "../../data/rest";
import {useEffect, useState} from "react";
import {Link} from "react-router-dom";

const OwnerTable = () => {

    const [owners, setOwners] = useState([]);

    useEffect(() => {
        getOwners()
            .then((response) => {
                setOwners(response.data);
            })
    }, [])

    return (
        <div>
            <div>
                <h3>Owners Table</h3>
                <table>
                    <thead>
                    <tr>
                        <th> Id </th>
                        <th> Name </th>
                        <th> Age </th>
                        <th> Address </th>
                        <th> Email </th>
                        <th> Phone </th>
                        <th> Policy Number </th>
                        <th> Pet Count </th>
                    </tr>
                    </thead>

                    <tbody>
                    {owners.map((owner, index) => {
                        return (
                            <tr key={index}>
                                <td>{owner.id}</td>
                                <td>{owner.name}</td>
                                <td>{owner.age}</td>
                                <td>{owner.address}</td>
                                <td>{owner.email}</td>
                                <td>{owner.phone}</td>
                                <td>{owner.policyNumber}</td>
                                <td><Link to={"/pet?ownerId=" + owner.id}>{owner.pets.length}</Link></td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    );

};

export default OwnerTable;