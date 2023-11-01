package com.sagrd.apidocumentos.ui.documentos

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.apidocumentos.data.repository.DocumentoRepository
import com.sagrd.clientesremoto.util.DocumentoListState
import com.sagrd.clientesremoto.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DocumentosViewModel @Inject constructor(
    private val documentosRepository : DocumentoRepository
) : ViewModel() {

    private var _state = mutableStateOf(DocumentoListState())
    val state: State<DocumentoListState> = _state
    init {
        Cargar()
    }
    fun Cargar(){
        documentosRepository.getDocumentos().onEach{ result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = DocumentoListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = DocumentoListState(Documentos = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = DocumentoListState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }
}