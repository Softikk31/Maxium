package com.example.maxium.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

object Config {
    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                subclass(WelcomeRoute::class, WelcomeRoute.serializer())
                subclass(LoginEmailRoute::class, LoginEmailRoute.serializer())
                subclass(EmailCodeRoute::class, EmailCodeRoute.serializer())
                subclass(LoginPasswordRoute::class, LoginPasswordRoute.serializer())
                subclass(PasswordCodeRoute::class, PasswordCodeRoute.serializer())
                subclass(ChatsRoute::class, ChatsRoute.serializer())
                subclass(ContactsRoute::class, ContactsRoute.serializer())
                subclass(ProfileRoute::class, ProfileRoute.serializer())
                subclass(ChatRoute::class, ChatRoute.serializer())
            }
        }
    }
}
