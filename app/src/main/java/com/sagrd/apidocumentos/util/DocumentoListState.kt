package com.sagrd.clientesremoto.util

import com.sagrd.apidocumentos.data.remote.dto.DocumentoDto

data class DocumentoListState(
    val isLoading: Boolean = false,
    val Documentos: List<DocumentoDto> = emptyList(),
    val error: String = ""
)