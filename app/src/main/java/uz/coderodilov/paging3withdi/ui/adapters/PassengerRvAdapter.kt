package uz.coderodilov.paging3withdi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.coderodilov.paging3withdi.databinding.PassengerItemBinding
import uz.coderodilov.paging3withdi.models.Passenger

/* 
* Created by Coder Odilov on 16/07/2023
*/

class PassengerRvAdapter : PagingDataAdapter<Passenger, PassengerRvAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val binding: PassengerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(passenger: Passenger) {
            binding.tvPassengerName.text = passenger.name
            binding.tvAirlineName.text = passenger.airline[0].name
            binding.tvCountry.text = passenger.airline[0].country
            binding.tvWebSite.text = passenger.airline[0].website
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Passenger>() {
            override fun areItemsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Passenger, newItem: Passenger): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val passenger = getItem(position)
        passenger?.let {
            holder.onBind(passenger)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = PassengerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

}