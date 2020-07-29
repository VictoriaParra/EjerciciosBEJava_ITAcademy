
var arrayCities= ["Barcelona", "Madrid", "Valencia", "Malaga", "Cadiz", "Santander"];
		
	
var cityName1= arrayCities[0].split();
var cityName2= arrayCities[1].split();
var cityName3= arrayCities[2].split();
var cityName4= arrayCities[3].split();
var cityName5= arrayCities[4].split();
var cityName6= arrayCities[5].split();


var i;
//cityName1
for ( i = cityName1[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName1[0].charAt(i));   
}

process.stdout.write("\n"); 
	
//cityName2
for ( i = cityName2[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName2[0].charAt(i));		     
}

process.stdout.write("\n"); 

//cityName3
for ( i = cityName3[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName3[0].charAt(i));	     
}
 
process.stdout.write("\n"); 

//cityName4
for ( i = cityName4[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName4[0].charAt(i));	     
}

process.stdout.write("\n"); 

//cityName5
for ( i = cityName5[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName5[0].charAt(i));
}
 
process.stdout.write("\n"); 

//cityName6
for ( i = cityName6[0].length - 1; i >= 0 ; i--) {
	process.stdout.write(cityName6[0].charAt(i));
}				