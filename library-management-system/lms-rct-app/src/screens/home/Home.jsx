import React from 'react';
import {Button} from "react-bootstrap";
import {Outlet} from "react-router-dom";
import Header from '../../componenents/header/Header';

function Home() {

    return (
        <div>
            <Header/>
            <Outlet/>
        </div>
    );
}

export default Home;