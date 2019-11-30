package net.emteeware.emteeselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Merlin Thomas on 19.12.2017.
 * www.emteeware.net
 */
class SelecteeAdapter(private val context: MainActivity, private val selecteeList: ArrayList<Selectee>)
    : RecyclerView.Adapter<SelecteeAdapter.ViewHolder>() {

    var tracker: SelectionTracker<Long>? = null

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
        val selectee = selecteeList[position]
        tracker?.let {
            holder.bind(selectee)
            holder.itemView.setOnClickListener {
                selectee.selected = !(selectee.selected)
                this.notifyItemChanged(position)
                val selectionCount = selecteeList.filter { selectee -> selectee.selected }.count()
                context.title = "You selected $selectionCount item(s)."
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val selecteeName: TextView = view.findViewById(R.id.tvSelecteeName)

        fun bind(value: Selectee) {
            selecteeName.text = value.toString()
            itemView.isActivated = value.selected
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
                object : ItemDetailsLookup.ItemDetails<Long>() {
                    override fun getPosition(): Int = adapterPosition
                    override fun getSelectionKey(): Long? = itemId
                }
    }
}