import React from 'react'
import Child from '../child/Child'
import { useState } from 'react';

export default function Parent() {
    const [progName,setProgName] = useState('reactjs programming');
    return (
        <div>
            This is parent <br /><br /><br />
            <Child messageFromParent={progName}></Child>
        </div>
    )
}


