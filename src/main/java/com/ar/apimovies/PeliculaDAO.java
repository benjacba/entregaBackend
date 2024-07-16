package com.ar.apimovies;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PeliculaDAO {
    public Long InsertarPelicula(Pelicula pelicula) {
        String insertPeliculaSql = "INSERT INTO peliculas_recomendadas (titulo, genero, duracion, sinopsis, imagen) VALUES (?, ?, ?, ?, ?)";

        DatabaseConnection conexion = new DatabaseConnection();

        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Connection cn = conexion.conectar();

        try {
            pstm = cn.prepareStatement(insertPeliculaSql);
            pstm.setString(1, pelicula.getTitulo());
            pstm.setString(2, pelicula.getGenero());
            pstm.setString(3, pelicula.getDuracion());
            pstm.setString(4, pelicula.getSinopsis());
            pstm.setString(5, pelicula.getImagen());

            int result = pstm.executeUpdate();

            if (result > 0) {
                rs = pstm.getGeneratedKeys();

                if (rs.next()) {
                    System.out.println("Pelicula insertada correctamente");
                    return (long) rs.getInt(1);
                } else{
                    System.out.println("Pelicula no insertada");
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return null;
        }
        return null;
    }

    public List<Pelicula> getAllPeliculas() {
        String selectAllPeliculasSql = "SELECT * FROM peliculas_recomendadas";

        DatabaseConnection conexion = new DatabaseConnection();

        List<Pelicula> peliculas = new ArrayList<>();

        Statement stm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        Connection cn = conexion.conectar();

        try {
            pstm = cn.prepareStatement(selectAllPeliculasSql);

            rs = pstm.executeQuery();

            while (rs.next()) {
                int idPelicula = rs.getInt("id");
                String tituloPelicula = rs.getString("titulo");
                String generoPelicula = rs.getString("genero");
                String duracionPelicula = rs.getString("duracion");
                String sinopsisPelicula = rs.getString("sinopsis");
                String imagenPelicula = rs.getString("imagen");

                Pelicula pelicula = new Pelicula(idPelicula, tituloPelicula, generoPelicula, duracionPelicula, sinopsisPelicula, imagenPelicula);

                peliculas.add(pelicula);

            }

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

        return peliculas;
    }


}
