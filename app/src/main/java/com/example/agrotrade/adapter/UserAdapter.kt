package com.example.agrotrade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agrotrade.R
import com.example.agrotrade.api.User
import com.squareup.picasso.Picasso

class UserAdapter(private val users: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    class  UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val textView = itemView.findViewById<TextView>(R.id.textView)
        private val textView2 = itemView.findViewById<TextView>(R.id.textView2)
        private val img = itemView.findViewById<ImageView>(R.id.imageView)
        fun onBind(user: User) {
            textView.text = user.firstName+"  "+user.lastName
            textView2.text = user.email


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(users[position])

    }

    override fun getItemCount(): Int {
        return users.size

    }


}