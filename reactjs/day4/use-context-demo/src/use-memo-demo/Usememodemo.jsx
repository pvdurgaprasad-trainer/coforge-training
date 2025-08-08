import { useState } from 'react';

export default function Usememodemo() {
  const [counter, setCounter] = useState(0);
  
  const incremenet = () => {
    console.log('increment');
    setCounter(counter + 1);
  }

  const fact = (num) => {
    let result = 1;
    for (let i = num; i >= 1; i--) {
      result = result * i;
    }
    console.log('factorial-->' + result);
  }
  const showfact = fact(counter);
  // const showfact = useMemo(()=>{fact(counter)},[counter]);
  return (
    <div>
      <input type="button" value="+" onClick={incremenet} />
      <input type="text" value={counter} onChange={(e) => setCounter(e.target.value)} />
    </div>
  )
}
