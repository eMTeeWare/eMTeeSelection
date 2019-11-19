package net.emteeware.emteeselection

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Merlin Thomas on 19.12.2017.
 * www.emteeware.net
 */
class SelecteeAdapter(private val context: MainActivity, private val selecteeList: ArrayList<Selectee>)
    : RecyclerView.Adapter<SelecteeAdapter.ViewHolder>() {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.layout,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return selecteeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.selecteeName.text = selecteeList[position].toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(context, (selecteeList[position]).toString().plus(" selected "), Toast.LENGTH_LONG).show()
            selecteeList[position].selected = true
            this.notifyItemChanged(position)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val selecteeName: TextView = view.findViewById(R.id.tvSelecteeName)

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
                object : ItemDetailsLookup.ItemDetails<Long>() {
                    override fun getPosition(): Int = adapterPosition
                    override fun getSelectionKey(): Long? = itemId
                }
    }
}