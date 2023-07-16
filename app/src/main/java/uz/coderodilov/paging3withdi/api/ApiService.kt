package uz.coderodilov.paging3withdi.api

import retrofit2.http.GET
import retrofit2.http.Query
import uz.coderodilov.paging3withdi.models.AirlineData

/* 
* Created by Coder Odilov on 16/07/2023
*/

interface ApiService {
    @GET("v1/passenger")
    suspend fun getAirLineData(@Query("page") page:Int, @Query("size") size :Int) : AirlineData
}
