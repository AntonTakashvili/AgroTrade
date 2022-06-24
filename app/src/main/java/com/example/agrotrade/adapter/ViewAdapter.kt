package com.example.agrotrade.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewAdapter (val pages:ArrayList<Fragment>,activity: AppCompatActivity):FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
       return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position]
    }
}