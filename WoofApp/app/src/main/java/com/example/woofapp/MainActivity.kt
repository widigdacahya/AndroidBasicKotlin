package com.example.woofapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woofapp.data.Dog
import com.example.woofapp.data.dogs
import com.example.woofapp.ui.theme.Shapes
import com.example.woofapp.ui.theme.WoofAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WoofApp()
                }
            }
        }
    }
}

/**
 * Composable to display an appbar and list of dogs
 * */
@Composable
fun WoofApp() {
    Scaffold {it ->
        LazyColumn(contentPadding = it) {
            items(dogs) {
                DogItemOfTheList(
                    dog = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}


/**
 * Composable to display dog's name and age
 *
 * @param dogName is the resource Id for string of dog's name
 * @param dogAge is Int that represent the dog's age
 * @param modifier is the modifiers to set to this composable
 * */
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier.padding(
                top = dimensionResource(id = R.dimen.padding_small)
            )
        )
        Text(
            text = stringResource(id = R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )

        // Checking string stuff for the content description image on function DogCircularPhoto
//        Text(
//            text =  stringResource(id = R.string.desc_dog_photo, stringResource(id = dogName))
//        )

    }
}


/**
 * Composable to display dog photo in circular form
 *
 * @param dogIcon is the image of dog resource Id
 * @param modifier is the modifier tp set this composable
 * */
@Composable
fun DogCircularPhoto(
    @DrawableRes dogIcon: Int,
    @StringRes dogName: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(Shapes.small),
        painter = painterResource(id = dogIcon),
        contentDescription = stringResource(id = R.string.desc_dog_photo, stringResource(id = dogName)),
        contentScale = ContentScale.Crop
    )
}


/**
 * Composable to show item list of dog data
 *
 * @param dogData contains data of the dog
 * @param modifier is modifiers to set this composable
 * */
@Composable
fun DogItemOfTheList(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = Shapes.medium
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            DogCircularPhoto(dogIcon = dog.imageResourcesId, dogName = dog.name)
            DogInformation(dogName = dog.name, dogAge = dog.age)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun WoofPreview() {
    WoofAppTheme(darkTheme = false) {
        WoofApp()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    WoofAppTheme(darkTheme = true) {
        WoofApp()
    }
}