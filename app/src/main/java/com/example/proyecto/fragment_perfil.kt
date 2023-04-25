package com.example.proyecto

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentPerfilBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class fragment_perfil : Fragment(R.layout.fragment_perfil) {

    private lateinit var binding: FragmentPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAbout = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        // Get arguments from bundle
        val email = arguments?.getString("email") ?: ""
        val provider = arguments?.getString("provider") ?: ""


        // Set text views
        binding.emailTextView.text = email
        binding.providerTextView.text = provider

        // Log out button
        binding.logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            //Erasing the data and showing the login activity (AuthActivity)
            val prefs = requireContext().getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            showLogin()
        }

    }

    private fun showLogin () {
        val intent = Intent(requireContext(), AuthActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}

