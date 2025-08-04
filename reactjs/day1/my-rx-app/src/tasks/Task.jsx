import React from 'react'
import { useState } from 'react'

export default function Task({addTodo}) {
    const [task, setTask] = useState('');

    const addTask = () => {
        addTodo(task);
        setTask('');
    }
    return (
        <div>
            This is child
            <input type="text" value={task} onChange={(event)=>setTask(event.target.value)}/>
            <input type="button" value="addTask" onClick={addTask} />
        </div>
    )
}
