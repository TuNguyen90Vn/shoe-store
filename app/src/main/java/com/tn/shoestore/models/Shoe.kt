package com.tn.shoestore.models

import android.os.Parcelable
import androidx.databinding.Bindable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    private var name: String,
    private var size: Double,
    private var company: String,
    private var description: String,
    private val images: List<String> = mutableListOf()
) : Parcelable {

    fun getName() : String {
        return name
    }
    fun setName(value : String) {
        name = value
    }

    fun getCompany() : String {
        return company
    }
    fun setCompany(value : String) {
        company = value
    }


    fun getDescription() : String {
        return description
    }
    fun setDescription(value : String) {
        description = value
    }

    fun getSize() : String {
        return size.toString()
    }
    fun setSize(value : String) {
        size = if (value.isNotEmpty()) value.toDouble() else 0.0
    }

    companion object {
        val DEFAULT = Shoe(
            name = "",
            size = 0.0,
            company = "",
            description = ""
        )
    }
}