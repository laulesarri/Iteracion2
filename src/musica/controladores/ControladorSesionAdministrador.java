package musica.controladores;

import java.util.List;

import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;
import musica.usuarios.Administrador;

public class ControladorSesionAdministrador {
	
	private GestorUsuarios gu; 
	private Administrador admin; 

/*Constructor del controladorSesionAdmin*/
	public ControladorSesionAdministrador(GestorUsuarios gesu) {
		gu = gesu;		
	}

/*M�todos de nuesto controlador*/

/*M�todo identificarAdministrador*/
	public void identificarAdministrador(String login, String clave) throws UsuarioException {
		if (gu.validarUsuario(login, clave)) {
			// admin v�lido
			try {
				admin = (Administrador) gu.getUsuario(login);
			} catch (ClassCastException e) {
				throw new UsuarioException("Usuario "+login+" no es administrador");
			}
		}
		else // admin no v�lido
			throw new UsuarioException("Credenciales de usuario no validas");
	}

	
/*M�todo para crear un usuario*/
	public void crearUsuario(String login, String clave, String nombre, String tipo) throws UsuarioException {
		if (admin!= null) 
			gu.crearUsuario(login, clave, nombre, tipo, admin);
		else
			throw new UsuarioException("Autenticacion requerida");
	}
	
/*M�todo para listar los usuarios en el sistema*/	
	public List<String> listarUsuariosTipo(String tipo) throws UsuarioException {
		if (admin!= null)
			return gu.listarUsuariosTipo(tipo);
		else
			throw new UsuarioException("Autenticacion requerida");
	}

	
/*M�todo para cerrar la sesi�n*/
	public void cerrarSesion() {
		admin = null;
	}
}
