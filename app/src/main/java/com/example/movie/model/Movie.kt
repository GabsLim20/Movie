package com.example.movie.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    @SerializedName("title")
    val original_title: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    @SerializedName("details")
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
fun getMovies(): List<Movie> {
    return listOf(
        Movie(
            original_title = "Sherk",
            poster_path = "https://m.media-amazon.com/images/I/71HPEO8IJTL._AC_UF894,1000_QL80_.jpg",
            title = "Shrek, un ogro verde solitario, se embarca en una misión para rescatar a la princesa Fiona de una torre custodiada por un dragón para que Lord Farquaad la despose y él pueda recuperar su tierra de las criaturas de cuento de hadas.",
        ),
        Movie(
            original_title ="Trolls",
            poster_path = "https://m.media-amazon.com/images/I/917N6Ymh38L._AC_UF894,1000_QL80_.jpg",
            title = "Los Trolls, seres felices y coloridos, deben embarcarse en una aventura para salvar a sus amigos de los malvados Bergens",
        ),

    )
}