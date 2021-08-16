package com.example.practice.activities

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.R
import com.example.practice.adapters.UsersAdapter
import com.example.practice.api.RetrofitAPI
import com.example.practice.response.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Display list of users with the user information mentioned in the assignment
// Note: A nice looking UI is appreciated but clean code is more important

class MainActivity : AppCompatActivity() {

    private var listUsers: MutableList<User> = mutableListOf<User>()
    private var adapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listUsers = mutableListOf()

        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = UsersAdapter(
            this,
            listUsers
        )
        recycler_main.adapter = adapter

        if (isInternetAvailable()) {
            getUsersData()
        }
    }

    private fun getUsersData() {
        RetrofitAPI.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                val usersResponse = response.body()
                listUsers.clear()
                usersResponse?.let { listUsers.addAll(it) }
                adapter?.notifyDataSetChanged()
            }
        })
    }

    private fun isInternetAvailable(): Boolean {
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}
