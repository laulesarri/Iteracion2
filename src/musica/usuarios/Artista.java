package musica.usuarios;

public class Artista extends Usuario {
	
	private int contadorCancionesPublicadas;
	
	/*Constructor de nuestro Artista*/
	public Artista(String login, String clave, String nombre) {
		super(login, clave, nombre);
		contadorCancionesPublicadas=0;
	}	

public int getContador()
{
	return this.contadorCancionesPublicadas;
}

public void setContador(int n)
{
	contadorCancionesPublicadas= contadorCancionesPublicadas + n;
}

/*No tiene m�todos adicionales, solo declaramos la extensi�n de toString*/
	public String toString() {
		return super.toString() 
			+ "\n Tipo: artista";
	}
}
