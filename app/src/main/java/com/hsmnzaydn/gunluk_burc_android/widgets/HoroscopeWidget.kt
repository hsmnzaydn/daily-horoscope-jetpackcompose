package com.hsmnzaydn.gunluk_burc_android.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hsmnzaydn.gunluk_burc_android.data.HoroscopeResponse
import com.hsmnzaydn.gunluk_burc_android.ui.theme.Typography
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HoroscopeWidget(item: HoroscopeResponse) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .padding(8.dp)
    ) {
        ConstraintLayout {

            val (image,text) = createRefs()
            item.imagePath = "https://"+item.imagePath

            GlideImage(
                imageModel = item.imagePath,
                contentDescription = item.horoscopeName,
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
            Text(text = item.horoscopeName,
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

@Preview(showBackground = true)
@Composable
fun previewHoroscopeListView() {
    HoroscopeWidget(
        item = HoroscopeResponse(
            "",
            "Koç burcuburcuburcuburcuburcuburcu",
            "https://icdn.gunlukburc.net/3/19/4/20/2400/boga-burcu.jpg"
        )
    )
}
