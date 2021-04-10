package com.turkurt656.veripark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.turkurt656.common.core.base.BackPressCatcher

class MainActivity : AppCompatActivity() {

    private val navHostFragment: NavHostFragment?
        get() = supportFragmentManager.findFragmentById(R.id.mainNavHost) as? NavHostFragment

    private val currentFragment: Fragment?
        get() = navHostFragment?.childFragmentManager?.primaryNavigationFragment

    private val navController: NavController?
        get() = navHostFragment?.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        (currentFragment as? BackPressCatcher)?.onBackPressed()?.not()?.let {
            if (it) super.onBackPressed()
        }
    }

}