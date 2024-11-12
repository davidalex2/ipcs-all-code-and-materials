import axios from 'axios';
import React, { useState } from 'react';
import SuccessPage from './SuccessPage';
import { Navigate, useNavigate } from 'react-router-dom';

const baseURL = 'http://localhost:8086/auth/login';


const LoginForm = () => {
    const [username, setName] = useState('');
    const [password, setPassword] = useState('');
    const [myLogin,setLogin]=useState(true);
    let navigate=useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        // Here you can handle the form submission, e.g., send data to your server
        console.log('Name:', username);
        console.log('Password:', password);
        let myData = { username, password };
        let response = await axios.post(baseURL, myData);
        console.log(response.data);
        if(response){
          navigate('/success', { state: { userData: response.data } });
          setLogin(false);
        }else{
            alert("Login failed");
        }

        // Reset form fields
        setName('');
        setPassword('');
    };


    return (
        <>
        { myLogin && (
            
            <form onSubmit={handleSubmit}>
                <h2>Login Form</h2>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setName(e.target.value.trim())}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value.trim())}
                        required/>
                </div>
                <button type="submit">Submit</button>
            </form>
        )}

        </>
    );
};

export default LoginForm;