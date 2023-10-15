package bird.app.opsc7312poepart2

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BirdAdapter : ListAdapter<Bird, BirdAdapter. BirdAdapter>(BirdViewHolder()){
    class  BirdAdapter (view : View): RecyclerView.ViewHolder(view) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  BirdAdapter
    {
        val inflater = LayoutInflater.from(parent.context)
        return bird.app.opsc7312poepart2.BirdAdapter. BirdAdapter(inflater.inflate(R.layout.bird_layout, parent , false))
    }
    override fun onBindViewHolder(holder:  BirdAdapter, position: Int)
    {
        var bird = getItem(position)
        val context = holder.itemView.context
        val layoutInflater = LayoutInflater.from(context)
        holder.itemView.findViewById<TextView>(R.id.text1).text =  "Name: "+ bird.comName
        holder.itemView.findViewById<TextView>(R.id.text2).text =  "Sci Name: "+ bird.sciName
        holder.itemView.findViewById<TextView>(R.id.text3).text =  "Family Name: "+bird.familyComName

        holder.itemView.findViewById<Button>(R.id.buttonBird).setOnClickListener{
            val popup = PopupWindow(context)
            popup.setFocusable(true);
            popup.update();
            val view = layoutInflater.inflate(R.layout.saveobservation_layout, null)
            popup.contentView = view

            popup.showAtLocation( view, Gravity.CENTER , 0 , 0)
        }
    }
    class BirdViewHolder : DiffUtil.ItemCallback<Bird>() {
        override fun areContentsTheSame(oldItem:Bird, newItem: Bird): Boolean
        {
            return areItemsTheSame(oldItem,newItem)
        }

        override fun areItemsTheSame(oldItem: Bird, newItem: Bird): Boolean
        {
            return oldItem.comName == newItem.comName
        }
    }
}