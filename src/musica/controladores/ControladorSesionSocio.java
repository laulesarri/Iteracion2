package musica.controladores;

import java.util.List;

import musica.canciones.Cancion;
import musica.canciones.GestorCanciones;
import musica.canciones.Orden;
import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;
import musica.usuarios.Artista;
import musica.usuarios.Socio;

public class ControladorSesionSocio {

private GestorUsuarios gu;
private GestorCanciones gc;
private Socio soc;

/*Consturctor de nuestro controlador*/
public ControladorSesionSocio(GestorUsuarios gesu, GestorCanciones gestorC) {
	
	this.gu = gesu;
	this.gc = gestorC;
}

/*M�todos de nuestro Controlador*/


/*M�todo identificar Usuario*/
public void identificarUsuario(String login, String clave) throws UsuarioException {
	if(gu.validarUsuario(login, clave))
	//Usuario V�lido
		try
		{
			soc = (Socio)gu.getUsuario(login);
		}
		catch(ClassCastException e)
		{
			throw new UsuarioException("Usuario "+login+" no est� registrado");
		}
	else
	//Usuario no v�lido
		throw new UsuarioException("Usuario no v�lido, contrase�a o login incorrectos");
	
}

/*M�todo que inicia el premium*/
public boolean inicPremium(boolean b) throws UsuarioException {
	/*Observamos que no sea ya premium y que haya iniciado sesi�n*/
	if(soc!=null)
		if(soc.esPremium())
			throw new UsuarioException("Ya eres premium");
		else {
			soc.setPremium(true);
			return true;
		}
			
	else {
		throw new UsuarioException("No has iniciado sesion");
	}
		
}

/*M�todo que nos lista todas las canciones de un artista en particular*/
public List<Cancion> listarCanciones(String nombreArtista, Orden ordAlfad) throws UsuarioException {
	
	Artista art;
	try
	{
		
		art=(Artista)gu.getUsuario(nombreArtista);
	}
	catch(ClassCastException e)
	{
		throw new UsuarioException("El usuario que intentas listar no es un artista");
	}
	
	
	if(art!=null)
	{
		List<Cancion>lista=gc.listarCanciones(art,ordAlfad);
		return lista;
		
	}
	else
		throw new UsuarioException("El artista que intentas ver no existe en nuestra base de datos");	

}

/*M�todo Cerrar sesion*/
public void cerrarSesion() {
	soc = null;
}

}
