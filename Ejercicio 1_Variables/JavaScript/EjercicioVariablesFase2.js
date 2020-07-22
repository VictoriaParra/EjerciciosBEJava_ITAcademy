// Creeu una constant amb el valor de l’any (1948).
const ANY = 1948;

// Creeu una variable que guardi cada quan hi ha un any de traspàs.
var anyTraspas = 4;

//Calculeu quants anys de traspàs hi ha entre 1948 i el vostre any de naixement i emmagatzemeu el valor resultant en una variable.
var anyNaixement = 1989;
var resultado = (anyNaixement - ANY) / anyTraspas;

// Mostreu per pantalla el resultat del càlcul.
console.log(parseInt(resultado));