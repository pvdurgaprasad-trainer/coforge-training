import React from 'react';
import { useState } from 'react';
import { Button, Container, Form, Stack } from 'react-bootstrap';
import { useAuth } from '../authorized/AuthContext';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const auth = useAuth();
    const handleLogin = () => {
        var data = {
            'username': username,
            'password': password
        }
        if (username === password && username === 'admin') {
            auth.setUsername(data.username);
            auth.setRole('librarian');
            navigate('/librarian');
        } else {
            auth.setUsername(data.username);
            auth.setRole('customer');
            navigate('/customer');
        }
    }
    return (
        <div>
            Login:
            <Container><Form.Group className="mb-3">
                <Form.Label>username:</Form.Label>
                <Form.Control type="text" placeholder="username" value={username} onChange={(e) => setUsername(e.target.value)} />
            </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>password:</Form.Label>
                    <Form.Control type="text" placeholder="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </Form.Group>
                <Stack direction='horizontal' gap={3}>
                    <Button variant='primary' type="button" onClick={handleLogin}>Login</Button>
                    <Button variant='danger' type='reset'>reset</Button>
                </Stack>
            </Container>
        </div>
    );
}

export default Login;