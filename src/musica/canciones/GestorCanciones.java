package musica.canciones;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import musica.usuarios.Artista;
import musica.canciones.Genero;
import musica.canciones.Orden;

public class GestorCanciones {

	/*Instanciamos un mapa de canciones*/
	private Map<String,Cancion> mapaCanciones;
	private StringBuilder key= new StringBuilder();
	int contador;
	
public GestorCanciones() {
// inicializo mapa de canciones
	mapaCanciones = new HashMap<>();
}


public void crearCancion(String titulo, Artista autor, Genero genero){
	//Creamos la cancion
	Cancion c=new Cancion(titulo,autor,genero);
	contador=autor.getContador();
	c.setId(contador);
	autor.setContador(1);
	//nuestra clave va a ser la concatenacion del nombre del autor con el id de la cancion
	//todo ello para tener un mapa de canciones de todos los artistas, luego iremos iterando
	key.append(autor.getNombre()).append(c.getIdCancion());
	//Agregamos la cancion al mapa de canciones
	mapaCanciones.put(key.toString(), c);
	
}

public List<Cancion> listarCanciones(Artista Art, Orden or)
{
	//miramos todas las canciones de nuestro mapa de canciones, las canciones que sean del mismo
	//artista las imprimiremos por pantalla
	List<Cancion> cancionesArtista = new ArrayList<>();
	List <Cancion> cancionesArtistaOrden=new ArrayList<>();
	List<String> titulos = new ArrayList<>();
	
	for(Cancion song: mapaCanciones.values())
	{
		//Ahora hemos conseguido en titulos, todos los titulos de las canciones a ordenar
		if(song.getAutor().equals(Art))
			//Rellenamos un array de los titulos de las canciones a ordenar
			//y luego conseguimos todos los objetos de canciones del artista
			titulos.add(song.getTitulo());
			cancionesArtista.add(song);
	}
	
	if(or==Orden.ALFA)
	{
		Collections.sort(titulos);/*ordenamos los titulos*/
		for(String t: titulos)
		{
			//una vez conseguidos todos los titulos ordenados imprimimos
			for(Cancion song: cancionesArtista)
			{
				if(t==song.getTitulo())
				cancionesArtistaOrden.add(song);/*esta lista será la definitiva ordenada de manera alfabetica*/
			}
		}
		return cancionesArtistaOrden;
	}
	else
	{
		//primero los ordenamos alfabéticamente y lo invertimos para dar el orden inverso
		Collections.sort(titulos);
		Collections.reverse(titulos);
		for(String t: titulos)
		{
			//una vez conseguidos todos los titulos ordenados imprimimos
			for(Cancion song: cancionesArtista)
			{
				if(t==song.getTitulo())
					cancionesArtistaOrden.add(song);/*esta lista será la definitiva ordenada de manera alfabetica*/
					
			}
		}
		return cancionesArtistaOrden;
	}
}


//Añado este método por la forma de etiquetado que hemos elegido, para 
//que así cuando el artista cierre sesión
//y otro artista se ponga a publicar canciones los contadores cuadren
//la idea principal es que cada arista va a tener el mismo etiquetado de sus canciones: c0,c1...cn
//un etiquetado que se le asignará según vaya publicando canciones
//este etiquetado viene estrechamente ligado al artista puesto que puede haber dos canciones c0 pero no iguales
//para que un usuario pueda encontrar una cancion va a necesitar 2 parametros:
// 1) el nombre del artista
// 2) y el etiquetado de esa canción dentro de su playlist
public void resetContador(int c)
{
	this.contador=c;
}


}