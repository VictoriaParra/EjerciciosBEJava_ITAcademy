/*
Una vez hemos acabado de pedir la comida, tendremos que comparar la lista con
el array que hemos hecho al principio. En caso de que la información que
hemos introducido en la List coincida con la del array, tendremos que sumar
el precio del producto solicitado; en el caso contrario tendremos que mostrar
un mensaje que diga que el producto que hemos pedido no existe.
*/

var menu = ["Hamburguesa doble con queso", "Ensalada verde", "Pizza Margherita", "Huevos estrellados",
    "Patatas fritas"];

var dishPrice = [20, 15, 10, 10, 5];

var orderList = [];
orderList.push("Hamburguesa doble con queso");
orderList.push("patatas fritas");
orderList.push("Hamburguesa doble con queso");
orderList.push("ensalada");
orderList.push("huevos estrellados");
orderList.push("Hamburguesa doble");
orderList.push("ensalada verde");
orderList.push("Pizza Margherita");
orderList.push("Pizza");

// Pase el arrayList toLowerCase
//UnaryOperator < String > uo = (x) -> x.toLowerCase();
//orderList.replaceAll(uo);


var totalPrice = 0;
var isProductFound = false;

var i;
var j;

for (i = 0; i < orderList.length; i++) {

    isProductFound = false;

    for (j = 0; j < menu.length; j++) {

        if (orderList[i].toLowerCase().includes(menu[j].toLowerCase())) {
            totalPrice = (totalPrice + dishPrice[j]);
            isProductFound = true;
        }
    }

    if (isProductFound == false) {
        console.log("Este producto no existe: " + orderList[i]);
    }
}

console.log("El precio a pagar es " + totalPrice + " € ");