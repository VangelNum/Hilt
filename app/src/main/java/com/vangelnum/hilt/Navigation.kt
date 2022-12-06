package com.vangelnum.hilt

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Navigation(viewModel: MyViewModel) {
    val pagerState = rememberPagerState(pageCount = 2)
    Column {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState, viewModel = viewModel)
    }
}