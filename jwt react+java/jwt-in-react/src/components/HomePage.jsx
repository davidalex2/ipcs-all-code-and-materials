import { Link, Outlet, useNavigate } from "react-router-dom";
import LoginForm from "./LoginForm";
import "./css/HomePage.css";

function Homepage() {

    const navigate = useNavigate();

    const handleLogout = () => {
    
        localStorage.clear();
        // navigate('/login');
    };
    return (
        <>
            <p>This is the homepage</p>
            <ul>
                <li>
                    <Link to={'/'}>My Home</Link>
                </li>
                <li>
                    <Link to={'/success'}>Dashboard</Link>

                </li>
                <li>
                    <Link to={'/login'}>Login</Link>
                </li>
                <li ><button onClick={handleLogout} >Logout</button></li>
            </ul>
            <Outlet></Outlet>
        </>
    );
}
export default Homepage;