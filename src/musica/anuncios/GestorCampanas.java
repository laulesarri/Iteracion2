package musica.anuncios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import musica.anuncios.Campana;
import musica.canciones.Genero;
import musica.usuarios.Anunciante;

public class GestorCampanas {

	//Instanciamos un mapa de campa�as
	
	private Map<String,Campana> mapaCampanas;
	private StringBuilder key= new StringBuilder();
	int contador;
	
public GestorCampanas() {
// Inicializamos mapa de campa�as
	mapaCampanas = new HashMap<>();
}

// M�todo para crear una campa�a
public void crearCampana(String descripcion, Genero genero, int numR, float costeTotal,Anunciante anun, String est){
	//Creamos la campa�a
	Campana camp=new Campana(descripcion, genero, numR, costeTotal, anun, est);
	
	contador=anun.getContador();
	camp.setId(contador);
	anun.setContador(1);
	
	key.append(anun.getNombre()).append(camp.getIdCampana());
	//Agregamos la campa�a al mapa de campa�as
	mapaCampanas.put(key.toString(), camp);
	
	
}

public List<String> listarCampanas(Anunciante Anun)
{
	//miramos todas las campa�as de nuestro mapa de campa�as, las campa�as que sean del mismo anunciante

	List<String> campanasAnunciante = new ArrayList<>();
	
	for(Campana campa: mapaCampanas.values())
	{	
		if(campa.getAnunciante().equals(Anun))
		//Rellenamos un array de las campa�as y luego conseguimos todos los objetos de campa�as del anunciante
		campanasAnunciante.add(campa.toString());

	}
	return campanasAnunciante;
	
}	


/*A�ado este m�todo por la forma de etiquetado que hemos elegido, para que as� cuando el anunciante cierre sesi�n
y otro anunciante se ponga a publicar canciones los contadores cuadren
para que un anunciante pueda encontrar una campa�a va a necesitar 2 parametros:
1) el nombre del anunciante
2) y el id de la campa�a*/
public void resetContador(int c)
{
	this.contador=c;
}

}