package com.example.retrofit_demo.screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_demo.model.GitHubUserModel
import com.bumptech.glide.Glide
import com.example.retrofit_demo.R

class GithubUserRcvAdapter(private val context: Context, private val list: List<GitHubUserModel>) : RecyclerView.Adapter<GithubUserRcvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_github, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userFollower = list[position]
        holder.bind(userFollower)

    }
    override fun getItemCount(): Int {
       return list.size
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val textUserFollower = view.findViewById<TextView>(R.id.txtUserFollower)
        private val textIDFollower = view.findViewById<TextView>(R.id.txtIDFollower)
        private val imageFollower = view.findViewById<ImageView>(R.id.imgFollower)

        fun bind (model:GitHubUserModel) {
            textUserFollower.text = model.login
            textIDFollower.text = model.id.toString()
            Glide.with(context).load(model.avatar_url).into(imageFollower)
        }

    }
}