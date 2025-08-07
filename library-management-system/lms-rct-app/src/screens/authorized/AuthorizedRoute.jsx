import React from 'react'
import { useAuth } from './AuthContext';
import Login from '../login/Login';
import { Outlet } from 'react-router-dom';
import Customer from '../customer/Customer';

export default function AuthorizedRoute() {
 const data = useAuth();
 console.log('role',data.role);
  return data.role!='' ? <Outlet /> : <Login/>;
}
