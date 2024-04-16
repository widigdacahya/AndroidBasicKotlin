package com.example.affrwrdapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affrwrdapp.data.Datasource
import com.example.affrwrdapp.model.Affirmation
import com.example.affrwrdapp.ui.theme.AffrWrdAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffrWrdAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}


@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations()
    )
}

@Composable
fun AffirmationCard(
    affirmationItemData: Affirmation,
    modifierArg: Modifier = Modifier
) {
    Card(modifier = modifierArg.padding(
        vertical = 4.dp,
        horizontal = 8.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = affirmationItemData.imageResourceId),
                contentDescription = stringResource(id = affirmationItemData.stringResourceId),
                modifier = modifierArg
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Box(modifier = modifierArg.padding(2.dp))
            Text(
                text = LocalContext.current.getString(affirmationItemData.stringResourceId),
                modifier = modifierArg.padding(
                    top = 4.dp,
                    bottom = 12.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun AffirmationList(affirmationList : List<Affirmation>, modifierArgHere: Modifier = Modifier) {
    LazyColumn(modifier = modifierArgHere) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmationItemData = affirmation,
                modifierArg = modifierArgHere.padding(2.dp)
            )
        }
    }
}



@Preview
@Composable
private  fun AffirmationCardPreview() {
    AffirmationCard( Affirmation(R.string.affirmation1, R.drawable.image1) )
}