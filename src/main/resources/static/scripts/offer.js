const inputPrice = document.querySelectorAll('.input-price');
const inputQuantity = document.querySelectorAll('.input-quantity');
const totalPrice = document.getElementById('total-price-box');
const componentPrice = document.querySelectorAll('.component-price');

console.log(componentPrice);

for (let i = 0; i < inputPrice.length; i++) {
    inputPrice[i].addEventListener('keyup', function () {
        totalPriceCount();
    });
}

for (let i = 0; i < inputQuantity.length; i++) {
    inputQuantity[i].addEventListener('keyup', function () {
        totalPriceCount();
    });
}

function totalPriceCount() {
    for (let i = 0; i < inputPrice.length; i++) {
        let solve = inputPrice[i].value * inputQuantity[i].value;
        componentPrice[i].innerHTML = solve.toString();
        let totalPriceSum =+ componentPrice[i];
        totalPrice.innerText = totalPriceSum.toString();
    }
}

