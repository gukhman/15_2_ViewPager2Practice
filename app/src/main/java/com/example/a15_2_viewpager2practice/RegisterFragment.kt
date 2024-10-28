package com.example.a15_2_viewpager2practice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val loginField = view.findViewById<EditText>(R.id.loginEditText)
        val passwordField = view.findViewById<EditText>(R.id.passwordEditText)
        val registerButton = view.findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val login = loginField.text.toString()
            val password = passwordField.text.toString()
            val sharedPreferences = activity?.getSharedPreferences("MyBankPrefs", Context.MODE_PRIVATE)
            sharedPreferences?.edit()?.apply {
                putString("login", login)
                putString("password", password)
                apply()
            }
            (activity as MainActivity).navigateToLogin()
        }
        return view
    }
}