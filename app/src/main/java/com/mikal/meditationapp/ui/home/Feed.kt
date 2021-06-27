import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

//package com.mikal.meditationapp.ui.home
//
//import com.mikal.meditationapp.ui.theme.MeditationTheme
//import android.content.res.Configuration
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.google.accompanist.insets.statusBarsHeight
//
@Composable
fun Feed(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
}
//
//@Composable
//private fun Feed(
//    snackCollections: List<SnackCollection>,
//    filters: List<Filter>,
//    onSnackClick: (Long) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    JetsnackSurface(modifier = modifier.fillMaxSize()) {
//        Box {
//            SnackCollectionList(snackCollections, filters, onSnackClick)
//            DestinationBar()
//        }
//    }
//}
//
//@Composable
//private fun SnackCollectionList(
//    snackCollections: List<SnackCollection>,
//    filters: List<Filter>,
//    onSnackClick: (Long) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    LazyColumn(modifier) {
//        item {
//            Spacer(Modifier.statusBarsHeight(additional = 56.dp))
//            FilterBar(filters)
//        }
//        itemsIndexed(snackCollections) { index, snackCollection ->
//            if (index > 0) {
//                JetsnackDivider(thickness = 2.dp)
//            }
//            SnackCollection(
//                snackCollection = snackCollection,
//                onSnackClick = onSnackClick,
//                index = index
//            )
//        }
//    }
//}
//
//@Preview("default")
//@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Preview("large font", fontScale = 2f)
//@Composable
//fun HomePreview() {
//    MeditationTheme {
//        Feed(onSnackClick = { })
//    }
//}
