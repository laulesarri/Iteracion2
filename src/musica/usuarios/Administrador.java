package musica.usuarios;

public class Administrador extends Usuario {

	/*Constructor de nuestro Administrador*/
	public Administrador(String login, String clave, String nombre) {
		super(login, clave, nombre);
	}	

/*No tiene métodos adicionales, solo declaramos la extensión de toString*/
	public String toString() {
		return super.toString() 
			+ "\n Tipo: administrador";
	}
}
