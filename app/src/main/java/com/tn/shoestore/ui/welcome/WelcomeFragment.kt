package com.tn.shoestore.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.tn.shoestore.R
import com.tn.shoestore.databinding.WelcomeFragmentBinding
import com.tn.shoestore.utils.launchWhenStart
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment() {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate<WelcomeFragmentBinding?>(
            inflater, R.layout.welcome_fragment, container, false
        ).also {
            it.viewModel = viewModel
        }

        launchWhenStart {
            viewModel.uiState.collectLatest {
                if(it.isOpenIntroduceScreen) {
                    findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
                }
            }
        }
        return binding.root
    }
}