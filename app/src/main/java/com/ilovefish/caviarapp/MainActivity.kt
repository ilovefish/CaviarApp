package com.ilovefish.caviarapp

import android.os.Bundle
import androidx.navigation.findNavController
import com.ilovefish.caviarmvvm.base.activity.BaseActivity
import com.ilovefish.caviarapp.databinding.ActivityMainBinding
import com.ilovefish.caviarapp.ui.widget.OnItemSelectedListener
import com.ilovefish.caviarapp.viewmodel.state.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

        val composeNavigationView: com.ilovefish.caviarapp.ui.widget.BottomNavigationView = mDatabind.composeNavView;

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        composeNavigationView.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNavigationItemSelected(index: Int, navResId: Int) {
                navController.navigate(navResId)
            }
        }
    }
}