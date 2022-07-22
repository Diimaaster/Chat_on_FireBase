package com.chat_on_firebase

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chat_on_firebase.databinding.ActivitySignInBinding
import com.chat_on_firebase.databinding.UserListItemBinding

class UserAdapter() : ListAdapter<User, UserAdapter.ItemHolder>(ItemComporator()) {



    class ItemHolder(private val binding: UserListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) = with(binding){
            UMessage.text = user.message
            userName.text = user.name
        }

        companion object{
            fun create(parent: ViewGroup): ItemHolder{
                return ItemHolder(UserListItemBinding
                    .inflate(LayoutInflater.from(parent.context),parent,false))
            }
        }

    }

    class ItemComporator : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

}