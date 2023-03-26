package com.tn.shoestore.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.tn.shoestore.R
import com.tn.shoestore.databinding.LoginFragmentBinding
import com.tn.shoestore.models.FakeData
import com.tn.shoestore.models.Shoe
import com.tn.shoestore.utils.launchWhenStart
import kotlinx.coroutines.flow.collectLatest

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        launchWhenStart {
            viewModel.uiState.collectLatest { uiState ->
                updateUI(uiState)
            }
        }

        return binding.root
    }

    private fun updateUI(uiState: LoginViewModel.LoginViewState) {
        if (uiState.isLoggedIn) {
            binding.root.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
    }
}