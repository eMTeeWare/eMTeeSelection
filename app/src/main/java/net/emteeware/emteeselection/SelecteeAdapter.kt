package net.emteeware.emteeselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout.view.*

/**
 * Created by Merlin Thomas on 19.12.2017.
 * www.emteeware.net
 */
class SelecteeAdapter(private val context: MainActivity, private val selecteeList: ArrayList<String>)
    : RecyclerView.Adapter<SelecteeAdapter.ViewHolder>() {
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
        holder.selecteeName.text = selecteeList[position]
        holder.itemView.setOnClickListener {
            Toast.makeText(context, (selecteeList[position]).plus(" selected "), Toast.LENGTH_LONG).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val selecteeName: TextView = view.tvSelecteeName
    }


}