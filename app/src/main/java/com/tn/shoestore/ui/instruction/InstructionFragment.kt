package com.tn.shoestore.ui.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tn.shoestore.R
import com.tn.shoestore.databinding.InstructionFragmentBinding
import com.tn.shoestore.ui.welcome.WelcomeViewModel
import com.tn.shoestore.utils.launchWhenStart
import kotlinx.coroutines.flow.collectLatest

class InstructionFragment : Fragment() {

    private lateinit var binding: InstructionFragmentBinding

    private val viewModel: InstructionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<InstructionFragmentBinding?>(
            inflater, R.layout.instruction_fragment, container, false
        ).also {
            it.viewModel = viewModel
        }

        launchWhenStart {
            viewModel.uiState.collectLatest {
                if (it.isOpenShoeStore) {
                    findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
                }
            }
        }

        return binding.root
    }
}