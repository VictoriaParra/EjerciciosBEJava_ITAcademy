// Almacenar en un Map tanto las letras de la lista como el número de veces que aparecen

var name= [];
name.push('V');
name.push('I');
name.push('C');
name.push('T');
name.push('O');
name.push('R');
name.push('I');
name.push('A');


let hmName = new Map();
    

var contador;
var i;
for ( i=0 ; i < name.length; i++) {

	if (hmName.get(name[i]) == null) {

        contador=0;

	} else { 
		contador=hmName.get(name[i]);
		
    }
contador++;
hmName.set((name[i]), contador); //name.get(i)--> KEY y contador-->VALUE
			
}

console.log(hmName);


