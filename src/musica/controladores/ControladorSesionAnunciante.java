package musica.controladores;

import musica.anuncios.GestorCampanas;
import musica.canciones.Genero;
import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;
import musica.usuarios.Anunciante;

public class ControladorSesionAnunciante {
	private GestorUsuarios gu;
	public GestorUsuarios getGu() {
		return gu;
	}


	public void setGu(GestorUsuarios gu) {
		this.gu = gu;
	}

	private Anunciante anun;
	private GestorCampanas gcamp;
	

//Constructor
public ControladorSesionAnunciante(GestorUsuarios gestorU, GestorCampanas gestorCamp){
	
	this.gu = gestorU;
	this.gcamp = gestorCamp;
}
	

//Métodos de nuestro controlador




//Identificar Usuario Anunciante
public void identificarAnunciante(String login,String clave) throws UsuarioException {
	if(gu.validarUsuario(login, clave))
	//Usuario Válido
		try
		{
			anun = (Anunciante)gu.getUsuario(login);
		}
		catch(ClassCastException e)
		{
			throw new UsuarioException("Usuario "+login+" no esta registrado");
		}
	else
	//Usuario no válido
		throw new UsuarioException("Usuario no válido, contraseña o login incorrectos");
	
}
	
public Anunciante getAnun() {
	return anun;
}


public void setAnun(Anunciante anun) {
	this.anun = anun;
}


//Método publicar campaña
public void publicarCampana(String descripcion, Genero genero, int numR, float costeTotal, Anunciante anun, String est) throws UsuarioException{
	
	if(this.anun!=null)
	{
		gcamp.crearCampana(descripcion, genero, numR, costeTotal, anun, est);	
		
	}
	else
		throw new UsuarioException("Autentificacion requerida");
	
}

//Método Cerrar sesion
public void cerrarSesion() {
	anun = null;
}

}