import React from 'react'
import { useContext } from 'react';
import { useState } from 'react'
import { UserContext } from '../App';
import { useNavigate } from 'react-router-dom';

export default function Login() {

    const [username, setUsername] = useState('');
    const data = useContext(UserContext);
    const navigate = useNavigate();
    const handleSubmit = () => {
        data.setUser(username);
        navigate('/home');
    }
    return (
        <div>
            <input type="text" placeholder='username'
                value={username} onChange={(e) => setUsername(e.target.value)} />
            <button onClick={handleSubmit}>ClickMe</button>
        </div>
    )
}
