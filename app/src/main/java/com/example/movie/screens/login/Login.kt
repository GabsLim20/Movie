package com.example.movie.screens.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movie.R
import com.example.movie.components.textStyled
import com.example.movie.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun Login(menuNavController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BackgroundImage()
            Spacer(modifier = Modifier.height(35.dp))
            textStyled(
                text = "Login", color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(50.dp))
            UserFormAndSubmit(menuNavController)

        }
    }
}

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.background_login),
        contentDescription = "background",
        //contentScale = ContentScale.FillBounds
        modifier = Modifier
            .fillMaxWidth()
            .scale(2.0f, 1.3f)
    )
}


@Composable
fun UserFormAndSubmit(menuNavController: NavController) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    Column() {
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(text = "Correo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
        Forgot()
        Button(
            onClick = {
                if (user.isNotEmpty() && password.isNotEmpty()) {
                    menuNavController.navigate(Screens.HOME)
                } else{ error = "Datos vacíos" }
            },
            modifier = Modifier
                .fillMaxWidth().padding(10.dp)
                .height(40.dp),
            shape = CircleShape
        ) {
            textStyled(text = "Iniciar Sesión", color = Color.White, style = MaterialTheme.typography.button)
        }
        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        LaunchedEffect(error) {
            if (error.isNotEmpty()) {
                delay(2000)
                error = ""
            }
        }

    }
}

@Preview
@Composable
fun Forgot(){
    Text(text = "¿Olvidaste tu contraseña?",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.End)
}

