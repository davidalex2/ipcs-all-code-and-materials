import React, { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import './css/Crud.css';
import CallFunction2 from './CRUDoperation2';

const baseURL = 'http://localhost:1024/api/users';

const fetchStudents = async () => {
  const response = await axios.get(baseURL);
  // console.log(response);
  return response.data;
};

function CallFunction3() {
  const { data: studentsData, error, isLoading, refetch } = useQuery({
    queryKey: ['users'],
    queryFn: fetchStudents,
  });
  
  const [modalVisible, setModalVisible] = useState(false);
  const [currentStudent, setCurrentStudent] = useState(null);
  const [newStudent, setNewStudent] = useState({ _id: '', name: ''
    , mobile: '', email: '', class_n: '',status:'',createdAt:'' });

  const handleDelete = async (id) => {
    await axios.delete(`${baseURL}/${id}`);
    refetch();
  };

  const handleEdit = (student) => {
    setCurrentStudent(student);
    setNewStudent(student);
    setModalVisible(true);
  };

  const handleUpdate = async (updatedData) => {
    await axios.put(`${baseURL}/${currentStudent.id}`, updatedData);
    setModalVisible(false);
    setCurrentStudent(null);
    refetch();
  };

  const handlePost = async () => {
    await axios.post(baseURL, newStudent);
    setModalVisible(false);
    setNewStudent({ _id: '', name: '', mobile: '', email: ''
      , class_n: '',status:'',createdAt:'' });
    refetch();
  };

  if (isLoading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  return (
    <>
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
          {studentsData.map(student => (
            <tr key={student.id}>
              <td>{student.id}</td>
              <td>{student.name}</td>
              <td>{student.mobile}</td>
              <td>{student.email}</td>
              <td>{student.class_n}</td>
              <td>{student.status}</td>
              <td>{student.createdAt}</td>
              <td>
                <button onClick={() => handleDelete(student.id)}>Delete</button>
                <button onClick={() => handleEdit(student)}>Edit</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <button onClick={() => { 
        setNewStudent({ _id: '', name: '', mobile: '', email: '', class_n: '',status:'',createdAt:'' });
       setModalVisible(true); }}>Add Student</button>

      {modalVisible && (
        <div className="modal">
          <div className="modal-content">
            <h2>{currentStudent ? 'Edit Student' : 'Add Student'}</h2>
            <label>ID:</label>
            <input type="text" value={newStudent.id} onChange={(e) => setNewStudent({ ...newStudent, id: e.target.value })} /><br />
            <label>Name:</label>
            <input type="text" value={newStudent.name} onChange={(e) => setNewStudent({ ...newStudent, name: e.target.value })} /><br />
            <label>Mobile:</label>
            <input type="text" value={newStudent.mobile} onChange={(e) => setNewStudent({ ...newStudent, mobile: e.target.value })} /><br />
            <label>Email:</label>
            <input type="text" value={newStudent.email} onChange={(e) => setNewStudent({ ...newStudent, email: e.target.value })} /><br />
            <label>Class:</label>
            <input type="text" value={newStudent.class_n} onChange={(e) => setNewStudent({ ...newStudent, class_n: e.target.value })} /><br />
            <label>Status:</label>
            <input type="text" value={newStudent.status} onChange={(e) => setNewStudent({ ...newStudent, status: e.target.value })} /><br />
          
            <div className="modal-actions">
              <button onClick={currentStudent ? () => handleUpdate(newStudent) : handlePost}>
                {currentStudent ? 'Update' : 'Add'}
              </button>
              <button onClick={() => setModalVisible(false)}>Cancel</button>
            </div>
         </div>
       </div>
      )
      }
       </>
  );
}
export default CallFunction3;
            