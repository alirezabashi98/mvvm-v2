package com.arb.mvvm_v2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arb.mvvm_v2.dataClass.User
import com.arb.mvvm_v2.databinding.ItemRecyclerBinding

class AdapterItemRecycler(private var data: List<User>) :
    RecyclerView.Adapter<AdapterItemRecycler.ViewHolder>() {

    class ViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(user: User) {

            binding.data = user

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.setData(data[position])

    override fun getItemCount(): Int = data.size

    fun reloadData(data: List<User>) {

        this.data = data
        notifyDataSetChanged()

    }

}