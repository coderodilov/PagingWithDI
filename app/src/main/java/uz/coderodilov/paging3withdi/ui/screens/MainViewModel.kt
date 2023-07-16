package uz.coderodilov.paging3withdi.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.coderodilov.paging3withdi.repository.MainRepository
import javax.inject.Inject

/* 
* Created by Coder Odilov on 16/07/2023
*/

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){
    val passengers  = repository.getPassengers()

}
