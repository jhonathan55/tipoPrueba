package com.example.tipoprueba.models

data class ContactResponse (
    val results: List<Result>
)

data class Result (
    val gender: Gender,
    val name: Name,
    val location: Location,
    val email: String,
    val phone: String,
    val cell: String,
    val picture: Picture,
    val nat: String
)

enum class Gender {
    Female,
    Male
}

data class Location (
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Postcode,
    val coordinates: Coordinates,
    val timezone: Timezone
)

data class Coordinates (
    val latitude: String,
    val longitude: String
)

sealed class Postcode {
    class IntegerValue(val value: Long)  : Postcode()
    class StringValue(val value: String) : Postcode()
}

data class Street (
    val number: Long,
    val name: String
)

data class Timezone (
    val offset: String,
    val description: String
)

data class Name (
    val title: String,
    val first: String,
    val last: String
)

data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)
