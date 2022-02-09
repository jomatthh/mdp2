package com.mdp.test.feature.user.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alicorp.nitro.core.EventObserver
import com.mdp.test.base.BaseFragment
import com.mdp.test.databinding.FragmentUserBinding
import com.mdp.test.feature.user.adapter.UserAdapter
import com.mdp.test.feature.user.model.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate),
    UserAdapter.OnUserAdapterListener {
    private val viewModel: UserViewModel by viewModels()
    private val adapter by lazy {
        UserAdapter(requireContext(), emptyList(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
        viewModel.getUsers()
    }

    private fun setupAdapter() {
        binding.rvUser.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUser.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.user.observe(viewLifecycleOwner) {
            adapter.update(it)
        }
    }

    override fun itemClick(item: UserModel) {
        val action = UserFragmentDirections.actionUserFragmentToUserDetailFragment(item)
        findNavController().navigate(action)
    }
}