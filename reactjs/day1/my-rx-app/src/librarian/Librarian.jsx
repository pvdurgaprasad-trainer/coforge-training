import React from 'react'
import { useState } from 'react';

export default function Librarian() {
  const [employees, setEmployees] = useState([{
    'id': '1',
    'name': 'durga',
    'salary': 100
  }, {
    'id': '2',
    'name': 'prasad',
    'salary': 200
  }]);
  const showEmpId = (emp) => {
    console.log(emp.id);
  }
  return (
    <div>
      {employees.map(emp => (
        <div>
          <div>{emp.name}</div>
          <div>{emp.salary}</div>
          <div><input type="button" value="update" onClick={()=>showEmpId(emp)} /></div>
          <hr />
        </div>
      ))}
    </div>
  )
}
