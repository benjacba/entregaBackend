const options = {
        method: 'GET',
        headers: {
            accept: 'application/json',
            Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2Zjc3ZjNjYjE0OWVlM2Q4YzllZDc1NzE3ZTZmMjZkNiIsInN1YiI6IjY2NTg5MDRiNTE3MjViMzUxYjkzZWU1NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.GfM8dCnNT-ZUjfnhY9CWx-LaCHSoKTfikuXLKvGxkCA'
  }
};

    fetch('https://api.themoviedb.org/3/movie/popular?language=es&page=1&region=argentina', options)

    .then(response => response.json())


    //.then(response => console.log(response))

    
    .then(datos => {
        //console.log(datos.results);

        datos.results.forEach(element => {
            //console.log(element);

            const div = document.createElement('div');
            const img = document.createElement('img');

            img.src = "https://image.tmdb.org/t/p/original" + element.poster_path;
            img.style.width = '250px';

            const p = document.createElement('p');
            p.textContent = element.original_title;

            div.appendChild(img);
            div.appendChild(p);

            container.appendChild(div);

        })
    })


    .catch(err => console.error(err));