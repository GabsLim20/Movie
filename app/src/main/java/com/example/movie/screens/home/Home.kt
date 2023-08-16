package com.example.movie.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movie.R
import com.example.movie.components.textStyled
import com.example.movie.model.Movie
import com.example.movie.model.getMovies

@Composable
fun Home(menuNavController: NavHostController, viewModel: MovieViewModel = hiltViewModel()) {
    viewModel.getMovies()
    val viewState by viewModel.viewState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.secondary
    ) {
        Column() {
            Header(viewState.image,viewState.title,viewState.drama)
            Spacer(modifier = Modifier.height(30.dp))
            MovieRow(viewState.image,viewState.title,viewState.drama)
        }
    }


}

@Composable
fun Header(
    image: String, title: String, drama: String
) {
    Row(
        modifier = Modifier
            .fillMaxHeight(.3f)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.4f)
                .padding(top = 8.dp)
        ) {
            textStyled(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(3.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            textStyled(
                text = drama,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1, modifier = Modifier.padding(3.dp)
            )
        }
        AsyncImage(
            model = image, contentDescription = "header",
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterVertically),
            contentScale = ContentScale.FillBounds
        )
    }
}


@Composable
fun MovieRow(image: String, title: String, drama: String, onItemClick: (String) -> Unit = {}) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        items(18) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 160.dp, width = 160.dp),
                elevation = 5.dp
            ) {
                Column() {
                    AsyncImage(
                        model = image,
                        contentDescription = "image",
                        modifier = Modifier.size(width = 160.dp, height = 80.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    textStyled(
                        text = title,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(3.dp)
                    )
                    Text(
                        text = drama,
                        color = Color.Black,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(3.dp),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

    }
}
