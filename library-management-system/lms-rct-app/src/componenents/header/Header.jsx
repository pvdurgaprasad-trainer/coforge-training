import React from 'react'
import { Button, Container, Nav, Navbar } from 'react-bootstrap'
import './Header.css'
import { useAuth } from '../../screens/authorized/AuthContext'
import { useNavigate } from 'react-router-dom';

export default function Header() {
  const auth = useAuth();
  const role = sessionStorage.getItem('role')
  const navigate = useNavigate();

  const handleLogOut = () => {
    console.log('logout');
    auth.setUsername('');
    auth.setRole('');
    sessionStorage.removeItem('role');
    sessionStorage.removeItem('username');
    navigate('/login');
  }
  if (role==null || role == '') {
    return (
      <div>
        <Navbar bg="primary" data-bs-theme="dark">
          <Container>
            <Navbar.Brand href="/">LMS App</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="login">Login</Nav.Link>
              <Nav.Link href="register">Register</Nav.Link>
            </Nav>
          </Container>
        </Navbar>
        Welcome to LMS APP
      </div>
    )
  } else if (role == 'librarian') {
    return (
      <div>
        <Navbar bg="primary" data-bs-theme="dark">
          <Container>
            <Navbar.Brand href="/">LMS App</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="books">View Books</Nav.Link>
              <Nav.Link href="requests">View Requests</Nav.Link>
              <Button variant="danger"  onClick={handleLogOut}>Logout</Button>
            </Nav>
          </Container>
        </Navbar>
        Welcome to LMS APP
      </div>
    )
  } else if (role == 'customer') {
    return (
      <div>
        <Navbar bg="primary" data-bs-theme="dark">
          <Container>
            <Navbar.Brand href="/">LMS App</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="books">View Books</Nav.Link>
              <Nav.Link href="requests">View Requests</Nav.Link>
              <Button variant="danger"  onClick={handleLogOut}>Logout</Button>
            </Nav>
          </Container>
        </Navbar>
        Welcome to LMS APP
      </div>
    )
  }

}
