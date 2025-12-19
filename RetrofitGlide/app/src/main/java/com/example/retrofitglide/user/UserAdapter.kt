package com.example.retrofitglide.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitglide.R


class UserAdapter(private val userList: ArrayList<User>)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.item_user,
            parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        val user = userList[position]
        // Di dalam ViewHolder / onBind
        Glide.with(holder.itemView.context)
            .load(user.avatar) // URL gambar
            .circleCrop() // Opsional: membuat gambar bulat
            .into(holder.imgAvatar) // Target ImageView

        holder.tvName.text = "${user.first_name} ${user.last_name}"
        holder.tvEmail.text = user.email

    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class UserViewHolder(view: View)
        : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
        val imgAvatar: ImageView = view.findViewById(R.id.imgAvatar)
    }

    fun setData(users : List<User>) {
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
}