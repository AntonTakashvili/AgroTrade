package com.example.agrotrade

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.agrotrade.adapter.ViewAdapter
import com.example.agrotrade.fragments.View1Fragment
import com.example.agrotrade.fragments.View2Fragment

class AboutUs:AppCompatActivity(R.layout.fragment_about_us) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_about_us)

        val view: ViewPager2 = findViewById(R.id.view_pager)
        val pages:ArrayList<Fragment> = arrayListOf(
            View1Fragment(),
            View2Fragment()
        )
        val adapter = ViewAdapter(pages,this)
        view.adapter=adapter
    }

}