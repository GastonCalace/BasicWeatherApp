package com.example.basicweatherapp.weatherfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.basicweatherapp.databinding.ListViewItemBinding
import com.example.basicweatherapp.domain.DayWeather


//class WeatherRecyclerViewAdapter(private val dataSet: List<DayWeather>) :
//    RecyclerView.Adapter<WeatherRecyclerViewAdapter.ViewHolder>() {
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    class ViewHolder(private var binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(dayWeather: DayWeather){
//            binding.apply {
//                weather = dayWeather
//                executePendingBindings()
//            }
//        }
//
//    }
//
//    // Create new views (invoked by the layout manager)
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        // Create a new view, which defines the UI of the list item
//        return ViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(viewGroup.context)))
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.bind(dataSet[position])
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    override fun getItemCount() = dataSet.size
//
//}

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