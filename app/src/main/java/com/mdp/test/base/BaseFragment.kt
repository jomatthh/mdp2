package com.mdp.test.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<T : ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> T
) : Fragment() {
    private var progressDialog: ProgressDialog? = null
    private var _binding: T? = null
    val binding: T get() = _binding!!

    open fun T.initialize() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateMethod.invoke(inflater, container, false)
        binding.initialize()
        return binding.root
    }

    fun setTitleToolbar(title: String = ""){
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showProgressDialog(text: String? = null) {
        if (progressDialog == null) progressDialog = ProgressDialog()
        progressDialog?.let {
            it.text = text
            if (!it.isVisible) {
                it.show(childFragmentManager, "")
            }
        }
    }

    fun hideProgressDialog() {
        progressDialog?.dismiss()
    }
}