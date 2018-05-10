package musica.usuarios;

public class Anunciante extends Usuario {

	private int contadorCampanas;
	
/*Constructor de nuestro Anunciante*/
	public Anunciante(String login, String clave, String nombre) {
		super(login, clave, nombre);
		contadorCampanas=0;
	}	
	
	public int getContador()
	{
		return this.contadorCampanas;
	}
	
	public void setContador(int n)
	{
		contadorCampanas= contadorCampanas + n;
	}
	
	/*No tiene métodos adicionales, solo declaramos la extensión de toString*/
	public String toString() {
		return super.toString() 
			+ "\n Tipo: anunciante";
	}
}
