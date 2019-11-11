package net.emteeware.emteeselection

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_series -> {
                message.text = ""
                seriesList.visibility = View.VISIBLE
                val series = arrayOf("Marvel's Luke Cage - Season 2", "Marvel's Iron Fist - Season 2", "Dexter - Season 8", "Riverdale - Season 2")
                seriesList.adapter = ListExampleAdapter(this, series)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_people -> {
                seriesList.visibility = View.INVISIBLE
                message.setText(R.string.title_people)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_selections -> {
                seriesList.visibility = View.INVISIBLE
                message.setText(R.string.title_selections)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
