package uz.coderodilov.paging3withdi.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import uz.coderodilov.paging3withdi.api.ApiService
import uz.coderodilov.paging3withdi.data.PassengerPagingSource
import javax.inject.Inject

/* 
* Created by Coder Odilov on 16/07/2023
*/

class MainRepository @Inject constructor(private val apiService: ApiService) {
    fun getPassengers()= Pager(config = PagingConfig(pageSize = 10), pagingSourceFactory = {
        PassengerPagingSource(apiService)
    }).liveData

}