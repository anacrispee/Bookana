package com.example.data_remote.utils

import com.example.data_remote.model.GenericResponse
import org.koin.core.component.KoinComponent

class RequestWrapperImpl : RequestWrapper, KoinComponent {

    override suspend fun <T> wrapperGenericResponse(
        call: suspend () -> GenericResponse<T>
    ): T {
        val result = wrapper(call = call)
        return getSuccessResult(result)
    }

    override suspend fun <D> wrapper(retryCount: Int, call: suspend () -> D): D {
        return try {
            call().also { result ->
                if (result is GenericResponse<*>) {
                    getSuccessResult(result)
                }
            }
        } catch (exception: Exception) {
            throw exception
        }
    }

    private fun <T> getSuccessResult(result: GenericResponse<T>): T {
        return when (result.result) {
            null -> throw NullPointerException()
            else -> result.result
        }
    }
}