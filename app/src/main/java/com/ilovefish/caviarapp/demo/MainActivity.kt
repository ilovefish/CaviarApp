package com.ilovefish.caviarapp.demo

import android.os.Bundle
import androidx.navigation.findNavController
import com.ilovefish.caviarapp.R
import com.ilovefish.caviarmvvm.base.activity.BaseActivity
import com.ilovefish.caviarapp.databinding.ActivityMainBinding
import com.ilovefish.caviarapp.demo.ui.widget.BottomNavigationView
import com.ilovefish.caviarapp.demo.ui.widget.OnItemSelectedListener
import com.ilovefish.caviarapp.demo.state.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        val composeNavigationView: BottomNavigationView = mDatabind.composeNavView;

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        composeNavigationView.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNavigationItemSelected(index: Int, navResId: Int) {
                navController.navigate(navResId)
            }
        }
    }
}