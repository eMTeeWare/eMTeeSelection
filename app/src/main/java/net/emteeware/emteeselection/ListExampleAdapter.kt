package net.emteeware.emteeselection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Merlin Thomas on 19.12.2017.
 * www.emteeware.net
 */
class ListExampleAdapter(val contexts: Context, val array: Array<String>)
    : ArrayAdapter<String>(contexts, android.R.layout.simple_list_item_1, array) {
    companion object {
        class Holder {
            var textView: TextView? = null
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: Holder;
        if (convertView == null) {
            val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            holder = Holder()
            holder.textView = view.findViewById(android.R.id.text1)
            holder.textView?.text = array[position]
            view.tag = holder
            return view;
        } else {
            holder = convertView.tag as Holder
            holder.textView?.text=array[position]
            return convertView
        }
    }


}