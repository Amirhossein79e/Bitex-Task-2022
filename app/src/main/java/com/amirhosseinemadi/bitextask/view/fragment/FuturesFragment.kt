package com.amirhosseinemadi.bitextask.view.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.amirhosseinemadi.bitextask.R
import com.amirhosseinemadi.bitextask.databinding.FragmentFuturesBinding
import com.amirhosseinemadi.bitextask.model.remote.entity.Order
import com.amirhosseinemadi.bitextask.model.remote.entity.RespObject
import com.amirhosseinemadi.bitextask.util.RespStatus
import com.amirhosseinemadi.bitextask.util.Utilities
import com.amirhosseinemadi.bitextask.viewmodel.FuturesVm

class FuturesFragment : Fragment() {

    private lateinit var binding: FragmentFuturesBinding
    private lateinit var viewModel: FuturesVm
    private lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = FuturesVm()
        loadingDialog = Utilities.loadingDialog(requireContext())
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<FragmentFuturesBinding?>(inflater, R.layout.fragment_futures, container, false).also { it.viewModel = viewModel }
        initLayout()
        registerObservers()

        return binding.root
    }


    private fun initLayout() {
        binding.radioGroup.setOnCheckedChangeListener(this::onCheckedChange)
        binding.btnSubmit.setOnClickListener(this::submitClick)
    }


    private fun onCheckedChange(btn: RadioGroup?, id: Int) {
        when (id) {
            R.id.buy -> {
                binding.btnSubmit.text = "Buy / Long"
                binding.btnSubmit.setBackgroundResource(R.drawable.btn_buy_background)
            }

            R.id.sell -> {
                binding.btnSubmit.text = "Sell / Short"
                binding.btnSubmit.setBackgroundResource(R.drawable.btn_sell_background)
            }
        }
    }


    private fun submitClick(view: View)
    {
        if ((binding.radioGroup.get(0) as RadioButton).isChecked)
        {
            if (!binding.edtAmount.text.isNullOrEmpty() && binding.edtAmount.text.toString() != "0")
            {
                viewModel.createOrder("BTC", binding.edtAmount.text.toString().toDouble())
            } else
            {
                Toast.makeText(context, "You should set a valid amount", Toast.LENGTH_SHORT).show()
            }
        } else
        {
            Toast.makeText(context, "Functionality not implemented", Toast.LENGTH_SHORT).show()
        }
    }


    private fun registerObservers()
    {
        viewModel.orderLiveData.observe(viewLifecycleOwner) {

            when (it.respStatus)
            {
                RespStatus.SUCCESSFUL ->
                {
                    hideLoading()
                    Toast.makeText(context, "Order successfully create with id ${it.response?.id}", Toast.LENGTH_SHORT).show()
                }

                RespStatus.FAILED ->
                {
                    hideLoading()
                    Toast.makeText(context, "An error occurred. please try again", Toast.LENGTH_SHORT).show()
                }

                RespStatus.LOADING ->
                {
                    showLoading()
                }
            }

        }
    }


    private fun showLoading()
    {
        if (!loadingDialog.isShowing)
        {
            loadingDialog.show()
        }
    }


    private fun hideLoading()
    {
        if (loadingDialog.isShowing)
        {
            loadingDialog.hide()
        }
    }

}
