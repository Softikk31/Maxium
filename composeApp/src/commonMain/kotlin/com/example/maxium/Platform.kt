package com.example.maxium

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform