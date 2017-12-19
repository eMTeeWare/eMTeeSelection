package net.emteeware.emteeselection

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_series -> {
                message.setText(R.string.title_series)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_people -> {
                message.setText(R.string.title_people)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_selections -> {
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
