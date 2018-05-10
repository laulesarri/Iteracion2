package musica.usuarios;

public class Socio extends Usuario {

	/*Objeto de tipo Usuario*/
	private boolean premium;

	/*Constructor de nuestro Socio*/
	public Socio(String login, String clave, String nombre) {
	/*Como es un objeto de tipo heredado utilizaremos el comando super para iniciar sus atributos*/	
		super(login, clave, nombre);
	}	

/*Métodos de nuestro Socio*/	
	
/*Método que nos dice si es premium o no
 * si es premium devuelve TRUE
 * si no ELSE*/

	public boolean esPremium() {
		return premium;
	}
	

	public void setPremium(boolean prem) {
		premium = prem;
	}
	
	public String toString() {
		if (premium) {
			/*Agregamos la información del usuario mas si es premium o no*/
			return super.toString() 
					+ "\n Tipo: socio premium";
		}
		else {
			return super.toString() 
					+ "\n Tipo: socio basico";			
		}
	}
}
