package com.hackathon.happydiary.adapter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter(fm: FragmentManager, val fragmentMap: HashMap<Int, Fragment> = hashMapOf())
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {



    override fun getItem(position: Int): Fragment = fragmentMap[position]!!
    override fun getItemPosition(obj: Any): Int = super.getItemPosition(obj)
    fun getFragment(position: Int): Fragment? = fragmentMap[position]
    override fun getCount(): Int = fragmentMap.size
}