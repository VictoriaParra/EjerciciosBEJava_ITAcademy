
//cambiar las vocales "a" de los nombres de las ciudades por el numero 4 y guarde los nombres 
//modificados en un nuevo array (ArrayCiutatsModificades).
		
var arrayCities= ["Barcelona", "Madrid", "Valencia", "Malaga", "Cadiz", "Santander"];
		
//Declaración nuevo array para las ciudades modificadas.
var arrayCitiesMod = new Array (arrayCities.length);
		
var i; 		
for (i = 0; i < arrayCities.length; i++) {
	// Modificación de 'a' por '4' mediante método replace().
	// Assignación de nombre modificados al nuevo array
	arrayCitiesMod[i]=arrayCities[i].replace(/a/gi, '4'); 
}
		
// Muestre por consola el array modificado y ordenado por orden alfabético.
arrayCitiesMod.sort();
console.log(arrayCitiesMod);
