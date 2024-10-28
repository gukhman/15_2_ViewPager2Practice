package com.example.a15_2_viewpager2practice

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2

class MainActivity : BaseActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWindowInsets(R.id.main)
        setupToolbar(R.id.toolbar, false)

        viewPager = findViewById(R.id.viewPager)

        val slides = listOf(
            Slide(
                "Добро пожаловать!",
                "Мы - надежный и инновационный банк, созданный для удобства клиентов",
                R.drawable.bank_image_1
            ),
            Slide(
                "Потрясающий опыт использования банковских услуг",
                "Оплачивайте счета и переводите средства с минимальной комиссией!",
                R.drawable.bank_image_2
            ),
            Slide("Начнем работу!", "Готовы зарегистрироваться?", R.drawable.bank_image_3)
        )

        viewPager.adapter = SlideAdapter(this, slides)
    }

    fun navigateToRegister() {
        viewPager.visibility = View.GONE
        findViewById<FrameLayout>(R.id.fragmentContainer).visibility = View.VISIBLE

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, RegisterFragment())
            .commit()
    }

    fun navigateToLogin() {
        viewPager.visibility = View.GONE
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, LoginFragment())
            .addToBackStack(null)
            .commit()
    }

    fun navigateToMainBank() {
        viewPager.visibility = View.GONE
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MainBankFragment())
            .commit()
    }
}