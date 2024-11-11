import React, { useState, useEffect } from 'react';
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

import './css/Crud.css';

const baseURL = 'http://localhost:3000/students';

const fetchStudents = async () => {
  const response = await axios.get(baseURL);
  return response.data;
};

function CallFunction() {
  const { data: mydata, error, isLoading } = useQuery({
    queryKey: ['students'],
    queryFn: fetchStudents,
  });

  const [studentsData, setStudentsData] = useState([]);
  const [modalVisible, setModalVisible] = useState(false);
  const [currentStudent, setCurrentStudent] = useState(null);

  useEffect(() => {
    if (mydata) {
      setStudentsData(mydata);
    }
  }, [mydata]);

  const handleDelete = async (id) => {
    try {
      await axios.delete(`${baseURL}/${id}`);
      setStudentsData((prevData) => prevData.filter(student => student.id !== id));
    } catch (err) {
      console.error("Error deleting student:", err);
    }
  };

  const handleEdit = (id) => {
    const studentToEdit = studentsData.find(student => student.id === id);
    setCurrentStudent(studentToEdit);
    setModalVisible(true);
  };

  const handleUpdate = async (updatedData) => {
    try {
      await axios.put(`${baseURL}/${currentStudent.id}`, updatedData);
      setStudentsData((prevData) =>
        prevData.map(student => student.id === currentStudent.id ? { ...student, ...updatedData } : student)
      );
      setModalVisible(false);
      setCurrentStudent(null);
    } catch (err) {
      console.error("Error updating student:", err);
    }
  };

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;
  if (studentsData.length > 0) {
    return (
      <>
        <DisplayFunction mydata={studentsData} handleDelete={handleDelete} handleEdit={handleEdit} />
        {modalVisible && (
          <EditModal 
            student={currentStudent} 
            onUpdate={handleUpdate} 
            onClose={() => setModalVisible(false)} 
          />
        )}
      </>
    );
  } else {
    return <div>No Students Found</div>;
  }
}

const DisplayFunction = ({ mydata, handleDelete, handleEdit }) => {
  return (
    <>
    <input type="text" onChange={(e)=>setStudentsData(e.target.value)}/>// need to check twise to search
    <h2>Student List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mobile</th>
            <th>Email</th>
            <th>Class</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {mydata.map(item => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.mobile}</td>
              <td>{item.email}</td>
              <td>{item.class_n}</td>
              <td>
                <button onClick={() => handleDelete(item.id)}>Delete</button>
                <button onClick={() => handleEdit(item.id)}>Edit</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

const EditModal = ({ student, onUpdate, onClose }) => {
  const [name, setName] = useState(student.name);
  const [mobile, setMobile] = useState(student.mobile);
  const [email, setEmail] = useState(student.email);
  const [class_n, setClassName] = useState(student.class_n);

  const handleSubmit = () => {
    onUpdate({ name, mobile, email, class_n: class_n });
  };

  return (
    <div className="modal">
      <div className="modal-content">
        <h2>Edit Student</h2>
        <label >Name:</label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} /><br />

        <label>Mobile:</label>
        <input type="text" value={mobile} onChange={(e) => setMobile(e.target.value)} /><br/>

        <label>Email:</label>
        <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} /><br/>

        <label>Class:</label>
        <input type="text" value={class_n} onChange={(e) => setClassName(e.target.value)} /><br/>

        <div className="modal-actions">
          <button onClick={handleSubmit}>Update</button>
          <button onClick={onClose}>Cancel</button>
        </div>
      </div>
    </div>

//     <>
//     <div className='model'>

//       <div className="modal-content">
//       <table >
//   <tr>
//     <td> <label >Name:</label></td>
//     <td><input type="text" value={name} onChange={(e) => setName(e.target.value)} /><br />
//     </td>
//   </tr>
//   <tr>
//     <td><label>Mobile:</label></td>
//     <td><input type="text" value={mobile} onChange={(e) => setMobile(e.target.value)} /><br/>
//     </td>
//   </tr>
//   <tr>
//     <td><label>Email:</label></td>
//     <td> <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} /><br/>
//     </td>
//   </tr>
//   <tr>
//     <td><label>Class:</label></td>
//     <td><input type="text" value={className} onChange={(e) => setClassName(e.target.value)} /><br/>
//     </td>
//   </tr>
//   <tr  >
//     <td>  
//           <button onClick={handleSubmit}>Update</button>
       
//      </td>
//     <td><button onClick={onClose}>Cancel</button></td>
//   </tr>
// </table>
//       </div>
//     </div>
//     </>
  );
};
export default CallFunction;