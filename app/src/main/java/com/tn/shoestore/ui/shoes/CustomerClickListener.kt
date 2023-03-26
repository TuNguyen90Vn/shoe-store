package com.tn.shoestore.ui.shoes

import com.tn.shoestore.models.Shoe

interface CustomerClickListener {

    fun onClick(item: Shoe)

}