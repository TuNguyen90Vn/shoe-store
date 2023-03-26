package com.tn.shoestore.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Fragment.launch(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launch { block() }

fun Fragment.launchWhenStart(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launchWhenStarted { block() }

fun Fragment.launchWhenCreated(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launchWhenCreated { block() }

fun Fragment.launchWhenResumed(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launchWhenResumed { block() }

fun ViewModel.launch(block: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch { block() }