// const baseURL = 'http://localhost:8082/students';
 const baseURL ='https://my-json-server.typicode.com/davidalex2/json-server/students';
let allStudentData=new Array();
getAllStudents();
// Function to create a new student
function createStudent(studentData) {
    fetch(`${baseURL}/`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(studentData),
    })
    .then(response => response.json())
    .then(data => {
        if (data != null) {
            form_add.reset();
            form_add.style.display = 'none';
            btn.style.display = 'block';
            allStudentData=data;
            toDisplay(allStudentData);
        } 
    })
    .catch(error => console.error('Error:', error));
}

// Function to get all students
function getAllStudents() {
    fetch(`${baseURL}/`)
        .then(response => response.json())
        .then(data => {
            allStudentData = data;  // Store all students in a global variable for future use
            console.log('All Students:', data);
            toDisplay(data);  // Call directly instead of using 'this'
        })
        .catch(error => console.error('Error:', error));
}

// Function to display students
function toDisplay(data) {
    let table = document.getElementById('tbody');
    

    data.forEach((student, index) => {
        if(student.id !=0){
            let row = document.createElement('tr');
            

        let index_s=document.createElement('td');
        index_s.textContent=index+1;
        let id_s=document.createElement('td');
        id_s.textContent=student.id;
        let name_s=document.createElement('td');
        name_s.textContent=student.name;
        let class_s=document.createElement('td');
        class_s.textContent=student.class_n;
        let email_s=document.createElement('td');
        email_s.textContent=student.email;
        let mobile_s=document.createElement('td');
        mobile_s.textContent=student.mobile;
        let edit_btn=document.createElement('button');
        // 
        // edit_btn.click(
        edit_btn.textContent='Edit';
        edit_btn.classList.add('edit-btn');
        edit_btn.addEventListener('click',function(){
            popup.style.display = "block";
            
            // updateOne(id_s);
            editStudent(id_s.textContent,name_s.textContent,class_s.textContent,email_s.textContent,mobile_s.textContent);
           

        });
        edit_btn.id='open-popup-btn';
        let delete_btn=document.createElement('button');
        delete_btn.click=function(){
            deleteStudentById(student.id);
            console.log(student.id);
        };
        delete_btn.textContent='Delete';
        delete_btn.id='close-popup-btn';
        let td_s=document.createElement('td');
        td_s.appendChild(edit_btn);
        td_s.appendChild(delete_btn);
        
        row.appendChild(index_s);
        row.appendChild(id_s);
        row.appendChild(name_s);
        row.appendChild(class_s);
        row.appendChild(email_s);
        row.appendChild(mobile_s);
        row.appendChild(td_s);
        table.appendChild(row);
        }
       
    });

   
}

var popup = document.getElementById("popup");

var openPopupBtn = document.getElementById("open-popup-btn");


var closePopupBtn = document.getElementById("close-popup-btn");

window.addEventListener('click', (event) =>{
    if (event.target == popup) {
        popup.style.display = "none";
    }
});

function editStudent(id,name,class_n,email,mobile) {
    document.getElementById('student-id').value = id; // Hidden input for the student ID
    document.getElementById('name_o').value = name;
    document.getElementById('class_o').value = class_n;
    document.getElementById('email_o').value = email;
    document.getElementById('mobile_o').value = mobile;
    console.log(id,name,class_n,mobile.innerText,email.innerText);

    // Show the form or popup to edit the student
    document.getElementById('popup').style.display = 'block';
    document.getElementById('update-btn').style.display = 'block';
    document.getElementById('create-btn').style.display = 'none'; // Hide the create button if necessary

    let updatedData = {
        name,
        class_n,
        email,
        mobile
    };
        
    updateStudentById(id, updatedData);




}
function updateOne(sid){
    let id = sid;
    console.log(sid);

    let name = document.getElementById('name').value;
    let class_n = document.getElementById('class_n').value;
    let email = document.getElementById('email').value;
    let mobile = document.getElementById('mobile').value;

    let updatedData = {
        name,
        class_n,
        email,
        mobile
    };

    updateStudentById(id, updatedData);
}
// Function to get a student by ID
function getStudentById(id) {
    fetch(`${baseURL}/${id}`)
        .then(response => response.json())
        .then(data => console.log('Student:', data))
        .catch(error => console.error('Error:', error));
}

// Function to update a student by ID
function updateStudentById(id, updatedData) {
    fetch(`${baseURL}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedData),
    })
    .then(response => response.json())
    .then(data => {
        
        console.log('Student Updated:')
        allStudentData=allStudentData.map(data=>data.id===id?updatedData:data);
        toDisplay(allStudentData); // Refresh the table after update
        
    
    })
    .catch(error => console.error('Error:', error));
}



// Function to delete a student by ID
function deleteStudentById(id) {
    fetch(`${baseURL}/${id}`, {
        method: 'DELETE',
    })
    .then(() => {
        console.log('Student Deleted');
        allStudentData=allStudentData.filter(data=>data.id!==id);
        toDisplay(allStudentData); // Refresh the table after deletion
    })
    .catch(error => console.error('Error:', error));
}



// Event listeners for form submission and buttons
let btn = document.getElementById('create-btn');
let form_add = document.getElementById('create-form');

btn.addEventListener('click', function(event) {
    event.preventDefault();
    form_add.style.display = 'block';
    btn.style.display = 'none';
});

// let btn_s = document.getElementById("btn_s");
// btn_s.addEventListener('click', (event) => {
//     event.preventDefault();
//     let name = document.getElementById('name').value;
//     let class_n = document.getElementById('class_n').value;
//     let email = document.getElementById('email').value;
//     let mobile = document.getElementById('mobile').value;

//     let newStudent = {
//         name,
//         class_n,
//         email,
//         mobile
//     }

//     createStudent(newStudent);
// });

function addNewStudent(){
    event.preventDefault();
    let name = document.getElementById('name').value;
    let class_n = document.getElementById('class_n').value;
    let email = document.getElementById('email').value;
    let mobile = document.getElementById('mobile').value;

    let newStudent = {
        name,
        class_n,
        email,
        mobile
    }

    createStudent(newStudent);
}

// Initialize the table with existing students

