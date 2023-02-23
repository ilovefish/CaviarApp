package com.ilovefish.caviarapp.demo.ui.widget

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.ilovefish.caviarmvvm.ext.util.logd
import com.ilovefish.caviarapp.R

class BottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    var onItemSelectedListener: OnItemSelectedListener? = null

//    private val selectIndex by mutableStateOf<Int>(0)

    private var topOffset by mutableStateOf<Int>(27)

    private var tabs by mutableStateOf<List<TabItem>>(
        listOf(
            TabItem(
                "抢单",
                R.mipmap.home_qiangdan_nomal,
                R.mipmap.home_qiangdan,
                R.id.navigation_qiangdan,
                false,
            ),
            TabItem(
                "拍拍",
                R.mipmap.home_paipai_nomal,
                R.mipmap.home_paipai,
                R.id.navigation_paipai,
                false,
            ),
            TabItem(
                "",
                R.mipmap.home_paipai_bar_select,
                R.mipmap.home_paipai_bar_select,
                R.id.navigation_ditu,
                true,
            ),
            TabItem(
                "房域",
                R.mipmap.home_fangyu_nomal,
                R.mipmap.home_fangyu,
                R.id.navigation_fangyu,
                false,
            ),
            TabItem(
                "我的",
                R.mipmap.home_my,
                R.mipmap.home_my_select,
                R.id.navigation_wode,
                false,
            )
        )
    )


    @Composable
    override fun Content() {
        MaterialTheme {
            CallToActionButton()
        }
    }

    fun onTapfun(selectIndex: MutableState<Int>, index: Int, tabItem: TabItem): Unit {
        ("PaiPaiLog" + tabItem.name).logd()
        if (!tabItem.isTopOffset) {
            selectIndex.value = index
        }
        onItemSelectedListener?.onNavigationItemSelected(
            index,
            tabItem.navResId
        )
    }


    @Composable
    fun CallToActionButton(
    ) {
        val selectIndex = remember { mutableStateOf(0) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(top = topOffset.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color("#FFFFFF".toColorInt())),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                tabs.forEachIndexed { index, tabItem ->
                    Column(
                        modifier = if(tabItem.isTopOffset) Modifier
                            .weight(1.0f, true)
                            .padding(top = 5.dp)
                            .fillMaxWidth()
                            .wrapContentHeight() else Modifier
                            .weight(1.0f, true)
                            .padding(top = 5.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    // 点击事件
                                    onTap = {
                                        onTapfun(selectIndex, index, tabItem)
                                    })
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
//                        if (tabItem.isTopOffset)
//                            Layout(
//                                content = {
//                                    tabItem(
//                                        selectIndex = selectIndex,
//                                        index = index,
//                                        tabItem = tabItem,
//                                        funcp = {
//                                            selectIndex, index, tabItem -> onTapfun(selectIndex, index, tabItem)
//                                        },
//                                    )
//                                }
//                            ) { measurables, constraints ->
//                                val placeables = measurables.map { measurable ->
//                                    measurable.measure(constraints)
//                                }
//                                layout(constraints.maxWidth, constraints.maxHeight) {
//                                    var yPosition =
//                                        if (tabItem.isTopOffset) -topOffset.dp.roundToPx() else 0
//                                    placeables.forEach { placeable ->
//                                        placeable.placeRelative(
//                                            x = (constraints.maxWidth - placeable.width) / 2,
//                                            y = yPosition
//                                        )
//                                        yPosition += placeable.height
//                                    }
//                                }
//                            } else {

                        Image(
                            modifier = if (tabItem.isTopOffset) Modifier
                                .requiredWidth(65.dp)
                                .requiredHeight(65.dp)
                                .offset(y = -topOffset.dp)
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        // 点击事件
                                        onTap = {
                                            onTapfun(selectIndex, index, tabItem)
                                        })
                                } else Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .offset(y = 0.dp),
                            painter = if (selectIndex.value == index) painterResource(id = tabItem.selectResId) else painterResource(
                                id = tabItem.resId
                            ),
                            contentDescription = null
                        )
                        if (tabItem.name.isNotEmpty()) Text(tabItem.name)

//                        tabItem(
//                            selectIndex = selectIndex,
//                            index = index,
//                            tabItem = tabItem,
//                            funcp = { selectIndex, index, tabItem ->
//                                onTapfun(selectIndex, index, tabItem)
//                            }
//                        )
//                        }
                    }
                }
            }
        }
    }

    @Composable
    fun tabItem(
        selectIndex: MutableState<Int>,
        index: Int,
        tabItem: TabItem,
        funcp: (MutableState<Int>, Int, TabItem) -> Unit
    ) {
        Image(
            modifier = if (tabItem.isTopOffset) Modifier
                .requiredWidth(65.dp)
                .requiredHeight(65.dp)
                .offset(y = -topOffset.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        // 点击事件
                        onTap = {
                            onTapfun(selectIndex, index, tabItem)
                        })
                } else Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .offset(y = 0.dp),
            painter = if (selectIndex.value == index) painterResource(id = tabItem.selectResId) else painterResource(
                id = tabItem.resId
            ),
            contentDescription = null
        )
        if (tabItem.name.isNotEmpty()) Text(tabItem.name)
    }

}


data class TabItem(
    val name: String,
    val resId: Int,
    val selectResId: Int,
    val navResId: Int,
    val isTopOffset: Boolean
)

interface OnItemSelectedListener {
    fun onNavigationItemSelected(index: Int, navResId: Int): Unit
}
