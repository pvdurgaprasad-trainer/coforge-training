import React from 'react';

function Customer() {
    const username = sessionStorage.getItem('username');
    return (
        <div>welcome Customer {username}</div>
    );
}

export default Customer;