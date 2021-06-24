package com.example.retrofit_demo.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_demo.repository.GithubDataRepository
import com.example.retrofit_demo.R
import com.example.retrofit_demo.model.GitHubUserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentFollower : Fragment() {

    private lateinit var btnBack: Button
    private lateinit var rcvFollower: RecyclerView
    private lateinit var adapterFollower: GithubUserRcvAdapter
    private val githubDataRepository = GithubDataRepository()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val list: ArrayList<GitHubUserModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_follower,container,false)
        addControls(view)
        addEvents()
        loadData()
        return view
    }

    private fun addControls (view: View) {
        btnBack = view.findViewById(R.id.btnBack)
        rcvFollower = view.findViewById(R.id.rcvFollower)
        adapterFollower = GithubUserRcvAdapter(requireContext(), list)
        rcvFollower.layoutManager = LinearLayoutManager(requireContext())
        rcvFollower.adapter = adapterFollower

    }

    private fun addEvents () {
        btnBack.findViewById<Button>(R.id.btnBack).setOnClickListener {
            findNavController(this).navigate(R.id.action_FragmentFollower_to_FragmentUser)
        }
    }

    private fun loadData () {
        coroutineScope.launch {
            val listUserFollower = githubDataRepository.getListFollowerfromAPI("mosh-hamedani")!!
            withContext(Dispatchers.Main){
                Log.d("FragmentFollower", "Result size: ${listUserFollower.size}")
                list.addAll(listUserFollower)
                adapterFollower.notifyDataSetChanged()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}