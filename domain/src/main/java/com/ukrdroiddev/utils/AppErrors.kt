package com.ukrdroiddev.utils

enum class NetworkError : Error {
    NO_INTERNET,
    SERVER_ERROR,
    URL_NOT_FOUND,
    FORBIDDEN,
    UNAUTHORIZED,
    BAD_REQUEST,
    UNKNOWN
}