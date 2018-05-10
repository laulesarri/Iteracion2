package musica.controladores;

import musica.canciones.GestorCanciones;
import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;
import musica.usuarios.Artista;
import musica.canciones.Genero;

public class ControladorSesionArtista {
	
	private GestorUsuarios gu;
	private Artista art;
	private GestorCanciones gc;
	

/*Constructor*/
public ControladorSesionArtista(GestorUsuarios gestorU, GestorCanciones gestorC){
	
	this.gu = gestorU;
	this.gc = gestorC;
}
	

/*Métodos de nuestro controlador*/

/*Identificar Usuario Artista*/
public void identificarArtista(String login,String clave) throws UsuarioException {
	if(gu.validarUsuario(login, clave))
	//Usuario Válido
		try
		{
			this.art = (Artista)gu.getUsuario(login);
		}
		catch(ClassCastException e)
		{
			throw new UsuarioException("Usuario "+login+" no está registrado");
		}
	else
	//Usuario no válido
		throw new UsuarioException("Usuario no válido, contraseña o login incorrectos");
	
}
	
	
	
/*Método publicar cancion*/
public void publicarCancion(String titulo, Genero genero) throws UsuarioException{
	
	if(this.art!=null)
	{
		gc.crearCancion(titulo,art,genero);	
	}
	else
		throw new UsuarioException("Autentificacion requerida");
	
}


/*Método Cerrar sesion*/
public void cerrarSesion() {
	art = null;
}

	
}
