package com.example.basicweatherapp.weatherfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basicweatherapp.databinding.ListViewItemBinding
import com.example.basicweatherapp.domain.DayWeather

class WeatherRecyclerViewAdapter :
        ListAdapter<DayWeather, WeatherRecyclerViewAdapter.ViewHolder>(AsteroidDiffCallBack) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dayWeather = getItem(position)
        holder.bind(dayWeather)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return  ViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class ViewHolder constructor(private var viewDataBinding: ListViewItemBinding):
            RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(dayWeather: DayWeather) {
            viewDataBinding.apply{
                weather = dayWeather
                executePendingBindings()
            }
        }
    }

    companion object AsteroidDiffCallBack : DiffUtil.ItemCallback<DayWeather>() {
        override fun areItemsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DayWeather, newItem: DayWeather): Boolean {
            return oldItem.tempMin  == newItem.tempMin
        }
    }
}