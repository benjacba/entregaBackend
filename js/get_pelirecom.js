//Cuando el DOM se cargue
document.addEventListener("DOMContentLoaded", async() => {
    //Realiza la petición FETCH a la API para obtener todas las películas de la base de datos.
    //Configuracion de OPTIONS es un GET y NO necesita un BODY.
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };

    const response = await fetch('http://localhost:8080/webapp/peliculas_recomendadas', options);

    const data = await response.json();

    //Extraemos las películas de la respuesta.
    const movies = data;

    //Tenemos que insertar todas las peliculas en la tabla con id tabla_pelis_recom, pero en tBody.
    //Obtenemos el tBody de la tabla.
    const tBody = document.getElementById("bodyTablePelisRecom");

    //Recorremos todas las pelis.
    movies.forEach(movie => {
        //Creamos un tr para la peli.
        const tr = document.createElement("tr");

        //Creamos un td para el TITULO de la peli.
        const tdTitle = document.createElement("td");
        tdTitle.textContent = movie.titulo;

        //Creamos un td para el GENERO de la peli.
        const tdGenero = document.createElement("td");
        tdGenero.textContent = movie.genero;

        //Creamos un td para la DURACION de la peli.
        const tdDuracion = document.createElement("td");
        tdDuracion.textContent = movie.duracion;

        //Creamos un td para la SINOPSIS de la peli.
        const tdSinopsis = document.createElement("td");
        tdSinopsis.textContent = movie.sinopsis;

        //Creamos un td para la IMAGEN de la peli.
        const tdImagen = document.createElement("td");
        const img = document.createElement("img");
        img.src = "../assets/img/" + movie.imagen;
        img.width = 100;
        img.alt = movie.titulo;
        tdImagen.appendChild(img);

        //Añadimos los td al tr.
        tr.appendChild(tdTitle);
        tr.appendChild(tdGenero);
        tr.appendChild(tdDuracion);
        tr.appendChild(tdSinopsis);
        tr.appendChild(tdImagen);

        //Añadimos el tr al tBody.
        tBody.appendChild(tr);
        });
    });