package com.ukrdroiddev.data.utils

import com.ukrdroiddev.utils.NetworkError
import retrofit2.HttpException
import java.io.IOException

private const val UNAUTHORIZED_CODE = 401
private const val FORBIDDEN_CODE = 403
private const val NOT_FOUND_CODE = 404
private const val SERVER_ERROR_CODE = 500
private const val BAD_REQUEST_CODE = 400

suspend fun <R>wrapWithExceptions(block: suspend () -> R): com.ukrdroiddev.utils.Result<R, NetworkError>{
    return try {
        com.ukrdroiddev.utils. Result.Success(block())
    } catch (e: HttpException) {
        com.ukrdroiddev.utils.Result.Error(e.parseHttpException())
    } catch (e:IOException){
        com.ukrdroiddev.utils.Result.Error(NetworkError.NO_INTERNET)
    } catch (e:Exception){
        com.ukrdroiddev.utils.Result.Error(NetworkError.UNKNOWN)
    }
}


private fun HttpException.parseHttpException(): NetworkError {
    return when(this.code()){
        NOT_FOUND_CODE -> NetworkError.URL_NOT_FOUND
        FORBIDDEN_CODE -> NetworkError.FORBIDDEN
        UNAUTHORIZED_CODE -> NetworkError.UNAUTHORIZED
        SERVER_ERROR_CODE -> NetworkError.SERVER_ERROR
        BAD_REQUEST_CODE->  NetworkError.BAD_REQUEST
        else -> NetworkError.UNKNOWN
    }
}