package com.example.classpractice.ui.main.github

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.classpractice.R
import com.example.classpractice.databinding.GithubUserViewBinding

class UserListAdapter internal constructor(
    val context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: GithubViewModel
    ):    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var sims = emptyList<GithubUser>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class UserViewHolder(
        itemView: View,
        private val binding: GithubUserViewBinding,
        private val viewModel: GithubViewModel,
        private val lifecycleOwner: LifecycleOwner
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GithubUser) {
            //binding
            binding.item = item
            binding.viewModel = viewModel
            binding.executePendingBindings()
            binding.lifecycleOwner = lifecycleOwner
        }

 

    }
        override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): UserViewHolder{
    //    val itemView = inflater.inflate(R.layout.sim_card_view, parent, false)
    //    val binding = SimCardViewBinding.inflate(inflater, parent, false)
            val binding: GithubUserViewBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.github_user_view,
                parent,
                false
            )
            return UserViewHolder (binding.root, binding, viewModel, lifecycleOwner)
        }

        override fun onBindViewHolder(
            @NonNull holder: UserViewHolder,
            position: Int,
            payloads: MutableList<Any>
        ) {
            holder.bind(sims [position])
        }

        override fun getItemCount(): Int {
            return sims.size
        }

        override fun onBindViewHolder (holder: UserViewHolder, position: Int) {
            val current = sims[position]
            holder.bind(current)
        }

        fun setSims (it: List<GithubUser>) {
            this.sims = it
            notifyDataSetChanged()
        }
}
