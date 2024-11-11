import { Link, Outlet } from "react-router-dom";
import './css/Homepage.css';

function HomeContent(){
return(
<>
<p>This is the home page</p>

<nav>
    <ul>
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/video'>Video</Link></li>
        <li><Link to='/context'>Context</Link></li>
        <li><Link to='/view'>View</Link></li>
        <li><Link to='/ui'>UI</Link></li>
    </ul>
</nav>
<Outlet />
</>
);
}
export default HomeContent;