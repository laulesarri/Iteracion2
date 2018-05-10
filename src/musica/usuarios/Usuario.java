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
	
/*Métodos de la clase Usuario*/
	
/*Métodos de tipo GET*/
	public  String getLogin() {
		return login;
	}

	
	public  String getClave() {
		return clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
/*Métodos de tipo SET*/
	public void setClave(String c) {
		clave = c;
	}
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*Método toString*/
/*Método que utilizamos para recibir una pequeña "ficha" de información del usuario en sí*/
	public String toString() {
		// Compone una cadena con todos los campos y la retorna
		return "Usuario: " + getLogin() + 
			"\n Clave: " + getClave() + 
			"\n Nombre: " + getNombre();
	}
}
