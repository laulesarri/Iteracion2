package musica.arranque;

import java.util.List;


import musica.anuncios.GestorCampanas;
import musica.canciones.Genero;
import musica.canciones.GestorCanciones;
import musica.canciones.Orden;
import musica.controladores.ControladorSesionAdministrador;
import musica.controladores.ControladorSesionAnunciante;
import musica.controladores.ControladorSesionArtista;
import musica.controladores.ControladorSesionSocio;
import musica.excepciones.ArtistaException;
import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;
import musica.canciones.Cancion;


public class PruebasMusicaIter1 {
	
	/**
	 * M�todo main(). No se esperan par�metros.
	 * @param args par�metros por l�nea de comandos que no se tratan.
	 * @throws ArtistaException 
	 */
	public static void main(String[] args) throws ArtistaException {
	
		//*************************************
		//*******INICIALIZACION GESTORES*******
		//*************************************						
		// Instancio los gestores de usuarios, canciones, campa�as
		GestorUsuarios gu = new GestorUsuarios();
		GestorCanciones gc = new GestorCanciones();
		GestorCampanas gcamp = new GestorCampanas();
		
		//*************************************
		//****INICIALIZACION CONTROLADORES*****
		//*************************************				
		// Instancio controladores de sesi�n
		ControladorSesionAdministrador csadmin = new ControladorSesionAdministrador(gu);
		ControladorSesionArtista csart = new ControladorSesionArtista(gu, gc);
		ControladorSesionAnunciante csanun = new ControladorSesionAnunciante(gu, gcamp);
		ControladorSesionSocio cssoc = new ControladorSesionSocio(gu, gc);
		
				
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO PREVIOS");
		System.out.println("////////////////////////////////////////////////////////\n");	
		casosUsoAdmin(csadmin);
		
		
		System.out.println("\n\n////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO ITERACI�N 1");
		System.out.println("////////////////////////////////////////////////////////\n");
		casosUsoArtistas(csart);
		casosUsoAnunciantes(csanun,gcamp);
		casosUsoSocios(cssoc);		
	}

	
	/**
	 * M�todo que realiza los casos de uso de los administradores
	 * @param csadmin controlador de sesi�n para el usuario admin
	 */
	private static void casosUsoAdmin(ControladorSesionAdministrador csadmin) {
		System.out.println("/// CASOS DE USO ADMINISTRADOR ///\n");
		
		// ------------------------------------
		// -- Usuario admin (ADMINISTRADOR) --
		// ------------------------------------
		System.out.println("<<inicio sesi�n admin>>");
		System.out.println("(admin creado por defecto en gestor de usuarios)\n");
		try {
			csadmin.identificarAdministrador("admin","admin");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		
		//*************************************
		//*********CREACION DE USUARIOS********
		//*************************************			
		System.out.println("CREACION DE USUARIOS");		
		try {			
			System.out.println("admin crea tres artistas");
			csadmin.crearUsuario("muse", "clave", "Muse", "Artista");
			csadmin.crearUsuario("judas", "clave", "Judas Priest", "Artista");
			csadmin.crearUsuario("pearl", "clave", "Pearl Jam", "Artista");
			System.out.println("admin crea dos anunciantes");
			csadmin.crearUsuario("donnaipe", "clave", "Don Naipe", "Anunciante");
			csadmin.crearUsuario("megaclothes", "clave", "Megaclothes", "Anunciante");
			System.out.println("admin crea dos socios");
			csadmin.crearUsuario("luisa", "clave", "Luisa Lanas", "Socio");
			csadmin.crearUsuario("mike", "clave", "Michael Johnson", "Socio");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//************LISTAR USUARIOS**********
		//*************************************	
		System.out.println("\nLISTAR USUARIOS");
		System.out.println("\nlista de artistas:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Artista");
			for (String desc :descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Artista\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("\nlista de socios:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Socio");
			for (String desc :descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Socio\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("\nlista de anunciantes:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Anunciante");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Anunciante\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		System.out.println("\nlista de administradores:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Administrador");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Administrador\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		System.out.println("\nlista de musicos:");
		try {
			List<String> descs = csadmin.listarUsuariosTipo("Musico");
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" usuarios de tipo \"Musico\"");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	
		
		System.out.println("\n<<cierre sesi�n admin>>");
		csadmin.cerrarSesion();
	}

	/**
	 * M�todo que realiza los casos de uso de los artistas
	 * @param csart controlador de sesi�n para el usuario artista
	 */
	private static void casosUsoArtistas(ControladorSesionArtista csart) {
		System.out.println("\n\n/// CASOS DE USO ARTISTAS ///\n");
		
		// ------------------------------------
		// -- Usuario muse (ARTISTA) --
		// ------------------------------------
		System.out.println("<<inicio sesi�n muse>>\n");	
		try {
			csart.identificarArtista("muse","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACI�N DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACI�N DE CANCIONES");
		System.out.println("muse crea cuatro canciones");
		try {			
			csart.publicarCancion("Hysteria", Genero.ROCK);
			csart.publicarCancion("Madness", Genero.ELECTRONICA);
			csart.publicarCancion("Starlight", Genero.ROCK);
			csart.publicarCancion("Resistance", Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesi�n muse>>");
		csart.cerrarSesion();
		
		
		// ------------------------------------
		// -- Usuario judas priest (ARTISTA) --
		// ------------------------------------
		System.out.println("\n<<inicio sesi�n judas priest>>\n");	
		try {
			csart.identificarArtista("judas","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACI�N DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACI�N DE CANCIONES");
		System.out.println("judas crea tres canciones");
		try {			
			csart.publicarCancion("Victim of changes", Genero.ROCK);
			csart.publicarCancion("Breaking the law", Genero.ROCK);
			csart.publicarCancion("Painkiller", Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesi�n judas priest>>");
		csart.cerrarSesion();
	}

	/**
	 * M�todo que realiza los casos de uso de los anunciantes
	 * @param csanun controlador de sesi�n para el usuario anunciante
	 */
	private static void casosUsoAnunciantes(ControladorSesionAnunciante csanun, GestorCampanas gcamp) {
		System.out.println("\n\n/// CASOS DE USO ANUNCIANTES ///\n");
		
		// ------------------------------------
		// -- Usuario donnaipe (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("<<inicio sesi�n donnaipe>>\n");	
		try {
			csanun.identificarAnunciante("donnaipe","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACI�N DE CAMPA�AS*******
		//*************************************	
		System.out.println("\nPUBLICACI�N DE CAMPA�AS");
		System.out.println("donnaipe crea tres campa�as");
		try {
			csanun.publicarCampana("Tute a Cuatro", Genero.ROCK, 10, 0.40f,csanun.getAnun(),"activa");
			csanun.publicarCampana("Europoly", Genero.ROCK, 8, 0.32f,csanun.getAnun(),"activa");
			csanun.publicarCampana("Domin� en Parejas", Genero.POP, 5, 0.20f,csanun.getAnun(), "activa");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPA�AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPA�AS");
		System.out.println("\nlista de campa�as:");
		
		List<String> descs = gcamp.listarCampanas(csanun.getAnun());
		for (String desc : descs)
			System.out.println(desc+"\n");
		System.out.println("hay "+csanun.getAnun().getContador()+" campa�as");

		System.out.println("\n<<cierre sesi�n donnaipe>>");
		csanun.cerrarSesion();	
		
		// ------------------------------------
		// -- Usuario megaclothes (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("\n<<inicio sesi�n megaclothes>>\n");	
		try {
			csanun.identificarAnunciante("megaclothes","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACI�N DE CAMPA�AS*******
		//*************************************	
		System.out.println("\nPUBLICACI�N DE CAMPA�AS");
		System.out.println("megaclothes crea dos campa�as");
		try {
			csanun.publicarCampana("Calcetines invierno", Genero.ROCK, 50, 2.00f, csanun.getAnun(),"activa");
			csanun.publicarCampana("Bufandas de lana", Genero.POP, 20, 0.80f, csanun.getAnun(),"activa");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPA�AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPA�AS");
		System.out.println("lista de campa�as:");
		List<String> descs1 = gcamp.listarCampanas(csanun.getAnun());
		for (String desc : descs1)
			System.out.println(desc+"\n");
		System.out.println("hay "+csanun.getAnun().getContador()+" campa�as");

		System.out.println("\n<<cierre sesi�n megaclothes>>");
		csanun.cerrarSesion();
	}

	/**
	 * M�todo que realiza los casos de uso de los socios
	 * @param cssoc controlador de sesi�n para el usuario socio
	 */
	private static void casosUsoSocios(ControladorSesionSocio cssoc) throws ArtistaException {
		System.out.println("\n\n/// CASOS DE USO SOCIOS ///\n");
		
		// ---------------------------
		// -- Usuario luisa (SOCIO) --
		// ---------------------------
		System.out.println("<<inicio sesi�n luisa>>\n");	
		try {
			cssoc.identificarUsuario("luisa","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//********PASAR A SOCIO PREMIUM********
		//*************************************
		System.out.println("\nPASAR A SOCIO PREMIUM");
		try {
			cssoc.inicPremium(true);
			System.out.println("Luisa pasa a ser socio premium");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//*****LISTAR CANCIONES POR ARTISTA****
		//*************************************	
		System.out.println("\nLISTAR CANCIONES POR ARTISTA");
		System.out.println("\nlista de canciones de Muse ordenadas alfab�ticamente:");
		try {
			List<Cancion> lista =cssoc.listarCanciones("muse", Orden.ALFA); //Para ordenar alfab�ticamente
			
				//una vez conseguidos todos los titulos ordenados imprimimos
				for(Cancion song: lista)
				{
						//imprimimos
						System.out.println(song.toString());
				}
		
				System.out.println("hay "+lista.size()+" canciones de Muse");
		
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Judas Priest ordenadas alfab�ticamente (inversa):");
		try {
			List<Cancion> lista =cssoc.listarCanciones("judas", Orden.NOTALFA);//Para ordenar inversa alfab�ticamente
		
			//una vez conseguidos todos los titulos ordenados imprimimos
			for(Cancion song: lista)
			{
					//imprimimos
					System.out.println(song.toString());
			}
			System.out.println("hay "+lista.size()+" canciones de Judas Priest");
		
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Pearl Jam ordenadas alfab�ticamente:");
		try {
			List<Cancion> lista=cssoc.listarCanciones("pearl", Orden.ALFA);
			
			//una vez conseguidos todos los titulos ordenados imprimimos
			for(Cancion song: lista)
			{
					//imprimimos
					System.out.println(song.toString());
			}
			System.out.println("hay "+lista.size()+" canciones de Pearl Jam");
			
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 
		
		System.out.println("\nlista de canciones de admin ordenadas alfab�ticamente:");
		try {
			List<Cancion> lista=cssoc.listarCanciones("admin", Orden.ALFA);
			
			//una vez conseguidos todos los titulos ordenados imprimimos
			for(Cancion song: lista)
			{
					//imprimimos
					System.out.println(song.toString());
			}
			
			System.out.println("hay "+lista.size()+" canciones de Admin");
						
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesi�n luisa>>");
		cssoc.cerrarSesion();
	}
}
