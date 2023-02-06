package com.neugelb.core.fragment

import androidx.appcompat.widget.Toolbar


/**
 * Created by Rafiqul Hasan
 */
interface FragmentCommunicator {
    fun showLoader()
    fun hideLoader()
    fun setActionBar(toolbar: Toolbar, enableBackButton: Boolean)
}