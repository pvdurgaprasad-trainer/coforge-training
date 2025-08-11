import { createContext, useState } from 'react'
import './App.css'
import Login from './login/Login'
import { BrowserRouter, Outlet, Route, Routes } from 'react-router-dom';
import Cusotmer from './cusomter/Cusotmer';
import Usememodemo from './use-memo-demo/Usememodemo';
import Librarian from './librarian/Librarian';
import Home from './home/Home';

export const UserContext = createContext(null);

function App() {
  const [user, setUser] = useState('');
  const [bgColor,setBgColor] = useState('yellow');
  return (
    <div>      
      <UserContext.Provider value={{user,setUser,bgColor,setBgColor}}>
        <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/librarian" element={<Librarian/>}/>
          <Route path="/customer" element={<Cusotmer/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/usememo" element={<Usememodemo/>}/>
        </Routes>
      </BrowserRouter>
        <Outlet />
      </UserContext.Provider>
    </div>
  )
}

export default App
