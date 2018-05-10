package musica.anuncios;

import musica.canciones.Genero;
import musica.usuarios.Anunciante;
public class Campana {

	/*private String idCamapa�a;*/
	private String descripcion;
	private Genero genero;
	private int repCampana;
	private int numRep;
	private float costeTotal;
	private float costeReal;
	private Anunciante anun;
	private String estado;
	private StringBuilder idCampana= new StringBuilder("campana - ");
	
/*Constructor*/
public Campana(String d, Genero ge, int numR, float costeTotal, Anunciante a, String est)
{
	/*Faltan atributos por instanciar*/
	this.descripcion=d;
	this.genero=ge;
	this.numRep=numR;
	this.costeTotal=costeTotal;
	this.anun=a;
	this.estado=est;
	
}
	

/*M�todos*/
/*M�todos Get*/
public String getIdCampana()
{
	return idCampana.toString();
}
public String getDescripcion()
{
	return descripcion;
}
	
public Genero getGenero()
{
	return genero;
}	
	
public int getRepCampana()
{
	return repCampana;
}

public int getNumRep()
{
	return numRep;
}
	
public float getCosteTotal()
{
	return costeTotal;
}

public float getCosteReal()
{
	return costeReal;
}

public Anunciante getAnunciante()
{
	return anun;
}


public String getEstado()
{
	return estado;
}

/*M�todos SET*/
public void setDescripcion(String d)
{
	this.descripcion=d;
}
	
public void setGenero(Genero g)
{
	this.genero=g;
}	
	
public void setRepCamapa�a(int r)
{
	this.numRep=r;
}

public void setCosteTotal(float ct)
{
	this.costeTotal=ct;
}

public void setAnunciante(Anunciante a)
{
	this.anun=a;
}

public void setEstado(String est)
{
	this.estado=est;
}
public void setId(int id)
{
	this.idCampana=idCampana.append(id);
}


/*M�todo toString*/
public String toString() 
{
	return "CAMPA�A\n " +idCampana.toString()+ "\n- Descripci�n: " +getDescripcion()+ "\n- Anunciante: " + getAnunciante().getNombre()+ 
			"\n- G�nero objetivo: " + getGenero()+ "\n- Reproducciones objetivo: " +getNumRep()+ 
			"\n- Reproducciones: " +getRepCampana()+ "\n- Coste objetivo: "+getCosteTotal()+ 
			"\n- Coste ejecutado: " +getCosteReal()+ "\n- Estado: " +getEstado();
}	

}