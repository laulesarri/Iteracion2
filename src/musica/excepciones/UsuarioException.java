package musica.excepciones;

/*  Creamos un archivo de java que contenga las excepciones que creamos oportunas, en nuestro caso. utilizamos
 *  estas excepciones por el hecho de que además de quedar mas elegante, proporciona mas rapidez a nuestro 
 *  sistema software. Si el porcentaje de aparición de estos errores comienza a subir habría que condirerar en
 *  tratarlas de otro modo. Puesto que son sentencias que se realizan con mayor lentitud que una sentencia condicional
 */ 


/*Definimos nuestra propia excepción*/
public class UsuarioException extends Exception {

	/*Evitamos ciertos errores de serialización con este atributo */
	/*Denominamos al proceso de serialización a la fase de convertir un objeto en bytes*/
	/*Todos los objetos son serializables, lo que evitamos con estos es que las excepciones en cuestión
	 * contengan 80.000 versiones ID*/
	private static final long serialVersionUID = 1L; 
	
	/*Constructor para crear una excepción*/
/*Creamos un constructor genérico en el que vamos a crear todas las posibles excepciones que nos vayan surgiendo
 * no son excepciones del sistema, sino, excepciones creadas por el propio programador*/
	public UsuarioException(String causa) {
		super(causa);
	}
}
