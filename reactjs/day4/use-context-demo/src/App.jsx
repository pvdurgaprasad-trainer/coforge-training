import { createContext, useState } from 'react'
import './App.css'
import Login from './login/Login'
import { BrowserRouter, Outlet, Route, Routes } from 'react-router-dom';
import Cusotmer from './cusomter/Cusotmer';

export const UserContext = createContext(null);

function App() {
  const [user, setUser] = useState('');
  return (
    <div>      
      <UserContext.Provider value={{user,setUser}}>
        <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/customer" element={<Cusotmer/>}/>
        </Routes>
      </BrowserRouter>
        <Outlet />
      </UserContext.Provider>
    </div>
  )
}

export default App
