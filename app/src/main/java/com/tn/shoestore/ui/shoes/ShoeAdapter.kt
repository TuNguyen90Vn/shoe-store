package com.tn.shoestore.ui.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tn.shoestore.databinding.ItemShoeBinding
import com.tn.shoestore.models.Shoe

internal class ShoeAdapter : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    private var models = emptyList<Shoe>()

    fun setData(models: List<Shoe>) {
        this.models = models
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: ItemShoeBinding = ItemShoeBinding.inflate(layoutInflater, parent, false)
        return ShoeViewHolder(itemBinding)
    }

    override fun getItemCount(): Int =
        models.size

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bindData(model = models[position])
    }

    internal class ShoeViewHolder(private val binding: ItemShoeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: Shoe) {
            binding.model = model
        }
    }

}