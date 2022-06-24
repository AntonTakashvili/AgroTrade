package com.example.agrotrade.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agrotrade.R

class homeFragment:Fragment(R.layout.fragment_home) {

    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        username = view.findViewById(R.id.usernameLog)
        password = view.findViewById(R.id.passwordLog)
        view.findViewById<Button>(R.id.registerbtn).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registrationFragment)
        }

        view.findViewById<Button>(R.id.login_btn).setOnClickListener {
            validEmptyForm()
//            findNavController().navigate(R.id.action_homeFragment_to_productFragment)
        }
        return view
    }
    private fun validEmptyForm() {
        when {
            TextUtils.isEmpty(username.text.toString().trim()) -> {
                username.error = "Please enter Username"
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.error = "Please enter Password"
            }
            username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()->{
                if (username.text.toString().length>=4){
                    if (password.text.toString().length>=5){
                        findNavController().navigate(R.id.action_homeFragment_to_productFragment)
                        Toast.makeText(context,"Welcome ${username.text}", Toast.LENGTH_SHORT).show()
                    }else{
                        password.error="Too short Password(at least 5 character)"
                    }
                }else{
                    username.error = "Too short Username(at least 4 character)"
                }
            }
        }
    }
}