package musica.usuarios;

public class Administrador extends Usuario {

	/*Constructor de nuestro Administrador*/
	public Administrador(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	

/*No tiene m�todos adicionales, solo declaramos la extensi�n de toString*/
	public String toString() {
		return super.toString() 
			+ "\n Tipo: administrador";
	}
}
