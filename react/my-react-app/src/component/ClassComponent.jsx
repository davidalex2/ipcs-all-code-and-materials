import React from "react";

 class NewClass extends React.Component {
  render() {
    return (
      <>
      
        <div>Hello, this is a new class component.</div>
        <SampleFunction></SampleFunction>
      </>
    );
  }
}
export function SampleFunction(){
    return (
      <>
        <div>Hello, this is a sample function component.</div>
      </>
    );
  
}

export default NewClass;

