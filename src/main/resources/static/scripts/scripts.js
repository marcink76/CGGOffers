const getInvestorBtn = document.getElementById('get-investor-btn');
const addInvestorBtn = document.getElementById('add-investor-btn');
const showAllInvestors = document.getElementById('get-all-investor-btn');
const msgBox = document.getElementById('info-box');
const ul = document.getElementById('ul-main-menu').nextSibling;

investor = {
    "id": "",
    "name": "Budynex",
    "street": "Niewiadomokogo",
    "posesionNumber": "1",
    "localNumber": "2",
    "city": "Leszno",
    "zipcode": "60-681",
    "nip": "444555556",
    "email": "bgex@sdsdi.pl",
    "phoneNumber": "54321234",
    "offerList": []
};

getInvestorBtn.addEventListener("click", function () {
    connectAndGet();
});

addInvestorBtn.addEventListener("click", function () {
    connectAndPut();
});


function connectAndGet() {
    let sufix = '';
    let url = 'http://localhost:8080/api/investors/' + sufix;
    let xhr = new XMLHttpRequest();

    //typ połączenia, url, czy asynchroniczen
    xhr.open("GET", url, true);

    xhr.addEventListener('load', function() {
        console.log('Wynik połączenia:');
        console.log(this);
        msgBox.innerText = xhr.responseText;
    });

    xhr.send();

    }
function connectAndPut() {
    let urla = 'http://localhost:8080/api/investors/add';
    let xhr = new XMLHttpRequest();
    xhr.open("POST", urla, true);
    xhr.setRequestHeader("Content-type", "application/json");
    if (xhr.readyState === 4 && xhr.status === 200){
        let json = JSON.parse(xhr.responseText);
        console.log(json.name);
    }
    let json2 = JSON.stringify(investor);
    xhr.send(json2);
}

