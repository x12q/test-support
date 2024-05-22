package com.x12q.test_support

fun<T> T.leadTo(result:(T)->Unit){
    result(this)
}
