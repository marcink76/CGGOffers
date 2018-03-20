const previewbox = document.getElementById('show-preview')

function hidePreviewBox() {
    previewbox.style = ('visibility: hidden');
}

function loadOffer(offerId) {
    previewbox.style = ('visibility: visible');
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log(xhttp);
            const offer = JSON.parse(xhttp.response);
            previewbox.innerHTML =
                offer.id + '/' + offer.date.year + '<br/>' +
                offer.investor.name + '<br/>' +
                offer.description + '<br/>' +
                offer.investor.firstName + ' ' + offer.investor.lastName + '<br/>' +
                offer.componentOfferList.length + '<br/>' +
                offer.totalPrice;
        }
    };
    xhttp.open("GET", "http://localhost:8080/api/offers/" + offerId, true);
    xhttp.send();
}