package com.ibk.app.product.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibk.app.R
import com.ibk.app.databinding.FragmentAccountBinding
import com.ibk.app.product.domain.model.Account
import com.ibk.app.product.ui.adapter.AccountAdapter
import com.ibk.app.product.ui.adapter.AccountListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private val viewModel: AccountViewModel by viewModels()
    private val adapter: AccountAdapter by lazy { AccountAdapter() }

    private lateinit var binding: FragmentAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initViewModel()
        initAdapter()
        pullToRefresh()

    }

    private fun initViewModel() {
        binding.viewModel = viewModel
    }

    private fun initAdapter() {
        binding.recyclerAccounts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAccounts.adapter = adapter

        adapter.listener = object : AccountListener {
            override fun goToDetail(account: Account) {
                val bundle = Bundle().apply { putParcelable("account", account) }
                findNavController().navigate(R.id.action_accountFragment_to_detailAccountFragment, bundle)
            }
        }
    }

    private fun pullToRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.updateAccounts()
            binding.swipeRefresh.isRefreshing = false
        }
    }

}