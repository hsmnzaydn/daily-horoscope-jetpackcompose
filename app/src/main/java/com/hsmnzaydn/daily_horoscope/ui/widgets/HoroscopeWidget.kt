package com.hsmnzaydn.daily_horoscope.ui.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope
import com.hsmnzaydn.daily_horoscope.ui.theme.Typography
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun HoroscopeWidget(item: Horoscope,click:() -> Unit) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .padding(8.dp), onClick = {
            click()
        }
    ) {
        ConstraintLayout {

            val (image, text) = createRefs()

            GlideImage(
                imageModel = item.imagePath,
                contentDescription = item.title,
                modifier =
                Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .alpha(0.8f)
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
            Text(
                text = item.title,
                Modifier
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                style = Typography.body1,
                textAlign = TextAlign.Center

            )


        }


    }
}


