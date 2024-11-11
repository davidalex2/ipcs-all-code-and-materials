import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css';
import VideoComponent from './component/VideoComponent';
import DisplayComponent from './component/ReceiveContext';
import  GetValues  from './component/GetValues';
import NewClass from './component/ClassComponent';
import {SampleFunction} from './component/ClassComponent';
import MyVideo from './component/VideoComponent';
import BasicUi from './component/BasicUiComponent';
import CallFunction from './component/CRUDoperation';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import GetAll from './component/CRUDoperation';
import CallFunction2 from './component/CRUDoperation2';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomeContent from './component/Hompage';
import ErrorMessage from './component/ErrorComponent';
import MyCrudComponent from './component/CrudRouting';

const queryClient=new QueryClient();

function App() {
  return (
<>


<BrowserRouter>
<Routes>
  {/* <Route path='/' element={
    <QueryClientProvider client={queryClient}>
        <CallFunction></CallFunction>
       <CallFunction2></CallFunction2>
    </QueryClientProvider>
  }>  */}
  <Route path='/' element={<HomeContent></HomeContent>}>
  <Route path='/video' element={<VideoComponent></VideoComponent>}/>
  <Route path='/context' element={<ErrorMessage></ErrorMessage>}/>
  <Route path='/view' element={<NewClass></NewClass>}/>
  <Route path='/ui' element={<MyCrudComponent></MyCrudComponent>}/>
  </Route>
</Routes>
</BrowserRouter>


</>
    
  );
}

export default App
