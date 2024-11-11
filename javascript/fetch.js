// // const baseURL = 'https://my-json-server.typicode.com/davidalex2/json-server/students';
// const baseURL = 'http://localhost:3000/students';

// // Function to create a new student
// function createStudent(studentData) {
//     fetch(baseURL, {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(studentData),
//     })
//     .then(response => response.json())
//     .then(data => {

//       if(data!=null){
//         // document.preventDefault();
//         form_add.reset();
//         form_add.style.display='none';
//         btn.style.display='block';
//         this.getAllStudents();
//       }
//     })
//     .catch(error => console.error('Error:', error));
// }

// // Function to get all students
// function getAllStudents() {
//     fetch(baseURL)
//         .then(response => response.json())
//         .then(data => {
//           console.log('All Students:', data);
//          this.toDisplay(data);

//         })
//         .catch(error => console.error('Error:', error));
// }

// // Function to get a student by ID
// function getStudentById(id) {
//     fetch(`${baseURL}/${id}`)
//         .then(response => response.json())
//         .then(data => console.log('Student:', data))
//         .catch(error => console.error('Error:', error));
// }

// // Function to update a student by ID
// function updateStudentById(id, updatedData) {
//     fetch(`${baseURL}/${id}`, {
//         method: 'PUT',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(updatedData),
//     })
//     .then(response => response.json())
//     .then(data => console.log('Student Updated:', data))
//     .catch(error => console.error('Error:', error));
// }

// // Function to delete a student by ID
// function deleteStudentById(id) {
//     fetch(`${baseURL}/${id}`, {
//         method: 'DELETE',
//     })
//     .then(() => console.log('Student Deleted'))
//     .catch(error => console.error('Error:', error));
// }


// // createStudent(newStudent);
// getAllStudents();

// // updateStudentById(1, updatedData);
// // deleteStudentById(1);

// let btn=document.getElementById('create-btn');
// let form_add = document.getElementById('create-form');
// btn.addEventListener('click', function(event){
//   event.preventDefault();
//   form_add.style.display='block';
//   btn.style.display='none';
// } 
// );
// let btn_s=document.getElementById("btn_s");
// btn_s.addEventListener('click',(event)=>{
//   event.preventDefault();
//   form_add.style.display='none';
//   btn.style.display='block';
//   let name=document.getElementById('name').value;
//   let class_n=document.getElementById('class_n').value;
//   let email=document.getElementById('email').value;
//   let mobile=document.getElementById('mobile').value;
  
//   let newStudent = {
//     name,
//     class_n,
//     email,
//     mobile
//   }

// createStudent(newStudent);
  

// });

// function toDisplay(data){
//   let table=document.getElementById('student-table');
//   let tableRows='';
//   data.forEach((student, index) => {
//     let row = `
//             <tr>
//                 <td>${index + 1}</td>
//                 <td>${student.name}</td>
//                 <td>${student.class_n}</td>
//                 <td>${student.email}</td>
//                 <td>${student.mobile}</td>
//                 <td>
//                     <button onclick="editStudent(${student.id})">Edit</button>
//                     <button onclick="deleteStudentById(${student.id})">Delete</button>
//                 </td>
//             </tr>
//         `;
//         tableRows += row;
//   });


//   table.innerHTML = tableRows;


//     let editBtn = document.createElement('button');
//     editBtn.textContent = 'Edit';
//     editBtn.addEventListener('click', () => {
//       // Update student data here
//       console.log('Edit student:', student);
//     });
//     row.insertCell().appendChild(editBtn);

//     let deleteBtn = document.createElement('button');
//     deleteBtn.textContent = 'Delete';
//     deleteBtn.addEventListener('click', () => {
//       deleteStudentById(student.id);
// });
// }
