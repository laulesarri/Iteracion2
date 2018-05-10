package musica.canciones;

import musica.usuarios.Artista;
import musica.canciones.Genero;

public class Cancion {

	private String titulo;
	private Artista autor;
	private Genero genero;
	private StringBuilder idCancion= new StringBuilder("C");
	private int numRep=0;


	/*Constructor*/
	public Cancion(String t, Artista creador, Genero g)
	{
		this.titulo=t;
		this.autor=creador;
		this.genero=g;
	}

	/*Métodos*/


	/*Métodos Get*/
	public String getTitulo()
	{
		return titulo;
	}

	public Artista getAutor()
	{
		return autor;
	}	

	public Genero getGenero()
	{
		return genero;
	}

	public String getIdCancion()
	{
		return idCancion.toString();
	}

	public int getNumRep()
	{
		return numRep;
	}



	/*Métodos SET*/
	public void setTitulo(String t)
	{
		this.titulo=t;
	}

	public void setAutor(Artista a)
	{
		this.autor=a;
	}	

	public void setGenero(Genero g)
	{
		this.genero=g;
	}

	public void setNumRep(int nR)
	{
		this.numRep=numRep+nR;
	}
	
	public void setId(int id)
	{
		this.idCancion=idCancion.append(id).append(getAutor().getNombre());
	}


	/*Método toString*/
	public String toString() 
	{
		return "Cancion: " +idCancion.toString()+ "\n - Titulo: " +getTitulo()+ 
				"\n - Artista: " + getAutor().getNombre()+ " \n - Género: " + getGenero()+ 
				"\n - Reproducciones: " +getNumRep()+"\n"; 
	}	

}