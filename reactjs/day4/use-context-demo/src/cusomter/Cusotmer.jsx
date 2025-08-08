import React, { useContext } from 'react'
import { UserContext } from '../App';

export default function Cusotmer() {
  const data = useContext(UserContext);
  return (
    <div>{data.user}</div>
  )
}
