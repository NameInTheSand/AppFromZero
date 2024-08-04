package com.ukrdroiddev.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ukrdroiddev.entities.Joke
import com.ukrdroiddev.presentation.ui.theme.AppFromZeroTheme
import com.ukrdroiddev.presentation.viewModels.MainViewModel
import com.ukrdroiddev.utils.NetworkError
import com.ukrdroiddev.utils.Result
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFromZeroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val joke = viewModel.jokeFlow.collectAsState()

                    if (joke.value == null) {
                        EmptyScreen()
                        return@Scaffold
                    }

                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Text(
                            text = mapToText(joke.value!!),
                            modifier = Modifier
                                .padding(vertical = 32.dp, horizontal = 16.dp)
                                .fillMaxWidth()
                                .height(400.dp)
                        )
                        GetJokeButton(
                            modifier = Modifier
                                .padding(vertical = 16.dp, horizontal = 16.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                        )
                    }

                }
            }
        }
    }

    private fun mapToText(joke: Result<Joke, NetworkError>): String {
        return when (joke) {
            is Result.Success -> joke.data.joke
            is Result.Error -> joke.error.name
        }
    }

    @Composable
    private fun EmptyScreen() {
        Column {
            Spacer(modifier = Modifier.height(300.dp))

            Text(
                text = "No joke",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    private fun GetJokeButton(modifier: Modifier = Modifier) {
        Button(
            onClick = { viewModel.getRandomJoke() },
            modifier = modifier
        ) {
            Text(
                text = "Get joke",
                textAlign = TextAlign.Center
            )
        }
    }

}

