package com.jyldyzferr.makeitsotodoapp.common.composable

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class ToolbarComposable {
}

@Composable
fun BasicToolbar(
    @StringRes title: Int
) {
    TopAppBar(title = { Text(stringResource(title)) }, backgroundColor = toolbarColor())
}

@Composable
fun ActionToolbar(
    modifier: Modifier,
    @StringRes title: Int,
    @DrawableRes primaryActionIcon: Int,
    primaryAction: () -> Unit,
    @DrawableRes secondaryActionIcon: Int? = null,
    secondaryAction: (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(stringResource(title)) },
        backgroundColor = toolbarColor(),
        actions = {
            Box(modifier) {
                Row(
                    modifier = Modifier.wrapContentSize()
                ) {
                    IconButton(onClick = primaryAction) {
                        Icon(
                            painter = painterResource(primaryActionIcon),
                            contentDescription = "Primary Action"
                        )
                    }
                    if (secondaryAction != null && secondaryActionIcon != null) {
                        Icon(
                            painter = painterResource(secondaryActionIcon),
                            contentDescription = "Secondary Action"
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun toolbarColor(darkTheme: Boolean = isSystemInDarkTheme()): Color {
    return if (darkTheme) MaterialTheme.colors.secondary else MaterialTheme.colors.primaryVariant
}