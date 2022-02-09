package com.mdp.test.feature.userdetail.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mdp.test.base.BaseFragment
import com.mdp.test.databinding.FragmentUserDetailBinding
import com.mdp.test.feature.user.model.UserModel

class UserDetailFragment :
    BaseFragment<FragmentUserDetailBinding>(FragmentUserDetailBinding::inflate) {

    private val args: UserDetailFragmentArgs by navArgs()
    private lateinit var model: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = args.model
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() = with(binding){
        tvName.text = model.name
        tvEmail.text = model.email
    }
}