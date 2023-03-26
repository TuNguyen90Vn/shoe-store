package com.tn.shoestore.ui.shoes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tn.shoestore.R
import com.tn.shoestore.databinding.ShoeListFragmentBinding
import com.tn.shoestore.models.FakeData
import com.tn.shoestore.utils.launchWhenStart
import kotlinx.coroutines.flow.collectLatest

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<ShoeListFragmentBinding?>(
            inflater, R.layout.shoe_list_fragment, container, false
        ).also {
            it.viewModel = viewModel
        }

        val adapter = ShoeAdapter()
        binding.adapter = adapter

        launchWhenStart {
            viewModel.uiState.collectLatest {
                binding.isShowLoading = it.isShowLoading
                adapter.setData(it.listShoes)
                if (it.isOpenShoeDetail) {
                    findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                    viewModel.resetState()
                }
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    @Deprecated(
        "Deprecated in Java",
        ReplaceWith("inflater.inflate(R.menu.logout_menu, menu)", "com.tn.shoestore.R")
    )
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }
}