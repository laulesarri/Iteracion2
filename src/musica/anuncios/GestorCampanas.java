package musica.anuncios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import musica.anuncios.Campana;
import musica.canciones.Genero;
import musica.usuarios.Anunciante;

public class GestorCampanas {

	//Instanciamos un mapa de campañas
	
	private Map<String,Campana> mapaCampanas;
	private StringBuilder key= new StringBuilder();
	int contador;
	
public GestorCampanas() {
// Inicializamos mapa de campañas
	mapaCampanas = new HashMap<>();
}

// Método para crear una campaña
public void crearCampana(String descripcion, Genero genero, int numR, float costeTotal,Anunciante anun, String est){
	//Creamos la campaña
	Campana camp=new Campana(descripcion, genero, numR, costeTotal, anun, est);
	
	contador=anun.getContador();
	camp.setId(contador);
	anun.setContador(1);
	
	key.append(anun.getNombre()).append(camp.getIdCampana());
	//Agregamos la campaña al mapa de campañas
	mapaCampanas.put(key.toString(), camp);
	
	
}

public List<String> listarCampanas(Anunciante Anun)
{
	//miramos todas las campañas de nuestro mapa de campañas, las campañas que sean del mismo anunciante

	List<String> campanasAnunciante = new ArrayList<>();
	
	for(Campana campa: mapaCampanas.values())
	{	
		if(campa.getAnunciante().equals(Anun))
		//Rellenamos un array de las campañas y luego conseguimos todos los objetos de campañas del anunciante
		campanasAnunciante.add(campa.toString());

	}
	return campanasAnunciante;
	
}	


/*Añado este método por la forma de etiquetado que hemos elegido, para que así cuando el anunciante cierre sesión
y otro anunciante se ponga a publicar canciones los contadores cuadren
para que un anunciante pueda encontrar una campaña va a necesitar 2 parametros:
1) el nombre del anunciante
2) y el id de la campaña*/
public void resetContador(int c)
{
	this.contador=c;
}

}