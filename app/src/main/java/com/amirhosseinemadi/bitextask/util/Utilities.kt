package com.amirhosseinemadi.bitextask.util

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.content.res.AppCompatResources
import com.amirhosseinemadi.bitextask.R

class Utilities {

    companion object
    {
        fun loadingDialog(context: Context) : Dialog
        {
            val view: View = LayoutInflater.from(context).inflate(R.layout.dialog_loading,null)
            val dialog: Dialog = Dialog(context)
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.window?.setBackgroundDrawable(AppCompatResources.getDrawable(context, R.drawable.dialog_background))
            dialog.setCancelable(false)
            dialog.setContentView(view)

            return dialog
        }
    }

}