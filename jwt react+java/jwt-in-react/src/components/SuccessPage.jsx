import { useLocation } from "react-router-dom";

function SuccessPage(props){
let location =useLocation();
let userData=location.state?.userData;
// console.log(newData);
    return(
        <>
        <p>
           {alert(' Successfully logged in.')}
           {userData.username}
           
        </p>
        </>
    )
}
export default SuccessPage;