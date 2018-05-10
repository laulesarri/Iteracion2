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
import musica.excepciones.CampanaException;
import musica.excepciones.CancionException;
import musica.excepciones.UsuarioException;
import musica.gestores.GestorUsuarios;

public class PruebasMusicaIter2 {
	
	/**
	 * MÃ©todo main(). No se esperan parÃ¡metros.
	 * @param args parÃ¡metros por lÃ­nea de comandos que no se tratan.
	 */
	public static void main(String[] args) {
	
		//*************************************
		//*******INICIALIZACION GESTORES*******
		//*************************************						
		// Instancio los gestores de usuarios, canciones, campaÃ±as
		GestorUsuarios gu = new GestorUsuarios();
		GestorMusica gm = new GestorMusica();
		GestorCampanas gc = new GestorCampanas();
		
		//*************************************
		//****INICIALIZACION CONTROLADORES*****
		//*************************************				
		// Instancio controladores de sesiÃ³n
		ControladorSesionAdministrador csadmin = new ControladorSesionAdministrador(gu);
		ControladorSesionArtista csart = new ControladorSesionArtista(gu, gm);
		ControladorSesionAnunciante csanun = new ControladorSesionAnunciante(gu, gc);
		ControladorSesionSocio cssoc = new ControladorSesionSocio(gu, gm, gc);
		
		
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO PREVIOS");
		System.out.println("////////////////////////////////////////////////////////\n");	
		casosUsoAdmin(csadmin, gu);
		casosUsoArtistasIter1(csart, gu, gm);
		casosUsoAnunciantesIter1(csanun, gu, gc);
		casosUsoSociosIter1(cssoc, gu, gm, gc);			
		
		
		System.out.println("\n////////////////////////////////////////////////////////");
		System.out.println("// CASOS DE USO ITERACIÃ“N 2");
		System.out.println("////////////////////////////////////////////////////////\n");
		casosUsoSociosIter2(cssoc, gu, gm, gc);
		casosUsoArtistasIter2(csart, gu, gm);
		casosUsoAnunciantesIter2(csanun, gu, gc);
	}


	/**
	 * MÃ©todo que realiza los casos de uso de los administradores
	 * @param csadmin controlador de sesiÃ³n para el usuario admin
	 * @param gu gestor de usuarios
	 */
	private static void casosUsoAdmin(ControladorSesionAdministrador csadmin,
			GestorUsuarios gu) {
		System.out.println("/// CASOS DE USO ADMINISTRADOR ///\n");
		
		// ------------------------------------
		// -- Usuario admin (ADMINISTRADOR) --
		// ------------------------------------
		System.out.println("<<inicio sesiÃ³n admin>>");
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
		
		System.out.println("\n<<cierre sesiÃ³n admin>>");
		csadmin.cerrarSesion();
	}

	/**
	 * MÃ©todo que realiza los casos de uso de los artistas de la iteraciÃ³n 1
	 * @param csart controlador de sesiÃ³n para el usuario artista
	 * @param gu gestor de usuarios
	 * @param gm gestor de mÃºsica
	 */
	private static void casosUsoArtistasIter1(ControladorSesionArtista csart,
			GestorUsuarios gu, GestorMusica gm) {
		System.out.println("\n\n/// CASOS DE USO ARTISTAS ///\n");
		
		// ------------------------------------
		// -- Usuario muse (ARTISTA) --
		// ------------------------------------
		System.out.println("<<inicio sesiÃ³n muse>>\n");	
		try {
			csart.identificarArtista("muse","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACIÃ“N DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACIÃ“N DE CANCIONES");
		System.out.println("muse crea cuatro canciones");
		try {			
			csart.publicarCancion("Hysteria", Genero.ROCK);
			csart.publicarCancion("Madness", Genero.ELECTRONICA);
			csart.publicarCancion("Starlight", Genero.ROCK);
			csart.publicarCancion("Resistance", Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesiÃ³n muse>>");
		csart.cerrarSesion();
		
		
		// ------------------------------------
		// -- Usuario judas priest (ARTISTA) --
		// ------------------------------------
		System.out.println("\n<<inicio sesiÃ³n judas priest>>\n");	
		try {
			csart.identificarArtista("judas","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******PUBLICACIÃ“N DE CANCIONES******
		//*************************************	
		System.out.println("PUBLICACIÃ“N DE CANCIONES");
		System.out.println("judas crea tres canciones");
		try {			
			csart.publicarCancion("Victim of changes", Genero.ROCK);
			csart.publicarCancion("Breaking the law", Genero.ROCK);
			csart.publicarCancion("Painkiller", Genero.ROCK);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesiÃ³n judas priest>>");
		csart.cerrarSesion();
	}

	/**
	 * MÃ©todo que realiza los casos de uso de los anunciantes de la iteraciÃ³n 1
	 * @param csanun controlador de sesiÃ³n para el usuario anunciante
	 * @param gu gestor de usuarios
	 * @param gc gestor de campaÃ±as
	 */
	private static void casosUsoAnunciantesIter1(ControladorSesionAnunciante csanun,
			GestorUsuarios gu, GestorCampanas gc) {
		System.out.println("\n\n/// CASOS DE USO ANUNCIANTES ///\n");
		
		// ------------------------------------
		// -- Usuario donnaipe (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("<<inicio sesion donnaipe>>\n");	
		try {
			csanun.identificarAnunciante("donnaipe","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACIÃ“N DE CAMPAÃ‘AS*******
		//*************************************	
		System.out.println("\nPUBLICACION DE CAMPANAS");
		System.out.println("donnaipe crea tres campanas");
		try {
			csanun.publicarCampana("Tute a Cuatro", Genero.ROCK, 10);
			csanun.publicarCampana("Europoly", Genero.ROCK, 8);
			csanun.publicarCampana("Domino en Parejas", Genero.POP, 5);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÃ‘AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÃ‘AS");
		System.out.println("lista de campaÃ±as:");
		try {
			List<String> descs = csanun.listarMisCampanas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campaÃ±as");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesiÃ³n donnaipe>>");
		csanun.cerrarSesion();	
		
		// ------------------------------------
		// -- Usuario megaclothes (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("\n<<inicio sesiÃ³n megaclothes>>\n");	
		try {
			csanun.identificarAnunciante("megaclothes","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*******PUBLICACIÃ“N DE CAMPAÃ‘AS*******
		//*************************************	
		System.out.println("\nPUBLICACIÃ“N DE CAMPAÃ‘AS");
		System.out.println("megaclothes crea dos campaÃ±as");
		try {
			csanun.publicarCampana("Calcetines invierno", Genero.ROCK, 50);
			csanun.publicarCampana("Bufandas de lana", Genero.POP, 20);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		//*************************************
		//*****LISTAR CAMPAÃ‘AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPANAS");
		System.out.println("lista de campanas:");
		try {
			List<String> descs = csanun.listarMisCampanas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campanas");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n<<cierre sesion megaclothes>>");
		csanun.cerrarSesion();
	}

	/**
	 * Metodo que realiza los casos de uso de los socios de la iteracion 1
	 * @param cssoc controlador de sesion para el usuario socio
	 * @param gu gestor de usuarios
	 * @param gm gestor de musica
	 * @param gc gestor de campanas
	 */
	private static void casosUsoSociosIter1(ControladorSesionSocio cssoc,
			GestorUsuarios gu, GestorMusica gm, GestorCampanas gc) {
		System.out.println("\n\n/// CASOS DE USO SOCIOS ///\n");
		
		// ---------------------------
		// -- Usuario luisa (SOCIO) --
		// ---------------------------
		System.out.println("<<inicio sesiÃ³n luisa>>\n");	
		try {
			cssoc.identificarSocio("luisa","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//********PASAR A SOCIO PREMIUM********
		//*************************************
		System.out.println("\nPASAR A SOCIO PREMIUM");
		try {
			cssoc.activarPremium(true);
			System.out.println("Luisa pasa a ser socio premium");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//*****LISTAR CANCIONES POR ARTISTA****
		//*************************************	
		System.out.println("\nLISTAR CANCIONES POR ARTISTA");
		System.out.println("\nlista de canciones de Muse ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("muse", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Muse");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Judas Priest ordenadas alfabÃ©ticamente (inversa):");
		try {
			List<String> descs = cssoc.listarCancionesArtista("judas", Orden.ALFA_INV);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Judas Priest");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		} 
		System.out.println("\nlista de canciones de Pearl Jam ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("pearl", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Pearl Jam");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} catch (ArtistaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nlista de canciones de admin ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesArtista("admin", Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de admin");
		} catch (UsuarioException | ArtistaException e) {
			System.out.println(e.getMessage());
		}
	}
	

	/**
	 * MÃ©todo que realiza los casos de uso de los socios de la iteraciÃ³n 2
	 * @param cssoc controlador de sesiÃ³n para el usuario socio
	 * @param gu gestor de usuarios
	 * @param gm gestor de mÃºsica
	 * @param gc gestor de campaÃ±as
	 */
	private static void casosUsoSociosIter2(ControladorSesionSocio cssoc,
			GestorUsuarios gu, GestorMusica gm, GestorCampanas gc) {
		System.out.println("\n\n/// CASOS DE USO SOCIOS ///\n");
		// ---------------------------
		// -- Usuario luisa (SOCIO) --
		// ---------------------------
		System.out.println("<<inicio sesiÃ³n luisa>>\n");	
		try {
			cssoc.identificarSocio("luisa","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		

		//*************************************
		//*****LISTAR CANCIONES POR GÃ‰NERO*****
		//*************************************	
		System.out.println("\nLISTAR CANCIONES POR GÃ‰NERO");
		System.out.println("lista de canciones del gÃ©nero rock ordenadas alfabÃ©ticamente (inversa):");
		try {
			List<String> descs = cssoc.listarCancionesGenero(Genero.ROCK, Orden.ALFA_INV);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de rock");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("lista de canciones del gÃ©nero electrÃ³nico ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesGenero(Genero.ELECTRONICA, Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de electrÃ³nica");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("lista de canciones del gÃ©nero pop ordenadas alfabÃ©ticamente:");
		try {
			List<String> descs = cssoc.listarCancionesGenero(Genero.POP, Orden.ALFA);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de pop");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}

		//*************************************
		//***REPRODUCIR CANCIÃ“N SOCIO PREMIUM**
		//*************************************		
		System.out.println("\nREPRODUCIR CANCIÃ“N SOCIO PREMIUM");
		System.out.println("solicita reproducir cancion-0:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-0"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-1:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-1"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-1:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-1"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-6:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-6"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-10:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-10"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n<<cierre sesiÃ³n luisa>>");
		cssoc.cerrarSesion();
		
		
		// ---------------------------
		// -- Usuario mike (SOCIO) --
		// ---------------------------
		System.out.println("\n<<inicio sesiÃ³n mike>>");	
		try {
			cssoc.identificarSocio("mike","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
	
		//*************************************
		//***REPRODUCIR CANCIÃ“N SOCIO BÃ�SICO***
		//*************************************		
		System.out.println("\nREPRODUCIR CANCIÃ“N SOCIO BÃ�SICO");
		System.out.println("solicita reproducir cancion-0:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-0"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-1:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-1"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-2:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-2"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-4:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-4"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-4:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-4"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		System.out.println("\nsolicita reproducir cancion-7:");		
		try {
			System.out.println(cssoc.reproducirCancion("cancion-7"));
		} catch (UsuarioException | CancionException e) {			
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n<<cierre sesiÃ³n mike>>");
		cssoc.cerrarSesion();
	}

	/**
	 * MÃ©todo que realiza los casos de uso de los artistas de la iteraciÃ³n 2
	 * @param csart controlador de sesiÃ³n para el usuario artista
	 * @param gu gestor de usuarios
	 * @param gm gestor de mÃºsica
	 */
	private static void casosUsoArtistasIter2(ControladorSesionArtista csart,
			GestorUsuarios gu, GestorMusica gm) {
		System.out.println("\n\n/// CASOS DE USO ARTISTAS ///\n");

		// ------------------------------------
		// -- Usuario muse (ARTISTA) --
		// ------------------------------------
		System.out.println("<<inicio sesiÃ³n muse>>\n");	
		try {
			csart.identificarArtista("muse","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*******LISTAR CANCIONES ARTISTA******
		//*************************************	
		System.out.println("\nLISTAR CANCIONES ARTISTA");
		System.out.println("lista de canciones artista muse ordenadas por # reproducciones:");
		try {
			List<String> descs = csart.listarMisCanciones(Orden.REP);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Muse");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 			

		System.out.println("\n<<cierre sesiÃ³n muse>>");
		csart.cerrarSesion();
		
		
		// ------------------------------------
		// -- Usuario judas priest (ARTISTA) --
		// ------------------------------------
		System.out.println("\n<<inicio sesiÃ³n judas priest>>\n");	
		try {
			csart.identificarArtista("judas","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}		
		
		//*************************************
		//*******LISTAR CANCIONES ARTISTA******
		//*************************************	
		System.out.println("\nLISTAR CANCIONES ARTISTA");
		System.out.println("lista de canciones artista judas priest ordenadas por # reproducciones inverso:");
		try {
			List<String> descs = csart.listarMisCanciones(Orden.REP_INV);
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" canciones de Judas Priest");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		} 	

		System.out.println("\n<<cierre sesiÃ³n judas priest>>");
		csart.cerrarSesion();
	}

	/**
	 * MÃ©todo que realiza los casos de uso de los anunciantes de la iteraciÃ³n 2
	 * @param csanun controlador de sesiÃ³n para el usuario anunciante
	 * @param gu gestor de usuarios
	 * @param gc gestor de campaÃ±as
	 */
	private static void casosUsoAnunciantesIter2(ControladorSesionAnunciante csanun, 
			GestorUsuarios gu, GestorCampanas gc) {
		System.out.println("\n\n/// CASOS DE USO ANUNCIANTES ///\n");

		// ------------------------------------
		// -- Usuario donnaipe (ANUNCIANTE) --
		// ------------------------------------
		System.out.println("<<inicio sesiÃ³n donnaipe>>\n");	
		try {
			csanun.identificarAnunciante("donnaipe","clave");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*****LISTAR CAMPAÃ‘AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÃ‘AS");
		System.out.println("lista de campaÃ±as:");
		try {
			List<String> descs = csanun.listarMisCampanas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campaÃ±as");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
				
		//*************************************
		//*****CANCELAR CAMPAÃ‘A ANUNCIANTE*****
		//*************************************	
		System.out.println("\nCANCELAR CAMPAÃ‘A");
		System.out.println("cancelo campaÃ±a campana-2:");
		try {
			csanun.cancelarCampana("campana-2");
		} catch (UsuarioException | CampanaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("cancelo campaÃ±a campana-5:");
		try {
			csanun.cancelarCampana("campana-5");
		} catch (UsuarioException | CampanaException e) {
			System.out.println(e.getMessage());
		}
		
		//*************************************
		//*****LISTAR CAMPAÃ‘AS ANUNCIANTE******
		//*************************************	
		System.out.println("\nLISTAR CAMPAÃ‘AS");
		System.out.println("lista de campaÃ±as:");
		try {
			List<String> descs = csanun.listarMisCampanas();
			for (String desc : descs)
				System.out.println(desc+"\n");
			System.out.println("hay "+descs.size()+" campaÃ±as");
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("\n<<cierre sesiÃ³n donnaipe>>");
		csanun.cerrarSesion();	
	}
}
