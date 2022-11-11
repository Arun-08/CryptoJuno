package com.arun.cryptojuno.utils

data class AppResource<T>(var status : Status,var data : T?){
    companion object{
        fun <T> loading() : AppResource<T> = AppResource(Status.LOADING,null)
        fun <T> success(data : T) : AppResource<T> = AppResource(Status.SUCCESS,data)
        fun <T> failed() : AppResource<T> = AppResource(Status.FAILURE,null)
    }
}




enum class Status{
    LOADING,
    SUCCESS,
    FAILURE
}
