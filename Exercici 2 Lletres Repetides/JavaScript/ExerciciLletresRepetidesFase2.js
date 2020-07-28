//  Cambia la tabla para una lista (List <Character>)

var nombre1 = new Array;
nombre1[0] = 'V';
nombre1[1] = 'I';
nombre1[2] = 'C';
nombre1[3] = 'T';
nombre1[4] = 'O';
nombre1[5] = 'R';
nombre1[6] = 'I';
nombre1[7] = 'A';
nombre1[8] = '4';

var nombre = [];

//Utilizacion de FOR para agregar el contenido del array nombre1 al arrayList nombre.
var i;	
for (i = 0; i < nombre1.length; i++) {
    nombre.push(nombre1[i]); 	
}


//En el bucle, si la letra es una vocal imprime en la consola: 'VOCAL'. Sino, imprime: 'CONSONTANT'.

//Utilizacion del For para recorrer el arrayList.
var i;
for (i = 0; i < nombre.length; i++) {
    console.log(nombre[i] + ": ");

 // Utilizacion de switch para saber si es 'vocal' o 'consonant'.	   
switch ( nombre[i].toLowerCase() ){
case 'a':
    console.log("VOCAL");
    break;
case 'e':
    console.log("VOCAL");
    break;
case 'i':
    console.log("VOCAL");
    break;
case 'o':
    console.log("VOCAL");
    break;
case 'u':
    console.log("VOCAL");
    break;
default:
    //Si encuentras un numero, muestra por pantalla: 'Los nombres de personas no contienen números!'.
    // Utilizacion del condicional IF para verificar si hay numeros o no.
    if (isNaN(nombre[i])==false) {
        console.log("Los nombres de personas no contienen números!");
    } else {
        console.log("CONSONANT");
    }

}

}



