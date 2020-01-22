package com.example.fragmentdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentdemo.R
import com.example.fragmentdemo.fragments.BFragment
import com.example.fragmentdemo.fragments.CFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG_B : String = "TAG_FragmentB"
const val TAG_C : String = "TAG_FragmentC"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

            val fragmentB = BFragment()
            val fragmentC = CFragment()

            var fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.add(R.id.root_layout, fragmentB, TAG_B)
            fragmentTransaction.replace(R.id.root_layout, fragmentB, TAG_B)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            delay(2000)

            fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.add(R.id.root_layout, fragmentC, TAG_C)
//            fragmentTransaction.hide(fragmentB)
//            fragmentTransaction.show(fragmentC)
            fragmentTransaction.replace(R.id.root_layout, fragmentC, TAG_C)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            delay(2000)

            val fragments = fragmentManager.fragments
            for (item in fragments){
                println("Fragment name : ${item::class.java.name}")
            }

            var searchFragmentA: Fragment? = fragmentManager.findFragmentById(R.id.fragment_a)
            var searchFragmentB: Fragment? = fragmentManager.findFragmentByTag(TAG_B)
            var searchFragmentC: Fragment? = fragmentManager.findFragmentByTag(TAG_C)
            println()
        }
    }
}
