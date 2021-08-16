package com.example.practice.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.response.User

class UsersAdapter(private val context: Context, private var list: MutableList<User>) :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.user_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = list.get(position)
        val addressObj = user.addressObject
        val companyObj = user.companyObject

        holder.address?.text = "City" + ":" + addressObj?.city
        holder.company?.text = "Company Name" + ":" + companyObj?.name
        holder.itemId?.text = user.id + " . " + user.name
        holder.info1?.text = "Email" + ":" + user.email
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var itemId: TextView? = null
        var info1: TextView? = null
        var address: TextView? = null
        var company: TextView? = null

        init {
            itemId = view.findViewById(R.id.txt_user_id)
            info1 = view.findViewById(R.id.txt_user_info1)
            address = view.findViewById(R.id.txt_user_address)
            company = view.findViewById(R.id.txt_company_name)
        }
    }
}