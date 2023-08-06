package com.example.loginscreen.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.R
import com.example.loginscreen.app.data.NavigationItem
import com.example.loginscreen.ui.theme.BgColor
import com.example.loginscreen.ui.theme.GrayColor
import com.example.loginscreen.ui.theme.Primary
import com.example.loginscreen.ui.theme.Seconday
import com.example.loginscreen.ui.theme.TextColor
import com.example.loginscreen.ui.theme.componentShapes
import kotlinx.coroutines.launch

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ), color = TextColor, textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(), style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        ), color = TextColor, textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(
    labelValue: String,
    painter: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {
    var textValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = textValue,
        onValueChange = {
            textValue = it
            onTextChanged(it)
        },
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Primary,
            focusedBorderColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(
                painter = painter, contentDescription = "icon profile"
            )
        },
        singleLine = true,
        maxLines = 1,

        isError = !errorStatus

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelValue: String,
    painter: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    val localFocusManger = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = password,
        onValueChange = {
            password = it
            onTextChanged(it)
        },
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Primary,
            focusedBorderColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManger.clearFocus()
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(
                painter = painter, contentDescription = "icon profile"
            )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                Icons.Filled.Visibility
            } else Icons.Filled.VisibilityOff

            var descrition = if (passwordVisible) {
                stringResource(id = R.string.hide_password)
            } else stringResource(id = R.string.show_password)
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = descrition)

            }

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus

    )

}


@Composable
fun CheckboxComponent(
    value: String, onTextSelected: (String) -> Unit, onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
            onCheckedChange.invoke(it)
        })
        ClickbleTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickbleTextComponent(
    value: String,
    onTextSelected: (String) -> Unit,

    ) {
    val initialText = "By continuing you accpet our "
    val privacyPolicyText = "Privacy Policy "
    val andText = " and "
    val termsAndConditionsText = " Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    val context = LocalContext.current
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Toast.makeText(context, "${span.item}", Toast.LENGTH_LONG).show()

            if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
                onTextSelected(span.item)
            }
        }
    })
}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = {
            onButtonClicked.invoke()
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Seconday, Primary)),
                    shape = RoundedCornerShape(50.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Text(
                text = value, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = GrayColor, thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = GrayColor, thickness = 1.dp
        )
    }
}

@Composable
fun ClickbleLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (tryingToLogin) "Already have an account ? " else "Don't have an accont yet?"
    val loginText = if (tryingToLogin) " Login" else " Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }

    }
    val context = LocalContext.current
    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp), style = TextStyle(
        fontSize = 19.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center
    ), text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Toast.makeText(context, "${span.item}", Toast.LENGTH_LONG).show()

            if (span.item == loginText) {
                onTextSelected(span.item)
            }
        }
    })
}

@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ),
        color = GrayColor,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Apptoolbar(
    toolbarTitle: String,
    logoutButtonClicked: () -> Unit,
    drawertButtonClicked: () -> Unit,
) {
    TopAppBar(title = {
        Text(
            text = toolbarTitle, color = Color.White
        )
    }, navigationIcon = {

        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = stringResource(R.string.menu),
            tint = Color.White,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    drawertButtonClicked.invoke()
                },

            )
    }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Primary), actions = {

        IconButton(onClick = {
            logoutButtonClicked()
            //  logoutButtonClicked.invoke()
        }) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = stringResource(R.string.logout)
            )
        }

    }

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer(navigationItemsList: List<NavigationItem>, logoutButtonClicked: () -> Unit) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember {
        mutableStateOf(navigationItemsList[0])
    }

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Header",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(15.dp))
            navigationItemsList.forEach { item ->
                NavigationDrawerItem(modifier = Modifier.padding(8.dp), label = {
                    Text(text = item.title)
                }, selected = selectedItem.value == item, icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                }, onClick = {
                    scope.launch {
                        selectedItem.value = item
                        drawerState.close()
                    }
                })
            }
        }
    }, drawerState = drawerState, content = {
        Scaffold(
            topBar = {
                Apptoolbar(
                    toolbarTitle = stringResource(id = R.string.home), logoutButtonClicked = {
                        logoutButtonClicked
                    },
                    drawertButtonClicked = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },

            ) { padding ->
            Box(modifier = Modifier.padding(paddingValues = padding))
        }

    })

}
