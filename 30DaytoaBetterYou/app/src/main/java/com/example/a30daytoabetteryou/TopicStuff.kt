package com.example.a30daytoabetteryou

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a30daytoabetteryou.model.Topic

@Composable
fun TopicsList(
    topics: List<Topic>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
   LazyColumn(
       contentPadding = contentPadding,
//       verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {
       itemsIndexed(topics) { index, topic ->
            ItemTopicList(
                topicData = topic,
                indexCounter = index,
                modifier = Modifier
            )

       }
   }
}


@Composable
fun ItemTopicList(
    topicData: Topic,
    indexCounter: Int,
    modifier: Modifier
) {

    var expandedItemTopic by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier.padding(
            vertical = 8.dp,
            horizontal = 12.dp
        )
    ) {
        Column(
            modifier = modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(
                    bottom = 8.dp
                )
        ) {
            Image(
                painter = painterResource(id = topicData.imageResourceId),
                contentDescription = stringResource(id = topicData.topicStringResourceId) + "photo",
                modifier = modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Day " + (indexCounter + 1) + " : " + stringResource(id = topicData.topicStringResourceId)
                )
                Spacer(modifier = Modifier.weight(1f))
                TopicItemButton(
                    expandItem = expandedItemTopic,
                    onClick = {
                        expandedItemTopic = !expandedItemTopic
                    }
                )
            }
            if (expandedItemTopic) {
                Text(
                    modifier = modifier.padding(
                        top = 8.dp,
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 12.dp
                    ),
                    text = stringResource(id = topicData.descTopic),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun TopicItemButton(
    expandItem: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = if(expandItem) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = stringResource(id = R.string.btn_expand_item)
        )
    }
}