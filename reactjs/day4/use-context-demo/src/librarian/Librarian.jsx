import React from 'react'
import { useContext } from 'react';
import { UserContext } from '../App';

export default function Librarian() {
  const data = useContext(UserContext);
    return (
      <div>{data.user}</div>
    )
}
