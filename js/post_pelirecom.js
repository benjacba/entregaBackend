document.addEventListener("DOMContentLoaded", async() => {
    formNuevaPeliculaRecom = document.getElementById("formrecomendacionpeli");

    formNuevaPeliculaRecom.addEventListener("submit", async(event) => {
        event.preventDefault();

        const formData = new FormData(formNuevaPeliculaRecom);

        const titulo = formData.get("titulo");
        const genero = formData.get("genero");
        const duracion = formData.get("duracion");
        const sinopsis = formData.get("sinopsis");
        const imagen = formData.get("imagenpelicula");

        if(titulo == "" || genero == "" || duracion == "" || sinopsis == "" || imagen == "") {
            alert("Todos los campos son obligatorios");
            return;
        }

        const imageName = imagen.name;

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                titulo: titulo,
                genero: genero,
                duracion: duracion,
                sinopsis: sinopsis,
                imagen: imageName
            })
        };

        const response = await fetch('http://localhost:8080/webapp/peliculas_recomendadas', options);

        const data = await response.json();

        if(response.status == 201) {
            alert("Pelicula agregada correctamente!");
            formNuevaPeliculaRecom.reset();

            location.reload();
        } else {
            alert('Error al agregar la pelicula');
        }
    });
});