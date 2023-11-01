package com.sagrd.apidocumentos.data.remote

import com.sagrd.apidocumentos.data.remote.dto.DocumentoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DocumentoApi {

    @GET("documentos")
    suspend fun getDocumentos():List<DocumentoDto>

}
