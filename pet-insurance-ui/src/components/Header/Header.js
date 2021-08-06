import {Link} from 'react-router-dom'
import "./Header.css"

const Header = () => {
    return (
        <div className="header">

            <span><Link to="/"><h1> Pet Insurance</h1></Link></span>
            <span><Link to="/pet"><h2> Manage Pets</h2></Link></span>
            <span><Link to="/addOwner"><h2> Add Owner</h2></Link></span>
            <span><Link to="/addPet"><h2> Add Pet</h2></Link></span>


        </div>
    )
}

export default Header;