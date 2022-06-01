package com.amirhosseinemadi.bitextask.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.amirhosseinemadi.bitextask.R
import com.amirhosseinemadi.bitextask.databinding.FragmentTradeBinding
import com.amirhosseinemadi.bitextask.view.adapter.FragmentAdapter

class TradeFragment : Fragment() {

    private lateinit var binding:FragmentTradeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trade,container,false)
        initLayout()

        return binding.root
    }


    private fun initLayout()
    {
        binding.tabLayout.setupWithViewPager(binding.pager,true)
        binding.pager.adapter = FragmentAdapter(childFragmentManager, listOf(EmptyFragment(),EmptyFragment(),FuturesFragment()))
        binding.pager.setCurrentItem(2,true)
    }

}