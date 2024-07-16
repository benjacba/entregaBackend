package com.ar.apimovies;

//Clase Pelicula: Representa el modelo de datos.
public class Pelicula {
    //Atributos de la clase.
    private int id; // Identificador de la pelicula. Autoincremental.
    private String titulo; // Titulo de la pelicula. (Varchar).
    private String genero; // Genero de la pelicula. (Varchar).
    private String duracion; // Duracion de la pelicula. (Varchar).
    private String sinopsis; // Sinopsis de la pelicula. (Varchar).
    private String imagen; // URL de la imagen de la pelicula. (Varchar).

    //Constructor vacio necesario para deserializacion de JSON.
    public Pelicula(){
        
    }

    //Constructor con parametros para inicializar los atributos.
    public Pelicula(int id, String titulo, String genero, String duracion, String sinopsis, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
    }

    //Getters (obtener) y setters (establecer).
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracion=" + duracion
                + ", imagen=" + imagen + "]";
    }

}
