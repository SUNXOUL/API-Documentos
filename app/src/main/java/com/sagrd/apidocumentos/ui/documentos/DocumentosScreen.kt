package com.sagrd.apidocumentos.ui.documentos

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentosScreen(
    viewModel: DocumentosViewModel = hiltViewModel(),
)
{


    Scaffold (
        topBar = { TopAppBar(title = { Text(text = "Documentos") },
            modifier = Modifier.shadow(8.dp),
            navigationIcon = {
                Icon(imageVector = Icons.Filled.AttachFile, contentDescription ="" )
            },
            actions = {
                IconButton(onClick = { viewModel.Cargar() }) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription ="" )
                }
            }
        )
        },
        content = ({
            Clientes(viewModel)
        }),
        bottomBar = {
            Row (horizontalArrangement = Arrangement.End, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()){

            }
        }
    )

}
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Clientes(
    viewModel: DocumentosViewModel
)
{
    val Documentos = viewModel.state.value.Documentos

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
    ) {
        items(Documentos){ documento ->

            Card(modifier = Modifier
                .padding(10.dp)
                .shadow(3.dp),
            ) {
                Box(modifier=Modifier.padding(16.dp))
                {
                    Column {
                        Column (horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxWidth())
                        {
                            Text(text = "${documento.nombreCliente}")
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Divider()
                        Column {
                            Row {
                                  Text(text = "Mumero:")
                                  Text(text = "${documento.numero}")
                              }
                            Row {
                                Text(text = "RNC:")
                                Text(text = "${documento.rnc}")
                            }
                            Row {
                                Text(text = "NCF:")
                                Text(text = "${documento.ncf}")
                            }
                            Row {
                                Text(text = "Monto:")
                                Text(text = "${documento.monto}")
                            }

                            }
                        }
                    }

                }

            }
        }
    }
