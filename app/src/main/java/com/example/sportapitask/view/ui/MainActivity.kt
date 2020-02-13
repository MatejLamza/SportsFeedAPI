package com.example.sportapitask.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.sportapitask.R
import com.example.sportapitask.view.ui.fragments.FragmentAthlete
import com.example.sportapitask.view.ui.fragments.FragmentFeed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout:DrawerLayout
    private var fragmentAthlete = FragmentAthlete()
    private var fragmentFeed = FragmentFeed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDrawerLayout = findViewById(R.id.drawer_home)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        handleMenuClicks()
        goToFragment(fragmentFeed)
    }

    private fun handleMenuClicks(){
        nav_view.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers()
            when(menuItem.itemId){
                R.id.nav_athletes -> { goToFragment(fragmentAthlete) }
                R.id.nav_feed ->{goToFragment(fragmentFeed) }
                R.id.nav_sports -> { }
                R.id.nav_profile -> { }
                R.id.nav_settings -> { }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.home_container,fragment)
            addToBackStack(null)
        }.commit()
    }
}
