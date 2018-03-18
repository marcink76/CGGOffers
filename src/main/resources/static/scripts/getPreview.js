const handler = document.getElementById('offer-id');
const containter = document.getElementById('show-preview');
let offer;
handler.addEventListener('mouseover', function () {
    console.log('ok');
    $.ajax({
            url: '/api/offers/1',
            type: 'get',
            contentType: 'aplication/json',
            dataType: 'json'
        }
    );
    done(function (res) {
        res.forEach(function (el) {
            console.log(el);
        })
    })
});

containter.innerText = offer;

