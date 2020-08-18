/*
Con un bucle for deberemos rellenar los dos arrays anteriormente creados.
Añadiremos el nombre del plato y luego el precio. Puedes hacer uso de
diccionarios de datos (Java HasMap)
*/

let hmMenu = new Map();
hmMenu.set("Hamburguesa doble con queso", 20);
hmMenu.set("Pizza Margherita", 10);
hmMenu.set("Ensalada verde", 15);
hmMenu.set("Patatas fritas", 5);
hmMenu.set("Huevos estrellados", 10);

var menu = new Array();
var dishPrice = new Array();

var counter = 0;

var i;
hmMenu.forEach(function (value, key) {
  menu[counter] = key;
  dishPrice[counter] = hmMenu.get(key);

  counter++;
})

console.log("Menu: " + menu);
console.log("Precios: " + dishPrice);

/*
- Una vez llenos los dos arrays tendremos que mostrarles y preguntar que se
quiere para comer, guardaremos la información en una List usando un bucle
while.
- Tendremos que preguntar si se quiere seguir pidiendo comida. Puede utilizar
el sistema (1: Si / 0: No), por lo tanto deberá crear otro variable int para
guardar la información.
*/

var orderList = [];
var continuar;

const readline = require("readline");
const reader = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});


reader.question("¿Qué quieres para comer? Introduce un plato del menú \n", function (answer) {
  orderList.push(answer);

  reader.setPrompt("¿Quiere pedir algo más? Introduzca el número 1: Si / 0: No \n");
  reader.prompt();


  reader.on('line', function (input) {


    continuar = parseInt(input)


    switch (continuar) {
      case 1:
        reader.question("¿Qué más quieres para comer? Introduce un plato \n", function (answer) {
          orderList.push(answer);
          reader.prompt();

        });

        break;

      case 0:
        reader.close();
        break;
      
      default:
        console.log("El valor introducido es incorrecto \n");
        reader.prompt();
        break;
    }


  }).on('close', function () {
    console.log("Gracias por su pedido!");
    console.log("Su pedido es: " + orderList + ". En breves verificaremos su pedido y costo a pagar.");
    process.exit(0);
  });

});