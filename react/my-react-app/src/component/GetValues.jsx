import { createContext } from "react";
import DisplayComponent from "./ReceiveContext"; // Ensure this path is correct
import ErrorMessage from "./ErrorComponent";

export let SendValues = createContext();

function GetValues() {
  let course = 'python';
  return (
    <SendValues.Provider value={{course}}>
      <DisplayComponent />
     {/* Include this component to handle the case when the course is empty */}
    </SendValues.Provider>
  );
}

export default GetValues;