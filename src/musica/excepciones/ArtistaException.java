package musica.excepciones;

/*Definimos nuestra propia excepci�n*/
public class ArtistaException extends Exception {

	/*Evitamos ciertos errores de serializaci�n con este atributo */
	/*Denominamos al proceso de serializaci�n a la fase de convertir un objeto en bytes*/
	/*Todos los objetos son serializables, lo que evitamos con estos es que las excepciones en cuesti�n
	 * contengan 80.000 versiones ID*/
	private static final long serialVersionUID = 1L; 

	/*Constructor para crear una excepci�n*/
	/*Creamos un constructor gen�rico en el que vamos a crear todas las posibles excepciones que nos vayan surgiendo
	 * no son excepciones del sistema, sino, excepciones creadas por el propio programador*/
	public ArtistaException(String causa) {
		super(causa);
	}
}

