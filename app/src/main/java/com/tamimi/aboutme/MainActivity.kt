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
    // here we init the binding object and giving it a class of type(ActivityMainBinding) this class name is generated for us by using the name of the activity xml file and change it to camel case and add Binding at the end
    private lateinit var binding : ActivityMainBinding

    // here we init the data variable that we will be using to give data to the ui
    private val myName : MyName = MyName("YASSER ALTAMIMI")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // here we're setting the layout using the data binding util
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // connect the name data in my data class to the binding object
        // here we are giving it the whole object we created above so that we can extract information from it again
        binding.myName = myName

        doneBtnView.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View?) {

        // here we are taking the text entered in the edit text and assigning it to the object nickName
        binding.myName?.nickname = nameEditTxtView.text.toString()
        nickNameTxtView.visibility = View.VISIBLE
        nameEditTxtView.visibility = View.GONE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)

        // invalidate all binding expressions and requests a nre rebind to refresh
        binding.invalidateAll()
    }

}
