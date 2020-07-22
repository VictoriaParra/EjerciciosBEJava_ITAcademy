/*
Creeu una variable on juntareu el nom i els cognoms (tot en una variable) i un altre on juntareu la data de naixement 
separada per “/” (tot en una variable). Mostreu per consola les variables del nom complet, la data de
naixement i si l’any de naixement es de traspàs o no.
*/

// Creación variable nombre completo.
var nomComplet = "Victoria Parra";
console.log("El meu nom és " + nomComplet);

// Creación variable fecha de nacimiento.
var dataNaixement = "09/05/1989";
console.log("Vaig néixer el " + dataNaixement);

// Condicional para saber si es o no un año bisiesto.
var añoNacimiento = 1989;
if (añoNacimiento % 4 == 0) {
    console.log("El meu any de naixement és de traspàs.");
} else {
    console.log("El meu any de naixement no és de traspàs.");
}