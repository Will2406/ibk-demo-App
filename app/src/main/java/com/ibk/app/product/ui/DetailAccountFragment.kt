package com.ibk.app.product.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibk.app.R
import com.ibk.app.databinding.FragmentDetailAccountBinding
import com.ibk.app.product.domain.model.Account
import com.ibk.app.product.ui.adapter.AccountListener
import com.ibk.app.product.ui.adapter.MovementAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailAccountFragment : Fragment() {

    private lateinit var binding: FragmentDetailAccountBinding

    private val adapter: MovementAdapter by lazy { MovementAdapter() }
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailAccountBinding.inflate(layoutInflater, container, false)
        binding.account = arguments?.getParcelable("account")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initViewModel()
        initAdapter()

    }

    private fun initViewModel() {
        binding.viewModel = viewModel
        viewModel.getAllMovements(binding.account)
    }

    private fun initAdapter() {
        binding.recyclerMovements.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMovements.adapter = adapter
    }

}