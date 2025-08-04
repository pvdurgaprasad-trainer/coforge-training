import React from 'react'
import { useState } from 'react'
import Task from '../tasks/Task';

export default function Planner() {
    const [todos, setTodos] = useState([]);
    const assignPlanner = (task) => {
        setTodos([...todos, task]);
    }
    return (
        <div>
            This is parent
            {todos.map(task => (
                <div>
                    <div>{task}</div>
                </div>
            ))}
            <hr />
            <Task addTodo={assignPlanner}></Task>
        </div>
    )
}
