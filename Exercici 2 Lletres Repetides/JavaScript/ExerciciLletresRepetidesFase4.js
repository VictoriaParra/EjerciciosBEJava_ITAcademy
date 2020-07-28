// Crear otra lista con tu apellido donde cada posición corresponda a una letra.

var surname= ['P','A','R','R','A'];


/*
* Combinar las dos listas en una sola. Además, añade una posición con un espacio vacío entre 
* la primera y la segunda. Es decir, partimos de la lista name y surname y al terminar la ejecución 
* sólo tendremos una que se llamará fullname.
* Fullname: [ 'N', 'A', 'M', 'E', '', 'S', 'U', 'R', 'N', 'A', 'M', 'E']
*/
var name= ['V','I','C','T','O','R','I','A'];

var fullname =[].concat(name, ' ', surname);

console.log(fullname);