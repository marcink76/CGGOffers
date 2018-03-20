const checkBoxes = document.getElementsByClassName('lumpsum-chk');
const qInputs = document.getElementsByClassName('quantity std-input');
const pInputs = document.getElementsByClassName('price std-input');
const componentPrice = document.getElementsByClassName('componentOffer-price');


for (let i = 0; i < checkBoxes.length; i++){
    checkBoxes[i].addEventListener('change', function () {
        if(checkBoxes[i].checked){
            qInputs[i].style = ('visibility : hidden');
            pInputs[i].style = ('visibility : hidden');
            qInputs[i].value = 0;
            pInputs[i].value = 0;
            //TODO
            componentPrice[i].value = 0;
        }else {
            qInputs[i].style = ('visibility : visible');
            pInputs[i].style = ('visibility : visible');
        }
    })
}
for (let i = 0; i < qInputs.length; i ++ ){
    qInputs[i].addEventListener('keyup', function () {
        componentPrice[i].innerHTML = qInputs[i].value * pInputs[i].value;
    });
    pInputs[i].addEventListener('keyup', function () {
        componentPrice[i].innerHTML = qInputs[i].value * pInputs[i].value;
    });
}