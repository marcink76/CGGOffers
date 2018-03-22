const checkBoxes = document.getElementsByClassName('lumpsum-chk');
const qInputs = document.getElementsByClassName('quantity std-input');
const pInputs = document.getElementsByClassName('price std-input');
const componentPrice = document.getElementsByClassName('componentOffer-price');


for (let i = 0; i < checkBoxes.length; i++) {
    checkBoxes[i].addEventListener('change', function () {
        if (checkBoxes[i].checked) {
            qInputs[i].style = ('opacity : 0.5');
            pInputs[i].style = ('opacity : 0.5');
            qInputs[i].disabled = true;
            pInputs[i].disabled = true;
            qInputs[i].value = 0.0;
            pInputs[i].value = 0.0;
            componentPrice[i].value = 0;
        } else {
            qInputs[i].style = ('visibility : visible');
            pInputs[i].style = ('visibility : visible');
            qInputs[i].disabled = false;
            pInputs[i].disabled = false;
        }
    })
}
for (let i = 0; i < qInputs.length; i++) {
    qInputs[i].addEventListener('keyup', function () {
        componentPrice[i].innerHTML = qInputs[i].value * pInputs[i].value;
    });
    pInputs[i].addEventListener('keyup', function () {
        componentPrice[i].innerHTML = qInputs[i].value * pInputs[i].value;
    });
}

const box = document.getElementById('sms');

box.addEventListener('click', function () {
    box.style = ('visibility : hidden')
});