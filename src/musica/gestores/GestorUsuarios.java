package musica.gestores;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import musica.excepciones.UsuarioException;
import musica.usuarios.Administrador;
import musica.usuarios.Usuario;

public class GestorUsuarios {

/*Utilizamos la interfaz de mapa para crear un mapa de usuarios
 * El mapa de usuarios consta de un par "clave/valor" en el que cada clave contiene
 * un valor específico. En algunos lugares se les llama "Diccionarios" permite añadir, eliminar, modificar elementos
 * de forma transparente para el programador*/
	
/*Como una interfaz ya tiene implementadas varias clases tipo map. Las mas importantes y útiles son:
 * Hasmap: Inserta los elementes sin un orden específico
 * TreeMap: Los ordena de forma natural
 * LinkedHashMap: los inserta en el mapa según se van insertando*/
	
/*Como bien sabemos nuestro gestor de usuarios va a tener acceso a todos los posibles usuarios de
 * nuestro sistema software, para evitar hacer arrays de todo tipo creamos un mapa de usuarios de tipo
 * usuario. Luego según se vayan creando especificaremos el tipo de usuario*/
	private Map<String,Usuario> mapaUsuarios;

/* Constructor que inicializa el mapa de usuarios y crea un administrador por defecto*/
	public GestorUsuarios() {
		// inicializo mapa de usuarios
		mapaUsuarios = new HashMap<>();

		// creo administrador por defecto
		Administrador a = new Administrador("admin", "admin", "Rootmaster");
		mapaUsuarios.put("admin", a);
	}	

	/*
	 * Método que crea una nueva instancia del tipo de usuario adecuado y la agrega al mapa, indexada por login
	 * tipo de usuario a generar
	 * adm del administrador que solicita la creación del usuario 
	 * @throws ExcepcionUsuario si ya existe un usuario con ese login, 
	 * 			si el tipo de usuario no existe en el sistema,
	 * 			o si hubo un error interno en la creación del usuario
	 */
	
	/*Creamos un método capaz de lanzar una excepción*/
	public void crearUsuario(String login, String clave, String nombre, String tipoUsuario, Administrador adm) 
			throws UsuarioException {

/*Observamos si nuestro mapa contiene el administrador pasado como parámetro, este método nos devolverá
 * TRUE si es valido*/
/*Recordamos que la parte de If funciona si el argumento es igual a True, no es necesario un operando lógico aquí
 * en java los operandos lógicos devuelves true*/
		if (mapaUsuarios.containsValue(adm))  // administrador válido
		{
			if (mapaUsuarios.containsKey(login)) // existe el login?
				throw new UsuarioException("Login ya existe");
			else {
				// login válido, creo usuario del tipo adecuado mediante reflexión
				//para captar el caso en el que por cualquier casual no podamos crear la instancia
				try {			
					// preparo constructor
					/*Vamos a acceder a un usuario de la clase Usuario*/
					String nclase = "musica.usuarios."+tipoUsuario;
					Class<?>[] tpars = new Class[3];
					/*listado de atributos de nuestro constructor*/
					/*definimos que tiene 3 strings y coseguimos la información necesaria de un string*/
					tpars[0] = Class.forName("java.lang.String");
					tpars[1] = Class.forName("java.lang.String");
					tpars[2] = Class.forName("java.lang.String");
					/*Por ultimo conseguimos el constructor del usuario tipo*/
					Constructor<?> co = Class.forName(nclase).getConstructor(tpars);
					
					
					// relleno parámetros y creo la instancia
					/*Obtenemos el constructor, del constructor le pedimos una instancia y os devuelve una instancia del tipo
					 * que hemos definido*/
					Object[] pars = new Object[3];
					pars[0] = login;
					pars[1] = clave;
					pars[2] = nombre;
					Usuario us = (Usuario)co.newInstance(pars);

					// guardo usuario en el mapa
					mapaUsuarios.put(login, us);
				} catch (ClassNotFoundException e) {
					throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					throw new UsuarioException("Error interno en la creación del usuario");
				}				
			}
		}
	}
	
	/*
	 * Método que comprueba las credenciales de un usuario
	 * 
	 * login del usuario
	 * clave del usuario (en claro)
	 * true si existe un usuario con ese login y su clave coincide con la proporcionada
	 * false en cualquier otro caso 
	 */
	
	public boolean validarUsuario(String login, String clave) {
		Usuario u = mapaUsuarios.get(login);
		if (u == null)
			return false;
		else 
			/*Miramos que existe un usuario con ese login y retornamos TRUE o FALSE dependiendo de si son iguales
			 * la clave suministrada con la del usuario que hemos instanciado*/
			return clave.equals(u.getClave());
	}

	/*
	 * Método que devuelve un usuario a partir de su login 
	 * login del usuario
	 * el usuario del mapa con ese login o null si no existe
	 */
	
	public Usuario getUsuario(String login) {
		return mapaUsuarios.get(login);
	}

	/*
	 * Método que devuelve una lista de descripciones de los usuarios en el sistema por tipo
	 * tipo de usuario
	 * lista con las descripciones de cada usuario del tipo encontrados
	 * ExcepcionUsuario si el tipo de usuario solicitado no existe	 
	 */
	public List<String> listarUsuariosTipo(String tipoUsuario) throws UsuarioException {		
		try {
			// inicializo lista
			List<String> descUsuarios = new ArrayList<>();
			// obtengo clase a partir de tipoUsuario
			String nclase = "musica.usuarios."+tipoUsuario;
			Class<?> clase = Class.forName(nclase);
			// preparo lista
			/*Utilizamos ubn bucle for each*/
			for (Usuario us : mapaUsuarios.values()) {
				/*isInstance nos devuelve True o False si la clase de tipo usuario coincide con
				 *la clase del usuario */
				if (clase.isInstance(us))
					/*si son iguales agregamos al array la informacion de ese usuario en particular*/
					descUsuarios.add(us.toString());					
			}
			// y la devuelvo el array dinámico
			return descUsuarios;
		} catch (ClassNotFoundException e) {
			throw new UsuarioException("Tipo de usuario \""+tipoUsuario+"\" incorrecto");
		}		
	}
}
