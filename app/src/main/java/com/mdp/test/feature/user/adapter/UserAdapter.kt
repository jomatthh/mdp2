package com.mdp.test.feature.user.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdp.test.base.BaseViewHolder
import com.mdp.test.databinding.RowUserBinding
import com.mdp.test.feature.user.model.UserModel

class UserAdapter(
    private val context: Context,
    private var items: List<UserModel>,
    private val listener: OnUserAdapterListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val layoutInflater = LayoutInflater.from(context)
        return UserViewHolder(
            RowUserBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(items[position], position)
        }
    }

    fun update(newItems: List<UserModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class UserViewHolder(private val binding: RowUserBinding) :
        BaseViewHolder<UserModel>(binding.root) {
        override fun bind(item: UserModel, position: Int) {
            binding.tvName.text = item.name
            binding.root.setOnClickListener {
                listener.itemClick(item)
            }
        }
    }

    interface OnUserAdapterListener{
        fun itemClick(item: UserModel)
    }
}