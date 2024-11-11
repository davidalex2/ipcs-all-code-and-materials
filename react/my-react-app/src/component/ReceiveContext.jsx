import { useContext } from 'react';
import { SendValues } from './GetValues'; // Correct the import path

function DisplayComponent() {
  
  return (
    <>
      <SendValues.Consumer>
        {({ course }) => <h2>Course: {course}</h2>}
      </SendValues.Consumer>
    </>
  );
}

export default DisplayComponent;