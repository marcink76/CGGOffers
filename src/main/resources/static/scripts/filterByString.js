const nameForm = document.getElementById('name-form');

const inputNameString = document.getElementById('filter-by-name');
const inputLastNameString = document.getElementById('filter-by-lastname');
const inputCityString = document.getElementById('filter-by-city');

inputLastNameString.addEventListener('keyup', filter);
inputCityString.addEventListener('keyup', filter);
inputNameString.addEventListener('keyup', filter);

this.focus();
function filter(){

    let strLength = this.value.length * 2;
    this.setSelectionRange(strLength, strLength);

    console.log(this.value);
    nameForm.submit();
}