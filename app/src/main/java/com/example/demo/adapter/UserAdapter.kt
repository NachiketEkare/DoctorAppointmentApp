package com.example.demo.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.model.User
import com.example.demo.databinding.ListRowBinding

class UserAdapter(
    val context: Context,
    private val itemDeleteInterface: ItemDeleteInterface
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        //holder.profileImage.setImageResource(user.profileImage)
        holder.status.text = user.email
        holder.userNameTextView.text = user.name
        holder.userAgeTextView.text = user.age
        holder.userGenderTextView.text = user.gender
        holder.acceptBtn.setOnClickListener {
            holder.greenTick.visibility = if (holder.greenTick.visibility == View.INVISIBLE) {
                holder.acceptBtn.visibility = View.GONE
                holder.btnReject.visibility = View.GONE
                holder.comment.visibility = View.VISIBLE
                Toast.makeText(context, "${user.name} appointment is accepted", Toast.LENGTH_SHORT)
                    .show()
                View.VISIBLE // If currently invisible, make it visible
            } else {
                View.GONE // If currently visible, make it invisible
            }
        }
        holder.btnReject.setOnClickListener {

            itemDeleteInterface.onDelete(userList[position])

        }
    }


    override fun getItemCount(): Int {
        return userList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<User>) {
        userList.clear()
        userList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(binding: ListRowBinding) : RecyclerView.ViewHolder(binding.root) {

        // Initialize and bind UI elements here
        //val profileImage: ImageView = itemView.findViewById(R.id.doc_image)
        val userNameTextView: TextView = binding.Name
        val userAgeTextView: TextView = binding.Age
        val userGenderTextView: TextView = binding.Gender
        val btnReject: Button = binding.reject
        val status: TextView = binding.status
        val greenTick: ImageView = binding.greenTick
        val acceptBtn: Button = binding.accept
        val comment: TextView = binding.comment
    }
}

interface ItemDeleteInterface {
    fun onDelete(user: User)
}
