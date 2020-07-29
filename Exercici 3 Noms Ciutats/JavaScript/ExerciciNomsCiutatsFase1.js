
var cityName1 = "";
var cityName2 = "";
var cityName3 = "";
var cityName4 = "";
var cityName5 = "";
var cityName6 = "";

// Pedir por consola que se introduzcan los nombres.
// Introducir por teclado, los nombres de las siguientes ciudades
// Barcelona, Madrid, Valencia, Malaga, Cadiz y Santander.

const readline = require("readline");
const entrada = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

entrada.question("Introduce CityName1: ", function(cityName1) {

    entrada.question("Introduce CityName2: ", function(cityName2) {

        entrada.question("Introduce CityName3: ", function(cityName3) {

            entrada.question("Introduce CityName4: ", function(cityName4){
                
                entrada.question("Introduce CityName5: ", function(cityName5){

                    entrada.question("Introduce CityName6: ", function(cityName6){
                        //Mostrar por consola el nombre de las 6 ciudades.
                        console.log("Las ciudades elegidas son: "+cityName1+", "+cityName2+", "+cityName3+", "+cityName4+", "+cityName5+" y "+ cityName6);
                        entrada.close();

                    });
                });
            });
        });
     });
       
});