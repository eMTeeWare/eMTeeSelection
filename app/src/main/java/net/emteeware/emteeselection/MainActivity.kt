package net.emteeware.emteeselection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var tracker: SelectionTracker<Long>? = null

    private val shows = arrayListOf(
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"),
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"),
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"),
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"),
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"),
            Selectee("Marvel's Luke Cage - Season 2"),
            Selectee("Marvel's Iron Fist - Season 2"),
            Selectee("Riverdale - Season 2"))
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private val adapter = SelecteeAdapter(this, shows)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        rvSelecteeList.layoutManager = layoutManager
        rvSelecteeList.adapter = adapter

        tracker = SelectionTracker.Builder<Long>(
                "mySelection",
                rvSelecteeList,
                StableIdKeyProvider(rvSelecteeList),
                MyItemDetailsLookup(rvSelecteeList),
                StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
                SelectionPredicates.createSelectAnything()
        ).build()
        adapter.tracker = tracker
    }
}
