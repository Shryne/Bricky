package com.shryne.bricky

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kong.unirest.GenericType
import kong.unirest.Unirest
import java.text.DateFormat

fun setupUnirest() {
    val mapper = ObjectMapper().apply {
        dateFormat = DateFormat.getDateInstance()
        registerModule(KotlinModule())
        enable(SerializationFeature.INDENT_OUTPUT)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    Unirest.config().objectMapper = object : kong.unirest.ObjectMapper {
        override fun <T> readValue(value: String, valueType: Class<T>): T {
            return mapper.readValue(value, valueType)
        }

        override fun <T> readValue(
            value: String,
            genericType: GenericType<T>
        ): T {
            return mapper.readValue(
                value,
                mapper.constructType(genericType.type)
            )
        }

        override fun writeValue(value: Any): String =
            mapper.writeValueAsString(value)
    }
}