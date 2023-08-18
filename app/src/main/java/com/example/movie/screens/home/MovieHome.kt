package com.example.movie.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movie.R
import com.example.movie.components.textStyled
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieHome(menuNavController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.onBackground
    ) {
        HomePager()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePager(viewModel: MovieViewModel = hiltViewModel()) {
    val state = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()
    val titles = listOf("Movie", "Series")
    Column {
        Row() {
            textStyled(
                text = stringResource(R.string.title),
                color = Color.White,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.fillMaxWidth(.4f)
            )
            LazyRow() {
                itemsIndexed(titles) { index, title ->
                    ClickableText(
                        text = AnnotatedString(title),
                        onClick = {
                            coroutineScope.launch {
                                state.animateScrollToPage(index)
                            }
                        },
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                        ),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        HorizontalPager(pageCount = 2, state = state ) {
            when (it) {
                0 -> MoviePager (viewModel)
                1 -> SeriePager (viewModel)
            }
        }
    }
}

@Composable
fun MoviePager(viewModel: MovieViewModel) {
    viewModel.getList()
    val viewState by viewModel.viewStateListMovie.collectAsState()
    Column() {
        Header(viewState.image, viewState.title, viewState.drama)
        Spacer(modifier = Modifier.height(30.dp))
        MovieRow(viewState.movieList) { image, title, drama ->
            viewModel.refreshHeader(image, title, drama)
        }
    }
}

@Composable
fun SeriePager(viewModel: MovieViewModel ) {
    viewModel.getListSerie()
    val viewState by viewModel.viewStateListMovie.collectAsState()
    Column() {
        Header(viewState.image, viewState.title, viewState.drama)
        Spacer(modifier = Modifier.height(30.dp))
        SerieRow(viewState.serieList) {image, title, drama -> viewModel.refreshHeader(image, title, drama)}
    }
}

@Composable
fun Header(
    image: String, title: String, drama: String,
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
fun MovieRow(
    movieList: List<MovieInformation>,
    onItemClick: (String, String, String) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        items(movieList) {information ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 160.dp, width = 160.dp)
                    .clickable {
                        onItemClick(information.image, information.title, information.drama)
                    },
                elevation = 5.dp,

            ) {
                Column() {
                    AsyncImage(
                        model = information.image,
                        contentDescription = "image",
                        modifier = Modifier.size(width = 160.dp, height = 80.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    textStyled(
                        text = information.title,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(3.dp)
                    )
                    Text(
                        text = information.drama,
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
@Composable
fun SerieRow(
    serieList: List<MovieInformation>,
    onItemClick: (String, String, String) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        items(serieList) {information ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(height = 160.dp, width = 160.dp)
                    .clickable {
                        onItemClick(information.image, information.title, information.drama)
                    },
                elevation = 5.dp,

                ) {
                Column() {
                    AsyncImage(
                        model = information.image,
                        contentDescription = "image",
                        modifier = Modifier.size(width = 160.dp, height = 80.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    textStyled(
                        text = information.title,
                        color = Color.Black,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(3.dp)
                    )
                    Text(
                        text = information.drama,
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
