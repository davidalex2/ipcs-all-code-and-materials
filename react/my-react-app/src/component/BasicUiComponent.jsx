import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button'
import { useState } from 'react';

function BasicUi(){
  let [mail, setMail] = useState('');
  let [password, setPassword] = useState('');
  let handleClick=function(e){
    e.preventDefault();
    console.log('mail:',mail);
    console.log('password:',password);
    setMail('');
    setPassword('');
     }
    return(
       
      <>
      <Form onSubmit={handleClick}>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" onChange={e=>setMail(e.target.value)} value={mail} placeholder="name@example.com" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
        <Form.Label>Example password</Form.Label>
        <Form.Control type="password" onChange={e=>setPassword(e.target.value)} value={password} placeholder='Password' />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlText3">
      <Button variant="primary" type='submit' >
        Submit
      </Button>
      </Form.Group>
      </Form>
      </>
  )
}
export default BasicUi;