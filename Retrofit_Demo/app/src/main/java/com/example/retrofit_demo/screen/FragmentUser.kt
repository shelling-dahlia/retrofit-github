package com.example.retrofit_demo.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.retrofit_demo.repository.GithubDataRepository
import com.bumptech.glide.Glide
import com.example.retrofit_demo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentUser : Fragment() {

    private lateinit var btnMoveToUserFollower : Button
    private lateinit var btnMoveToUserFollowing : Button
    private lateinit var imgUserAvatar: ImageView
    private lateinit var txtUserName: TextView
    private val githubDataRepository = GithubDataRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_user, container, false)
        addControls(view)
        addEvents()
        loadData()
        return view

    }

    private fun addControls(view: View) {
        btnMoveToUserFollower = view.findViewById(R.id.btnFollower)
        btnMoveToUserFollowing = view.findViewById(R.id.btnFollowing)
        imgUserAvatar = view.findViewById(R.id.imgUserAvatar)
        txtUserName = view.findViewById(R.id.txtUserName)
    }

    private fun addEvents() {
        btnMoveToUserFollowing.setOnClickListener {
            findNavController(this).navigate(R.id.action_FragmentUser_to_FragmentFollowing)
        }
        btnMoveToUserFollower.setOnClickListener {
            findNavController(this).navigate(R.id.action_FragmentUser_to_FragmentFollower)
        }
    }

    private fun loadData () {
        CoroutineScope(Dispatchers.IO).launch {
            val userModel = githubDataRepository.getUserDetailfromAPI("mosh-hamedani")
            withContext(Dispatchers.Main) {
                txtUserName.text = userModel?.name ?: ""
                Glide.with(this@FragmentUser).load(userModel?.avatar_url).into(
                    imgUserAvatar
                )
            }
        }
    }

}