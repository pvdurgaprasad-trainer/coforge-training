import React from 'react'
import { useContext } from 'react';
import { Link } from 'react-router-dom';
import { UserContext } from '../App';
export default function Home() {
    const data = useContext(UserContext);
    return (
      <div>Welcome {data.user}
      <br/>
      <Link to="/librarian">librarian</Link>&nbsp;&nbsp;
      <Link to="/customer">customer</Link>&nbsp;&nbsp;
      <Link to="/usememo">UseMemo</Link>
      </div>
     
    )
}
