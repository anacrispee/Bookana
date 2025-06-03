package com.example.data_remote.utils

import com.example.data_remote.model.GenericResponse

interface RequestWrapper {
    suspend fun <T> wrapperGenericResponse(
        call: suspend () -> GenericResponse<T>
    ): T

    suspend fun <D> wrapper(
        retryCount: Int = 0,
        call: suspend () -> D
    ): D
}