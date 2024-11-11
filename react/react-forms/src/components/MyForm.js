import { useState } from "react";

function MyForm() {
    // const [name, setName] = useState();
    // const [age, setAge] = useState();
    // const [email, setEmail] = useState();
    // console.log('Current state', name);
    const [inputs, setInputs] = useState({phone:"+91", email:"@gmail.com", country:"India", about:"I am a student"});

    function handleSubmit(e) {
        e.preventDefault();
        console.log('Form Submitted!');
        // console.log('Current state', name,age,name);
        console.log('Current state', inputs);
    }

    function handleChange(e) {
        const name = e.target.name
        const value = e.target.value
        setInputs( (previousState) => { return {...previousState,[name] : value}})
    }

    return <form onSubmit={handleSubmit}>
        <label> Enter your name: <input type="text" name="name" onChange={handleChange}  /></label><br/>
        <label> Enter your age: <input type="text" name="age" onChange={handleChange}  /></label><br/>
        <label> Enter your email: <input type="text" name="email" onChange={handleChange} value={inputs.email} /></label><br/>
        <label> Enter your phone: <input type="text" name="phone" onChange={handleChange} value={inputs.phone} /></label><br/>
        <label> Enter your country: 
            <select name="country" onChange={handleChange} value={inputs.country} >
                <option value="">select</option>
                <option value="Australia">Australia</option>
                <option value="India">India</option>
                <option value="United States">United States</option>
            </select></label><br/>
        <label> Enter about you: <textarea name="about" onChange={handleChange} value={inputs.about} /></label><br/>
        <input type="submit" value="Submit Form"/>
    </form>
}

export default MyForm;