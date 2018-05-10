package musica.usuarios;

public abstract class Usuario {
	
	private String login; 
	private String clave; 
	private String nombre; 
	
	/*Constructor de nuestra clase*/
	public Usuario(String l, String c, String n) {
		login = l;
		clave = c;
		nombre = n;
	}
	
/*M�todos de la clase Usuario*/
	
/*M�todos de tipo GET*/
	public  String getLogin() {
		return login;
	}

	
	public  String getClave() {
		return clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
/*M�todos de tipo SET*/
	public void setClave(String c) {
		clave = c;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*M�todo toString*/
/*M�todo que utilizamos para recibir una peque�a "ficha" de informaci�n del usuario en s�*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return "Usuario: " + getLogin() + 
			"\n Clave: " + getClave() + 
			"\n Nombre: " + getNombre();
	}
}
