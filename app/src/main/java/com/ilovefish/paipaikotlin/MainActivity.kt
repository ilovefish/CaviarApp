package com.ilovefish.paipaikotlin

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ilovefish.caviarmvvm.base.activity.BaseActivity
import com.ilovefish.paipaikotlin.databinding.ActivityMainBinding
import com.ilovefish.paipaikotlin.ui.widget.OnItemSelectedListener
import com.ilovefish.paipaikotlin.viewmodel.state.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        val composeNavigationView: com.ilovefish.paipaikotlin.ui.widget.BottomNavigationView = mDatabind.composeNavView;

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        composeNavigationView.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNavigationItemSelected(index: Int, navResId: Int) {
                navController.navigate(navResId)
            }
        }
    }
}