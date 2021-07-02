package com.mikal.meditationapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.coil.rememberCoilPainter
import com.mikal.meditationapp.models.Profile
import com.mikal.meditationapp.ui.theme.MeditationTheme
import com.mikal.meditationapp.R


@Composable
fun ProfileView(
    profileData: Profile,
    onClick: (Long) -> Unit,
    left: Float,
    gradient: List<Color>,
    gradientWidth: Float,
    scroll: Int,
    modifier: Modifier = Modifier
) {
    meditationCard(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onClick(profileData.id) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(280.dp)
                    .fillMaxWidth()
            )
            {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(220.dp)
                        .fillMaxWidth()
                        .offsetGradientBackground(gradient, gradientWidth, gradientOffset)
                )
                ProfileImage(
                    imageUrl = profileData.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(135.dp)
                        .align(Alignment.BottomCenter)
                )
                Box(modifier = Modifier
                    .padding(top = 55.dp)
                    .align(Alignment.TopCenter)){
                    Column(
                        modifier
                            .align(Alignment.Center)
                            .padding(start = 40.dp)) {
                        Text(
                            text = profileData.name,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1,
                            color = MeditationTheme.colors.textSecondary,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = profileData.role,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textSecondary,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = profileData.location,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textSecondary,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }

                }
            }
            Column(modifier.align(Alignment.CenterHorizontally)) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = profileData.name,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Row(
                Modifier
                    .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally)) {
                meditationCard(
                    modifier = modifier
                        .width(140.dp)
                        .height(175.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                ){
                    ConstraintLayout(modifier = Modifier.align(Alignment.CenterVertically)) {
                        Column(
                            Modifier
                                .padding(25.dp)) {
                            Text(
                                text = profileData.followers,
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.h6,
                                color = MeditationTheme.colors.textPrimary,
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Followers",
                                maxLines = 1,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.body1,
                                color = MeditationTheme.colors.textSecondary,
                            )
                        }
                    }

                }

                meditationCard(
                    modifier = modifier
                        .width(140.dp)
                        .height(175.dp)
                        .padding(8.dp)
                ){
                    Column(
                        Modifier
                            .padding(25.dp)
                            .align(Alignment.CenterVertically)) {
                        Text(
                            text = profileData.following,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h6,
                            color = MeditationTheme.colors.textPrimary,
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Following",
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textSecondary,
                        )
                    }

                }

                meditationCard(
                    modifier = modifier
                        .width(140.dp)
                        .height(175.dp)
                        .padding(8.dp)
                ){
                    Column(
                        Modifier
                            .padding(25.dp)
                            .align(Alignment.CenterVertically)) {
                        Text(
                            text = profileData.totalTrainees,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h6,
                            color = MeditationTheme.colors.textPrimary,
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Trainees",
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textSecondary,
                        )
                    }
                }


            }

        }
    }
}

@Composable
fun ProfileImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    MeditationSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = androidx.compose.foundation.shape.CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = rememberCoilPainter(
                request = imageUrl,
                previewPlaceholder = R.drawable.placeholder,
            ),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun BottomProfileDesign(
    profileData: Profile
){

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "About",
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        meditationDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = profileData.aboutDescription,
            textAlign = TextAlign.Start,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MeditationTheme.colors.textSecondary,
        )
        Spacer(modifier = Modifier.height(35.dp))
        MeditationButton(
            onClick = { /* todo */ },
            modifier = Modifier.size(
                width = 130.dp,
                height = 45.dp
            ).align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.follow),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
        }
    }


}