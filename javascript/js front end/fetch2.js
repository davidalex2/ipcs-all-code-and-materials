const baseURL = 'http://localhost:8082/students';
// const baseURL ='https://my-json-server.typicode.com/davidalex2/json-server/students';
let allStudentData=new Array();
getAllStudents();
// Function to create a new student
function createStudent(studentData) {
    fetch(`${baseURL}/add`, {
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
    fetch(`${baseURL}/getall`)
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
    console.log(data);

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
        edit_btn.textContent='Edit';
        edit_btn.className='btn btn-success'
        edit_btn.classList.add('edit-btn');
        edit_btn.addEventListener('click',function(){
            popup.style.display = "block";

            
            // updateOne(id_s);
            editStudent(id_s.textContent,name_s.textContent,class_s.textContent,email_s.textContent,mobile_s.textContent);
           

        });
        edit_btn.id='open-popup-btn';
        let delete_btn=document.createElement('button');
        delete_btn.addEventListener('click',()=>{
           
                deleteStudentById(student.id);
                console.log(student.id);
            
        })
        delete_btn.textContent='Delete';
        delete_btn.className="btn btn-danger"
        
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
    // Remove any extra rows that are no longer needed
   
    // while (table.rows.length > data.length) {
    //     table.removeChild(table.lastChild);
    // }

   
}

var popup = document.getElementById("popup");

var openPopupBtn = document.getElementById("open-popup-btn");

let c_btn=document.getElementById('create-btn');
var closePopupBtn = document.getElementById("close-popup-btn");
// var btn_c=document.getElementById('close-btn');
window.addEventListener('click', function(event) {
    if (event.target == popup) {
        popup.style.display = "none";
        c_btn.style.display='block';
        
    }
});
closePopupBtn.addEventListener('click',()=>{
    popup.style.display = "none";
    c_btn.style.display='block';
})


function editStudent(id,name,class_n,email,mobile) {
    document.getElementById('student-id').value = id; // Hidden input for the student ID
    document.getElementById('name_o').value = name;
    document.getElementById('class_o').value = class_n;
    document.getElementById('email_o').value = email;
    let s_mobile=document.getElementById('mobile_o').value = mobile;
    console.log(id,name,class_n,mobile,email);
    // document.preventDefault();

    // Show the form or popup to edit the student
    document.getElementById('popup').style.display = 'block';
    let btn_u=document.getElementById('update-btn');
    btn_u.style.display='block';
    document.getElementById('create-btn').style.display = 'none'; // Hide the create button if necessary

    btn_u.addEventListener('click',()=>{
        let s_id=document.getElementById('student-id').value;
        let name=document.getElementById('name_o').value;
        let class_n=document.getElementById('class_o').value;
        let email=document.getElementById('email_o').value;
        let mobile=document.getElementById('mobile_o').value;
        

    let updatedData = {
        name,
        class_n,
        email,
        mobile
    };
        console.log(s_id,updatedData);
    updateStudentById(id, updatedData);
    })




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
    fetch(`${baseURL}/modify/${id}`, {
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
    fetch(`${baseURL}/remove/${id}`, {
        method: 'DELETE',
    })
    .then(response=>console.log(response))
    .then(() => {
        console.log('Student Deleted');
        allStudentData=allStudentData.filter(data=>data.id!==id);
        // console.log(allStudentData);
        // toDisplay(allStudentData); // Refresh the table after deletion
        if(allStudentData){
            toDisplay(allStudentData);
            // getAllStudents();
        }
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

