import { Outlet } from 'react-router-dom';
import Login from '../login/Login';

export default function AuthorizedRoute() {
  const role = sessionStorage.getItem('role');
  console.log('role', sessionStorage.getItem('role'));
  return role != '' ? <Outlet /> : <Login />;
}
