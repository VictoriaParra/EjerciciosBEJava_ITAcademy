
var cityName1 = "Barcelona";
var cityName2 = "Madrid";
var cityName3 = "Valencia";
var cityName4 = "Malaga";
var cityName5 = "Cadiz";
var cityName6 = "Santander";
		

//Pasar la información a un array - arrayCities
var arrayCities= new Array();
arrayCities[0]= cityName1;
arrayCities[1]= cityName2;
arrayCities[2]= cityName3;
arrayCities[3]= cityName4;
arrayCities[4]= cityName5;
arrayCities[5]= cityName6;
		
// Mostrar por consola el array ordenado alfabéticamente
arrayCities.sort();
console.log(arrayCities);