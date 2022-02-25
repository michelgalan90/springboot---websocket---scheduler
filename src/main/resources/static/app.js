let stompClient = null;
let boton = document.getElementById("connect");
let texto = document.getElementById("texto");
let enviarBoton = document.getElementById("enviar");

boton.addEventListener("click", ev => {
    console.log("click");
    connect();
});

enviarBoton.addEventListener("click", ev => {
    console.log(texto.value);
    stompClient.send("/app/hello", {}, JSON.stringify({"name": `${texto.value}`}));
})

function connect() {
    var socket = new SockJS('http://localhost:5050/stomp-endpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stompClient.subscribe('/topic/greetings', function (greeting) {
            console.log(JSON.parse(greeting.body).message);
        });

        stompClient.subscribe("/numero/aleatorio", function(numero) {
            console.log(JSON.parse(numero.body).numero);
        });
    });
}