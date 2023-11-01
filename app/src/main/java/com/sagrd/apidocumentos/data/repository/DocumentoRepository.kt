package com.sagrd.apidocumentos.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.sagrd.apidocumentos.data.remote.DocumentoApi
import com.sagrd.apidocumentos.data.remote.dto.DocumentoDto
import com.sagrd.clientesremoto.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DocumentoRepository @Inject constructor(
    private val api: DocumentoApi
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getDocumentos (): Flow<Resource<List<DocumentoDto>?>> = flow {
        try {
            emit(Resource.Loading())

            val documentos = api.getDocumentos()

            emit(Resource.Success(documentos))
        } catch (e: HttpException) {

            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

}