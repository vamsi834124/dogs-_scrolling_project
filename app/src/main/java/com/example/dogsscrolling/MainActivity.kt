package com.example.dogsscrolling

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dogsscrolling.ui.theme.DogsScrollingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           Box(modifier = Modifier

               .fillMaxSize()
                ){
            Column() {
                dogSymbol(modifier = Modifier.padding(10.dp))
                App(imageAndTextList = getdata(), modifier =Modifier )




              }

            }


        }
    }
    data class ImageAndText(val dogimage:Int,val dogname:Int,val dogage:Int){

    }
    fun getdata():List<ImageAndText>{
        return listOf(ImageAndText(dogimage = R.drawable.dog__1,  dogname=R.string.dn1, dogage = 2),
                      ImageAndText(dogimage = R.drawable.dog_2,  dogname=R.string.dn2, dogage = 16),
                      ImageAndText(dogimage = R.drawable.dog_3, dogname=R.string.dn3, dogage = 2),
                      ImageAndText(dogimage = R.drawable.dog_4, dogname=R.string.dn4, dogage = 8),
                      ImageAndText(dogimage = R.drawable.dog_5, dogname=R.string.dn5, dogage = 8),
                      ImageAndText(dogimage = R.drawable.dog_6, dogname=R.string.dn6, dogage = 14),
                      ImageAndText(dogimage = R.drawable.dog_7, dogname=R.string.dn7, dogage = 2),
                      ImageAndText(dogimage = R.drawable.dog_8, dogname=R.string.dn8, dogage = 7),
                      ImageAndText(dogimage = R.drawable.dog_9, dogname=R.string.dn9, dogage = 4),
                      ImageAndText(dogimage = R.drawable.dog_10,dogname=R.string.dn10, dogage = 10)
        )
    }


    @Composable
    fun App( imageAndTextList:List<ImageAndText>,modifier: Modifier) {
        Scaffold(modifier = modifier,
            topBar = {

            },

         content = { it ->
            LazyColumn(contentPadding = it) {
                items(imageAndTextList){
                    WoofItem(modifier = Modifier, imageAndText = it)

                }

            }

        })

    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun dogSymbol(modifier: Modifier) {
        CenterAlignedTopAppBar(modifier = modifier,
            title = {

                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.paw_icon_260nw_404052379),
                        modifier = Modifier.size(64.dp), contentDescription = ""
                    )
                    Text(text = "WOOF")

                }
            }
        )

    }

    @Composable
    fun WoofItem(modifier: Modifier,imageAndText: ImageAndText) {
        Card(
            modifier = modifier

                .padding(10.dp),
            RoundedCornerShape(0.dp, 20.dp, 0.dp, 20.dp)
        ) {
            Row(
                modifier = Modifier.padding(10.dp)
                    .wrapContentHeight()

            ) {

                Image(
                    painter = painterResource(id =imageAndText.dogimage),
                    modifier = modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(64.dp)),

                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(10.dp))
                TitleAndAge(dogname = imageAndText.dogname, dogage = imageAndText.dogage)

            }
        }


    }

    @Composable
    fun TitleAndAge(dogname: Int,dogage: Int) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                Text(text = stringResource(id = dogname))
                Text(text = stringResource(id = R.string.yearsold,dogage))
            }

        }


    }
}



