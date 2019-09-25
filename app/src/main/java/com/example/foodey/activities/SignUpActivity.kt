package com.example.foodey.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.foodey.R
import com.example.foodey.util.obtainViewModel
import com.example.foodey.viewmodel.SignupVM
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpVM: SignupVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initVar()

        initView()

    }

    private fun initVar() {
        signUpVM = obtainViewModel(SignupVM::class.java)
    }

    private fun initView() {
        observeAndUpdateView()

        signUpVM.toastMsg.observe(this, Observer {msg->
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        })

        handleButton()
    }

    private fun observeAndUpdateView() {
        signUpVM.name.observe(this, Observer { name ->
            // Update the view
            evName.setText(name)
        })
        signUpVM.mobile.observe(this, Observer { mobile ->
            // Update the view
            evMobile.setText(mobile)
        })
        signUpVM.password.observe(this, Observer { pw ->
            // Update the view
            evPassword.setText(pw)
        })
        signUpVM.isDataLoading.observe(this, Observer { toShowProgressBar ->
            // Update the view
            if (toShowProgressBar) {

            } else {

            }
        })
    }

    private fun handleButton() {
        btnRegister.setOnClickListener {
            signUpVM.register()
        }
    }

}
