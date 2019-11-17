package net.emteeware.emteeselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            Selectee("Dexter - Season 8"),
            Selectee("Riverdale - Season 2"))
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        rvSelecteeList.layoutManager = layoutManager
        rvSelecteeList.adapter = SelecteeAdapter(this, shows)
    }
}
