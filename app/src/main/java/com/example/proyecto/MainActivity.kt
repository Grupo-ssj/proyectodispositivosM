package com.example.proyecto

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
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.text.MessageFormat


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
                supportFragmentManager.commit {
                    replace<fragment_venta>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.item3 -> {
                supportFragmentManager.commit {
                    replace<fragment_perfil>(R.id.frame_container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> mostrarproductos()

//            R.id.item2 -> { supportFragmentManager.beginTransaction().apply { replace(R.id.fragmentcontainer, MessagesFragment())
        //            commit}
//            }



        }
        drawer.closeDrawer(GravityCompat.START)
        return true
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
    fun mostrarproductos(){
        val intent = Intent(this,Productos()::class.java)
        startActivity(intent)
    }
}