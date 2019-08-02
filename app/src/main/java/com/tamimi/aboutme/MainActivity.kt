package com.tamimi.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tamimi.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // this is the binding object for main activity
    private lateinit var binding : ActivityMainBinding
    private val myName : MyName = MyName("YASSER ALTAMIMI")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // here we're setting the layout using the data binding util
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // connect the data in my data class to the binding object
        binding.myName = myName

        doneBtnView.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View?) {
        myName?.nickname = nameEditTxtView.text.toString()

        // invalidate all binding expressions and requests a nre rebind to refresh
        invalidateAll()

        nameEditTxtView.visibility = View.GONE
        enterdNmeTxtView.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}
