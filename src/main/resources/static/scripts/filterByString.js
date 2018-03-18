const inputNameString = document.getElementById('filter-by-name');
const nameForm = document.getElementById('name-form');

const inputLastNameString = document.getElementById('filter-by-lastname');
const inputCityString = document.getElementById('filter-by-city');
inputNameString.focus();
let strLength = inputNameString.value.length * 2;
inputNameString.setSelectionRange(strLength, strLength);
inputNameString.addEventListener('keyup', function () {
    let filteringString = inputNameString.value;
    nameForm.submit();
    console.log(filteringString);

});