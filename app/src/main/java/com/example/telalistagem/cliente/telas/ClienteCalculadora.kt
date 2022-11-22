package com.example.telalistagem.cliente.telas

import android.graphics.fonts.FontFamily
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.Math.sqrt

class ClienteCalculadora :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraCliente()
        }
    }
}


        @Composable
        fun CalculadoraCliente() {
            val focusManager = LocalFocusManager.current

            var txtQuadril by remember {
                mutableStateOf("")
            }
            var txtAltura by remember {
                mutableStateOf("")
            }
            val resultCalc by remember {
                mutableStateOf("")
            }

            @Composable
            fun Calculadora() {
                val quad = txtQuadril.toDouble()
                val alt = txtAltura.toDouble()

                fun mToast(context: android.content.Context) {
                    Toast.makeText(
                        context,
                        "Preencha os campos corretamente para efetuar o cálculo!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                if (quad.equals("") || alt.equals("")) {
                    val mContext = LocalContext.current
                    mToast(mContext)
                } else {
                    val resultado = quad / (alt * sqrt(alt)) - 18
                    resultCalc == "$resultado"
                }
            }
            Column() {
                OutlinedTextField(
                    value = txtQuadril,
                    onValueChange = { txtQuadril = it },
                    label = { Text(text = "Circunferência do Quadril (cm)") },
                    singleLine = true,
                    maxLines = 1,
                    placeholder = { Text(text = "") },
                    modifier = Modifier.width(350.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                OutlinedTextField(
                    value = txtAltura,
                    onValueChange = { txtAltura = it },
                    label = { Text(text = "Altura (m)") },
                    singleLine = true,
                    maxLines = 1,
                    placeholder = { Text(text = "") },
                    modifier = Modifier.width(350.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
            }
        }

