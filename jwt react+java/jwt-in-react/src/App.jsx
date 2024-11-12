import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import LoginForm from './components/LoginForm'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Homepage from './components/HomePage'
import SuccessPage from './components/SuccessPage'
import Logout from './components/Logout'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/* <LoginForm></LoginForm> */}
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<Homepage/>}>
        <Route path='/success' element={<SuccessPage></SuccessPage>}></Route>
        <Route path='/login' element={<LoginForm></LoginForm>}></Route>
      
        </Route>
      </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
