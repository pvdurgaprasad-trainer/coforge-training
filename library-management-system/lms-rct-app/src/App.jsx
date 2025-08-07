import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';
import AuthorizedRoute from './screens/authorized/AuthorizedRoute.jsx';
import Customer from './screens/customer/Customer.jsx';
import Home from "./screens/home/Home.jsx";
import Librarian from './screens/librarian/Librarian.jsx';
import Login from "./screens/login/Login.jsx";
import Register from './screens/register/Register.jsx';
import AuthProvider from './screens/authorized/AuthContext.jsx';
import Books from './screens/books/Books.jsx'
import Requests from './screens/requests/Requests.jsx'

function App() {
  return (
    <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route element={<AuthorizedRoute />}>
              <Route path="/librarian" element={<Librarian />} />
              <Route path="/customer" element={<Customer />} />
              <Route path="/books" element={<Books />} />
              <Route path="/requests" element={<Requests />} />
            </Route>

          </Route>
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  )
}

export default App
