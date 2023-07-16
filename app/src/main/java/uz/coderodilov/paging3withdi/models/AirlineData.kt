package uz.coderodilov.paging3withdi.models

import com.google.gson.annotations.SerializedName

data class AirlineData(
    @SerializedName("data")
    val passenger: List<Passenger>,
    val totalPages: Int,
    val totalPassengers: Int
)