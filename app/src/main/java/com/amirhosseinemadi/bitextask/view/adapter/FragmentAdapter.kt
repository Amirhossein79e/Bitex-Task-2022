package com.amirhosseinemadi.bitextask.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.amirhosseinemadi.bitextask.view.fragment.EmptyFragment
import com.amirhosseinemadi.bitextask.view.fragment.FuturesFragment

class FragmentAdapter(fragmentManager:FragmentManager,private val fragments:List<Fragment>) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position)
        {
            0 -> {"Exchange"}
            1 -> {"Margin"}
            2 -> {"Futures"}
            else -> {""}
        }
    }
}