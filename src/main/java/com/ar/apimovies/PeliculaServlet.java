package com.ar.apimovies;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

//Responder a la solicitud HTTP de la URL /peliculas
@WebServlet("/peliculas_recomendadas")
public class PeliculaServlet extends HttpServlet{

   //Generamos la instancia de las operaciones de la base de datos
   private PeliculaDAO peliculaDAO = new PeliculaDAO();

   //Generar una instancia de un objeto que utiliza libreria JACKSON para conventir un objeto en json y viceversa
   private ObjectMapper objectMapper = new ObjectMapper();

   @Override
   //Metodo POST para insertar una nueva pelicula desde una solicitud JSON.
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // Configurar cabeceras CORS
      resp.setHeader("Access-Control-Allow-Origin", "*");
      resp.setHeader("Access-Control-Allow-Methods", "*");
      resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

      // Establecer la codificación de caracteres
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");

      // Leer JSON del cuerpo de la solicitud y convertirlo en un objeto Pelicula
      Pelicula pelicula = objectMapper.readValue(req.getInputStream(), Pelicula.class);

      // Insertar la película en la base de datos
      Long id = peliculaDAO.InsertarPelicula(pelicula);

      // Convertir el id a JSON
      String jsonResponse = objectMapper.writeValueAsString(id);

      // Establecer el tipo de contenido de la respuesta a JSON
      resp.setContentType("application/json");

      // Escribir la respuesta JSON
      resp.getWriter().write(jsonResponse);

      // Establecer el estado de la respuesta a 201 (Creado)
      resp.setStatus(HttpServletResponse.SC_CREATED);

      // No es necesario llamar a super.doPost(req, resp); al final, ya que podría causar una excepción "Servlet has already been committed".
      // super.doPost(req, resp);
   }

   @Override
   //Metodo GET para obtener todas las peliculas almacenadas en la base de datos y devolverlas como JSON.
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // Configurar cabeceras CORS
      resp.setHeader("Access-Control-Allow-Origin", "*");
      resp.setHeader("Access-Control-Allow-Methods", "*");
      resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

      // Establecer la codificación de caracteres
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");

      try {
         //Obtener las peliculas
         List<Pelicula> peliculas = peliculaDAO.getAllPeliculas();
         String jsonResponse = objectMapper.writeValueAsString(peliculas);
         // Establecer el tipo de contenido de la respuesta a JSON
         resp.setContentType("application/json");
         resp.getWriter().write(jsonResponse);

      } catch (NumberFormatException e) {
         e.printStackTrace();
         resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
      }
   }

}
