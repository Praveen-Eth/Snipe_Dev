package com.augx_universe.snipedev.composeViews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.augx_universe.snipedev.composeViews.ui.theme.SnipeDevTheme
import com.augx_universe.snipedev.entities.PollItems
import com.augx_universe.snipedev.entities.PollOption


val pollGreen = Color(0xDA38F167)
@Composable
fun PollOptionItem(pollOption: PollOption,onItemClick: () -> Unit){
    var selected by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(pollOption.percentage)
            .height(35.dp)
            .clickable {
                selected = !selected
                onItemClick()
            }
            .background(if (selected) pollGreen else Color.Gray)
            .animateContentSize()

    ){
        Text( text = pollOption.pollName,
            modifier = Modifier.align(Alignment.CenterStart)
        )

    }

}

@Composable
fun PollScreen(PollOptions: List<PollOption>){
    Column {
        PollOptions.forEach{
            option ->
            PollOptionItem(pollOption = option){

            }

    }
}




}
