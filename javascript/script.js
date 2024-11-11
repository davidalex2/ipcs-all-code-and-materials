// Get the popup element
var popup = document.getElementById("popup");

// Get the button that opens the popup
var openPopupBtn = document.getElementById("open-popup-btn");

// Get the <span> element that closes the popup
var closePopupBtn = document.getElementById("close-popup-btn");

// When the user clicks the button, open the popup
openPopupBtn.addEventListener('click', function() {
    popup.style.display = "block";
});

// When the user clicks on <span> (x), close the popup
closePopupBtn.addEventListener('click', function() {
    popup.style.display = "none";
});

// When the user clicks anywhere outside of the popup, close it
window.addEventListener('click', function(event) {
    if (event.target == popup) {
        popup.style.display = "none";
    }
});

// Function to populate the form with student data and open the popup
function editStudent(id, name, class_n, email, mobile) {
    document.getElementById('student-id').value = id;
    document.getElementById('name').value = name;
    document.getElementById('class_n').value = class_n;
    document.getElementById('email').value = email;
    document.getElementById('mobile').value = mobile;
    popup.style.display = "block";
}

// Add your existing code here for the update functionality...
