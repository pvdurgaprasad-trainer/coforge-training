import React from 'react'
import { useState } from 'react'

export default function Customer() {
  const [customerName,setCustomerName]  = useState('durga');

  const updateCustomerName =(event)=>{
    setCustomerName(event.target.value);
  };

  return (
    <div>
     <input type="text" placeholder='enter name' onKeyUp={updateCustomerName}/><br/>
      Welcome {customerName}
    </div>
  )
}
