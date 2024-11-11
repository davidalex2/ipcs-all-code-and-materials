import { useEffect, useState } from 'react';
import myvideo from '../assets/vid1.mp4';
import ClassComponent from './ClassComponent';
import DisplayComponent from './DisplayComponent';
import ErrorMessage from './ErrorComponent';
import MyProps from './PropsComponent';
import AnalogClock from './AnologClockComponent';
import ReactDom from 'react-dom/client';

function MyVideo(){
 let videosrc=myvideo;
 let name='';
 const [myname,setMyname]=useState('david');
//  const [count,setCount]=useState(0);
//  const[oldTime,setOldTime]=useState(new Date.toLocaleDateString());
 const [timer,setTimer]=useState(0);
 useEffect(()=>{
    const intervalId = setInterval(() => {
        setTimer(new Date().toLocaleTimeString());
        // setCount(count+1);
      });
  
      return () => clearInterval(intervalId);
    }, []);
    return (
        <>
        <p>{timer}
            <br />
         
        </p>
        <p>
            <ErrorMessage></ErrorMessage>
        </p>


       <h1>Hello, this is react class.</h1>
       <p>This is the first class</p>
       <video src={videosrc} width="400" height="400" controls autoPlay="true"></video>
       
       <p>
       {
        name!='' && name!=null && name!=undefined ?(
            <DisplayComponent />

        ):(<ErrorMessage />)//shorten if else for conditional rendering
       }
      
       
       </p>
       <ClassComponent></ClassComponent>
       <input type="text" value={myname} onChange={(e)=>setMyname(e.target.value)}/>

<p>The new person's name is {myname}</p>
       <MyProps name={myname}></MyProps>
       

        </>
    );
}
// let root=ReactDom.createRoot(document.getElementById('root'));
// root.render(<MyVideo/>);
function CondionalFunction(){//normal function for condional rendering
    let name='';
   if(name!='' && name!=undefined && name!=null){
    return <DisplayComponent />

   }else{
    return <ErrorMessage />
   }

}

export default MyVideo;