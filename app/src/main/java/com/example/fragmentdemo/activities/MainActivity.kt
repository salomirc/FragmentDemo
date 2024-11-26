package com.example.fragmentdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.example.fragmentdemo.R
import com.example.fragmentdemo.fragments.AFragment
import com.example.fragmentdemo.fragments.BFragment
import com.example.fragmentdemo.fragments.CFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG_A : String = "TAG_FragmentA"
const val TAG_B : String = "TAG_FragmentB"
const val TAG_C : String = "TAG_FragmentC"

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private val newTransaction: FragmentTransaction
        get() = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = AFragment()
        val fragmentB = BFragment()
        val fragmentC = CFragment()

        lifecycleScope.launch {
//            delay(Long.MAX_VALUE)
            //Fragment_A
            newTransaction.apply {
                // "add" or "replace" give the same result here
                add(R.id.root_layout, fragmentA, TAG_A)
//                addToBackStack(TAG_A)
                commit()
            }
            delay(2000)


            //Fragment_B
            newTransaction.apply {
//            add(R.id.root_layout, fragmentB, TAG_B)
//            hide(fragmentA)
//            show(fragmentB)
                replace(R.id.root_layout, fragmentB, TAG_B)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                addToBackStack(TAG_B)
                commit()
            }

            // The fragment-ktx module provides a commit block that automatically
            // calls beginTransaction and commit for you.
//            supportFragmentManager.commit {
//                replace(R.id.root_layout, fragmentB, TAG_B)
//                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                addToBackStack(null)
//            }
            delay(2000)


            //Fragment_C
            newTransaction.apply {
//            add(R.id.root_layout, fragmentC, TAG_C)
//            hide(fragmentB)
//            show(fragmentC)
                replace(R.id.root_layout, fragmentC, TAG_C)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                addToBackStack(TAG_C)
                commit()
            }
            delay(2000)


            val fragments = supportFragmentManager.fragments
            for (item in fragments){
                Log.d(TAG, "Fragment name : ${item::class.java.name}")
            }

//            val searchFragmentA: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_a)
            val searchFragmentA: Fragment? = supportFragmentManager.findFragmentByTag(TAG_A)
            val searchFragmentB: Fragment? = supportFragmentManager.findFragmentByTag(TAG_B)
            val searchFragmentC: Fragment? = supportFragmentManager.findFragmentByTag(TAG_C)
            Log.d(TAG, "$searchFragmentA")
            Log.d(TAG, "$searchFragmentB")
            Log.d(TAG, "$searchFragmentC")
        }
    }
}
