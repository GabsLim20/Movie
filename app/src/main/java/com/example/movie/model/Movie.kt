package com.example.movie.model

data class Movie(
    val title: String,
    val image: String,
    val detail: String,
    val score: String
)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            "Sherk",
            "https://m.media-amazon.com/images/I/71HPEO8IJTL._AC_UF894,1000_QL80_.jpg",
            "Shrek, un ogro verde solitario, se embarca en una misión para rescatar a la princesa Fiona de una torre custodiada por un dragón para que Lord Farquaad la despose y él pueda recuperar su tierra de las criaturas de cuento de hadas.",
            "5"
        ),
        Movie(
            "Trolls",
            "https://m.media-amazon.com/images/I/917N6Ymh38L._AC_UF894,1000_QL80_.jpg",
            "Los Trolls, seres felices y coloridos, deben embarcarse en una aventura para salvar a sus amigos de los malvados Bergens",
            "4.5"

        ),
        Movie(
            "Sherk",
            "https://m.media-amazon.com/images/I/71HPEO8IJTL._AC_UF894,1000_QL80_.jpg",
            "Shrek, un ogro verde solitario, se embarca en una misión para rescatar a la princesa Fiona de una torre custodiada por un dragón para que Lord Farquaad la despose y él pueda recuperar su tierra de las criaturas de cuento de hadas.",
            "5"
        ),
        Movie(
            "Trolls",
            "https://m.media-amazon.com/images/I/917N6Ymh38L._AC_UF894,1000_QL80_.jpg",
            "Los Trolls, seres felices y coloridos, deben embarcarse en una aventura para salvar a sus amigos de los malvados Bergens",
            "4.5"

        ),
        Movie(
            "Sherk",
            "https://m.media-amazon.com/images/I/71HPEO8IJTL._AC_UF894,1000_QL80_.jpg",
            "Shrek, un ogro verde solitario, se embarca en una misión para rescatar a la princesa Fiona de una torre custodiada por un dragón para que Lord Farquaad la despose y él pueda recuperar su tierra de las criaturas de cuento de hadas.",
            "5"
        ),
        Movie(
            "Trolls",
            "https://m.media-amazon.com/images/I/917N6Ymh38L._AC_UF894,1000_QL80_.jpg",
            "Los Trolls, seres felices y coloridos, deben embarcarse en una aventura para salvar a sus amigos de los malvados Bergens",
            "4.5"

        ),
    )
}
