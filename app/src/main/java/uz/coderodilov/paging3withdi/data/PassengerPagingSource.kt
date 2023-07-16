package uz.coderodilov.paging3withdi.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import uz.coderodilov.paging3withdi.api.ApiService
import uz.coderodilov.paging3withdi.models.Passenger
import javax.inject.Inject

/* 
* Created by Coder Odilov on 16/07/2023
*/

class PassengerPagingSource @Inject constructor(private val apiService: ApiService): PagingSource<Int, Passenger>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Passenger> {
        return try {
            val currentPageIndex = params.key ?: 1
            val response = apiService.getAirLineData(currentPageIndex, 20)
            Log.d("TTT", response.passenger.toString())
            LoadResult.Page(
                data = response.passenger,
                prevKey = null,
                nextKey = if (currentPageIndex == response.totalPages) null else currentPageIndex + 1
            )

        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Passenger>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.nextKey?.plus(1)
        }
    }

}
