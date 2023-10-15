package bird.app.opsc7312poepart2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ObservationAdapter : ListAdapter<Observation, ObservationAdapter.ObservationAdapter>(ObservationViewHolder()){

    class  ObservationAdapter (view : View): RecyclerView.ViewHolder(view) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  ObservationAdapter
    {
        val inflater = LayoutInflater.from(parent.context)
        return bird.app.opsc7312poepart2.ObservationAdapter. ObservationAdapter(inflater.inflate(R.layout.observation_layout, parent , false))
    }
    override fun onBindViewHolder(holder:  ObservationAdapter, position: Int)
    {

        var observation = getItem(position)
        holder.itemView.findViewById<TextView>(R.id.text1).text =  observation.Name
        holder.itemView.findViewById<TextView>(R.id.text2).text =  observation.Location
        holder.itemView.findViewById<TextView>(R.id.text3).text =  observation.DateTime


    }
    class ObservationViewHolder : DiffUtil.ItemCallback<Observation>() {
        override fun areContentsTheSame(oldItem:Observation, newItem: Observation): Boolean
        {
            return areItemsTheSame(oldItem,newItem)
        }

        override fun areItemsTheSame(oldItem: Observation, newItem: Observation): Boolean
        {
            return oldItem.Name == newItem.Name
        }
    }
}
