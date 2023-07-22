package com.example.classpractice.ui.main.github

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classpractice.R
import com.example.classpractice.databinding.FragmentGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubFragment : Fragment() {

    companion object {
        fun newInstance() = GithubFragment()
    }

    private lateinit var binding:FragmentGithubBinding
    private lateinit var viewModel: GithubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_github,
            container,false
        )

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.users_recycleView)
        val adapter = UserListAdapter(binding.root.context, this,viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        viewModel.users.observe(viewLifecycleOwner,Observer{
            adapter.setSims(it)
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}