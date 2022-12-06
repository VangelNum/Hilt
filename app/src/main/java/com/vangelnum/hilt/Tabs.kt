package com.vangelnum.hilt

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val tabs = listOf(
        TabItem.Home,
        TabItem.Favourite,
    )
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            LeadingIconTab(
                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = "") },
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }

    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState, viewModel: MyViewModel) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> {
                MainScreen(viewModel = viewModel)
            }
            1 -> {
                FavouriteScreen(viewModel = viewModel, pagerState = pagerState)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = Color.Green
            )
        }
    }

}