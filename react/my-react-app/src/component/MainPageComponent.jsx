import { Link, Outlet } from "react-router-dom";


function RouterComponent(){
    return(

        <>
        <p>This is the router component.</p>
        <p><Link to='/'>Home</Link></p>
        <p ><Link to='/clock'>Clock</Link> </p>
        <p><Link to='/contact'>Contact</Link></p>
        <Outlet/>
        </>
    );
}
export default RouterComponent;