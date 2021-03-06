package app.v.verbundstudium.com.verbundstudiumapp.mensa

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.v.verbundstudium.com.verbundstudiumapp.R
import kotlinx.android.synthetic.main.dish_list_item.view.*
import java.text.NumberFormat

class GerichtAdapter(private var gerichte: MutableList<Gericht>) : RecyclerView.Adapter<GerichtAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GerichtAdapter.ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.dish_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gerichte.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(gerichte[position])
    }

    fun refreshDishes(dishes: List<Gericht>) {
        this.gerichte.clear()
        this.gerichte.addAll(dishes)
        notifyDataSetChanged()
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(dish: Gericht) {
            with(itemView) {
                menu_name.text = dish.name
                description.text = dish.description
                students_price_value.text = NumberFormat.getCurrencyInstance().format(dish.priceStudent)
                guest_price_value.text = NumberFormat.getCurrencyInstance().format(dish.priceGuest)
            }
        }
    }


}