package com.example.agrotrade

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

class registrationFragment:Fragment(R.layout.fragment_registration) {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var gmail: EditText
    private lateinit var fname: EditText
    private lateinit var lname: EditText
    private lateinit var pnumber: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        username = view.findViewById(R.id.usernameReg)
        password = view.findViewById(R.id.passwordReg)
        cpassword = view.findViewById(R.id.cpasswordReg)
        gmail=view.findViewById(R.id.gmailReg)
        fname=view.findViewById(R.id.fnameReg)
        lname=view.findViewById(R.id.lnameReg)
        pnumber=view.findViewById(R.id.pnumberReg)
        view.findViewById<Button>(R.id.register_reg).setOnClickListener {
            validEmptyForm()
//            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
        }
        view.findViewById<Button>(R.id.signin_reg).setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
        }
        return view
    }

    private fun validEmptyForm() {
        when {
            TextUtils.isEmpty(username.text.toString().trim()) -> {
                username.error = "Please enter username"
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.error = "Please enter Password"
            }
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                cpassword.error = "Please enter Password again"
            }
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                gmail.error = "Please enter Gmail"
            }
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                fname.error = "Please enter First Name"
            }
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                lname.error = "Please enter Last Name"
            }
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                pnumber.error = "Please enter Phone Number"
            }
            username.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() &&
                    cpassword.text.toString().isNotEmpty() && gmail.text.toString().isNotEmpty() &&
                    fname.text.toString().isNotEmpty() && lname.text.toString().isNotEmpty() &&
                    pnumber.text.toString().isNotEmpty() -> {

                if (gmail.text.toString().matches(
                        Regex(
                            "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
                        )
                    )
                ) {
                    if (password.text.toString().length >= 5) {
                        if (password.text.toString() == cpassword.text.toString()) {
                            Toast.makeText(context, "Register Successful", Toast.LENGTH_SHORT)
                                .show()
                            findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                        } else {
                            cpassword.error = "Password doesn't match"
                        }
                    } else {
                        password.error = "Enter at least 5 Character"
                    }
                } else {
                    gmail.error = "Enter valid Gmail"
                }
            }
        }
    }
}