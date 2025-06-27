package com.example.thuc_hanh_4.view.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.example.thuc_hanh_4.R
import com.example.thuc_hanh_4.model.OnboardingItem
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import com.example.thuc_hanh_4.viewmodel.OnboardingViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPagerScreen(
    viewModel: OnboardingViewModel = viewModel(),
    onDone: () -> Unit
) {
    val pages = listOf(
        // Có thể tách ra file riêng nếu dài
        OnboardingItem(R.drawable.task_management, "Easy Time Management", "..."),
        OnboardingItem(R.drawable.increase_efficiency, "Increase Work Effectiveness", "..."),
        OnboardingItem(R.drawable.reminder_notification, "Reminder Notification", "...")
    )

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    // Cập nhật page vào ViewModel
    LaunchedEffect(pagerState.currentPage) {
        viewModel.setPage(pagerState.currentPage)
    }

    val currentPage by viewModel.currentPage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header: Dots + Skip
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DotsIndicator(totalDots = pages.size, selectedIndex = currentPage)

            if (currentPage != pages.lastIndex) {
                Text(
                    text = "Skip",
                    color = Color(0xFF006EE9),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .clickable { onDone() }
                        .padding(8.dp)
                )
            } else {
                Spacer(modifier = Modifier.width(48.dp))
            }
        }

        // Pager nội dung
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { index ->
            val page = pages[index]
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(page.imageResId),
                    contentDescription = null,
                    modifier = Modifier.size(240.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = page.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = page.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }

        // Footer
        Button(
            onClick = {
                if (currentPage == pages.lastIndex) {
                    onDone()
                } else {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(currentPage + 1)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006EE9))
        ) {
            Text(
                text = if (currentPage == pages.lastIndex) "Get Started" else "Next",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

