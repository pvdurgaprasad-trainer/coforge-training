import React from 'react'

export default function Child(props) {
  return (
    <div>
      Child: {props.messageFromParent}
    </div>
  )
}
