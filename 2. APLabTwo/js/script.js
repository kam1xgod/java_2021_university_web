var inputNameField = document.getElementById("nameInput");
var inputNumberField = document.getElementById("numberInput");
var defaultExample = "Ivanov, for example...";
var numberSubmitButton = document.getElementById("numberSubmitButton");
var deleteButtons = document.getElementsByClassName("delete");
var nameSubmitButton = document.getElementById("nameSubmitButton");

inputNameField.value = defaultExample;
  
inputNameField.addEventListener("focus", myFocusFunction, true);
inputNameField.addEventListener("blur", myBlurFunction, true);

for (var i = 0; i < deleteButtons.length; i++) {
  deleteButtons[i].addEventListener("click", function() {
   hideRowFunction(this); 
  }, false);
}

function hideRowFunction(element) {
  element.parentNode.parentNode.style.display = "none";
  element.preventDefault();
}


function myFocusFunction() {
  if (inputNameField.value == defaultExample) {
    inputNameField.value = "";
  }
}

function myBlurFunction() {
  if (inputNameField.value == "") {
    inputNameField.value = defaultExample;
  }
}

numberSubmitButton.onclick = function() {
  if (isNaN(parseInt(inputNumberField.value, 10))) {
    alert("In number field must be only numbers.");
  }
}
  
nameSubmitButton.onclick = function() {
    var name = inputNameField.value;
    location.replace("newEmployeeForm.html?" + name + "");
}