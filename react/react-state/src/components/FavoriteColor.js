import { useState } from "react";

function favoriteColor() {
    // let color = 'Red';
    // eslint-disable-next-line react-hooks/rules-of-hooks
    const [color, setColor] = useState('Red')
    return  <>
                <h1>My favorite Color is {color}</h1>
                <button onClick={() => {setColor('Blue')}}>Change color</button>
            </>
}

export default favoriteColor;