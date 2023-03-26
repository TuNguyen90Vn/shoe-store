package com.tn.shoestore.ui.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tn.shoestore.R
import com.tn.shoestore.databinding.ShoeDetailFragmentBinding
import com.tn.shoestore.models.Shoe
import com.tn.shoestore.ui.shoes.SaveState
import com.tn.shoestore.ui.shoes.ShoeViewModel
import com.tn.shoestore.utils.launchWhenStart
import kotlinx.coroutines.flow.collectLatest

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false
        )

        binding.viewModel = viewModel
        binding.shoeData = Shoe.DEFAULT

        launchWhenStart {
            viewModel.uiState.collectLatest {
                if (it.saveState == SaveState.SAVE || it.saveState == SaveState.CANCEL) {
                    findNavController().popBackStack()
                    viewModel.resetState()
                }
            }
        }

        return binding.root
    }
}