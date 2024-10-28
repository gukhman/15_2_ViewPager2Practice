package com.example.a15_2_viewpager2practice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginField = view.findViewById<EditText>(R.id.loginEditText)
        val passwordField = view.findViewById<EditText>(R.id.passwordEditText)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val login = loginField.text.toString()
            val password = passwordField.text.toString()
            val sharedPreferences = activity?.getSharedPreferences("MyBankPrefs", Context.MODE_PRIVATE)
            val registeredLogin = sharedPreferences?.getString("login", "")
            val registeredPassword = sharedPreferences?.getString("password", "")

            if (login == registeredLogin && password == registeredPassword) {
                (activity as MainActivity).navigateToMainBank()
            } else {
                Toast.makeText(context, "Неверные данные", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}