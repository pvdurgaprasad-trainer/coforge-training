import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import './Header.css'

export default function Header() {
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
}
