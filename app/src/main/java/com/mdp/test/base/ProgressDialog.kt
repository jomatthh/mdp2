package com.mdp.test.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.mdp.test.R
import com.mdp.test.databinding.DialogFragmentProgressBinding

class ProgressDialog : BaseDialogFragment<DialogFragmentProgressBinding>() {

    var text: String? = null

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogFragmentProgressBinding {
        return DialogFragmentProgressBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        binding.progressDfTvMessage.text = text ?: getString(R.string.loading_message)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            manager.beginTransaction().remove(this).commit()
            super.show(manager, tag)
        } catch (e: IllegalStateException) {
            e.message
        }
    }

    override fun dismiss() {
        super.dismissAllowingStateLoss()
    }

    fun isShowing(): Boolean {
        dialog?.let {
            return it.isShowing
        }
        return false
    }
}