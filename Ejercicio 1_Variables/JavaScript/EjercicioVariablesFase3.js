/*
Partint de l’any 1948 heu de fer un bucle for i mostrar els anys de traspàs
fins arriba al vostre any de naixement. ATENCIO! Haureu de canviar el tipus
de variable de l’any 1948 per poder modificar-la.
*/
var any =1948;
var anyNaixement = 1989;
for (any ; any <= anyNaixement; any += 4) {
    console.log(any);
}

// Creeu una variable bool que sera certa si l’any de naixement és de traspàs o falsa si no ho és.(0,75 punts)
var isAnyTraspas = anyNaixement % 4 == 0;

/*
En cas de que la variable bool sigui certa, heu de mostrar per consola una
frase on ho digui, en cas de ser falsa mostrareu la frase pertinent. Creeu
dues variables string per guardar les frases. (1,5 punts)
*/
var certa = "Si, l’any de naixement és de traspàs";
var falsa = "No, l’any de naixement no és de traspàs";

if (isAnyTraspas == true) {
    console.log(certa);
}else { 
    console.log(falsa);
}
