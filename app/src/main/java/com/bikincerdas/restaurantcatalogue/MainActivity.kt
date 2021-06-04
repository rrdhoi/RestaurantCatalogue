package com.bikincerdas.restaurantcatalogue

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.bikincerdas.restaurantcatalogue.databinding.ActivityMainBinding
import com.bikincerdas.restaurantcatalogue.home.HomeFragment
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.appBarMain.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, HomeFragment())
                    .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                val uri = Uri.parse("restaurantcatalogue://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAfterTransition()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.root.removeAllViewsInLayout()
        _binding = null
    }
}