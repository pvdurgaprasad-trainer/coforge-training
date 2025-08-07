import React from 'react';
import { Link } from 'react-router-dom';

function Librarian() {
    const username = sessionStorage.getItem('username');
    const role = sessionStorage.getItem('role');
    if (role != 'librarian') {
        return (
            <div>you are not authorised please <Link to='/login'>Login</Link></div >
    );
    } else {
        return (
            <div>welcome Librarian {username}</div>
        );
    }
}

export default Librarian;