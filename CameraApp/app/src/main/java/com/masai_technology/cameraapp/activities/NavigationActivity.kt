package com.masai_technology.cameraapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.masai_technology.cameraapp.R
import com.masai_technology.cameraapp.Testfragment

/***
 * In this Activity we are creating the  navigation drawer
 */
class NavigationActivity : AppCompatActivity() {
    var drawerLayout: DrawerLayout? = null
    var toggle: ActionBarDrawerToggle? = null
    var toolbar: Toolbar? = null
    var navigationView: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        initViews()
    }

    private fun initViews() {
        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout?.addDrawerListener(toggle!!)
        toggle!!.syncState()
        navigationView = findViewById(R.id.nav_view)
        navigationView?.itemIconTintList = null
        /***
         * In this on click of the particular item on the drawer it will open the specific item
         */
        navigationView?.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            var fragment: Fragment? = null
            when (id) {
                R.id.menu_style -> {
                    fragment = Testfragment()
                    loadFragment(fragment)
                }
                R.id.menu_settings -> {
                    val intent = Intent(this@NavigationActivity, SettingsActivity::class.java);
                    startActivity(intent);
                }

                R.id.menu_share -> {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Camera App")
                    val app_url =
                        "https://flycricket.io/privacy.html"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                }
                R.id.not_happy -> {

                }
                R.id.rate -> {
                    val intent = Intent(this@NavigationActivity, RateActivity::class.java);
                    startActivity(intent);
                }


                R.id.recognition -> {
                    val intent = Intent(this@NavigationActivity, RecognitionActivity::class.java);
                    startActivity(intent);

                }
                R.id.faq -> {


                }
                R.id.menu_information -> {


                }
                else -> return@OnNavigationItemSelectedListener true
            }
            true
        })

    }
    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment).commit()
        drawerLayout!!.closeDrawer(GravityCompat.START)
        fragmentTransaction.addToBackStack(null)
    }

    override fun onStart() {
        super.onStart()
        val styleFragment = Testfragment()
        supportFragmentManager.beginTransaction().add(R.id.frame, styleFragment, "Testfragment").commit()
    }
    }
