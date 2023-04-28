package com.example.proyecto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.res.Configuration
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import java.text.MessageFormat

enum class ProviderType{
    BASIC,
    GOOGLE
}

class MainActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //variables del drawer
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    //-------
    //cambios de frame para el botonnavigation
    lateinit var nav: BottomNavigationView
    private val navigation = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId) {
            R.id.item1 -> {
                supportFragmentManager.commit {
                    replace<fragment_producto>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.item2 -> {
                val perfilFragment = fragment_perfil()
                val bundle = Bundle()
                bundle.putString("email", intent.getStringExtra("email"))
                bundle.putString("provider", intent.getStringExtra("provider"))
                perfilFragment.arguments = bundle
                supportFragmentManager.commit {
                    replace(R.id.frame_container, perfilFragment)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                true
            }
        }
        false

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //codigo del drawer
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        navigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.item1 -> navFragment(fragment_producto(),it.title.toString())



            }
            true
        }

        //-------------------------------

        //delaracion e iniciacion del botonnavigation
        nav= findViewById(R.id.nav_menu)
        nav.setOnNavigationItemSelectedListener(navigation)

        supportFragmentManager.commit {
            replace<fragment_producto>(R.id.frame_container)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {//funcion de prueba para navegar con los items
        when(item.itemId){
            R.id.item1 -> navFragment(fragment_producto(),item.title.toString())



        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun navFragment(fragment:Fragment,title:String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container,fragment)
        fragmentTransaction.commit()
        drawer.closeDrawer(GravityCompat.START)
        setTitle(title)
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

}