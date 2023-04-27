package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.proyecto.databinding.ActivityPasswordRecoveryBinding
import com.google.firebase.auth.FirebaseAuth

class PasswordRecoveryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recoveryButton.setOnClickListener(){
            sendData()
        }
    }


    private fun sendData(){
        val email = binding.emailText.text.toString()

        if(!TextUtils.isEmpty(email)){
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener(this){
                task ->

                if(task.isSuccessful){
                    startActivity(Intent(this, AuthActivity::class.java))
                }else{
                    Toast.makeText(this, "Error al intentar recuperar la contraseña", Toast.LENGTH_LONG).show()
                }

            }
        }

    }
}
