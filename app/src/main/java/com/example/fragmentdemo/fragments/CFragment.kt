package com.example.fragmentdemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.fragmentdemo.R
import com.example.fragmentdemo.activities.TAG_C

/**
 * A simple [Fragment] subclass.
 */
class CFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fgmView = inflater.inflate(R.layout.fragment_c, container, false)
        fgmView.tag = TAG_C
        return fgmView
    }


}
