package com.sagrd.apidocumentos.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "Documentos")
data class DocumentoDto(
    @PrimaryKey
    @Json(name = "Numero")
    val numero : Int? = null,
    @Json(name = "Fecha")
    val fecha : String,
    @Json(name = "Rnc")
    val rnc : String,
    @Json(name = "Ncf")
    val ncf : String,
    @Json(name = "NombreCliente")
    val nombreCliente: String,
    @Json(name = "Monto")
    val monto : Float
)