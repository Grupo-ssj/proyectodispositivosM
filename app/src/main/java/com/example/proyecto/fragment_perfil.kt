package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import com.example.proyecto.databinding.FragmentPerfilBinding
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

        // Get arguments from bundle
        val email = arguments?.getString("email") ?: ""
        val provider = arguments?.getString("provider") ?: ""

        // Set text views
        binding.emailTextView.text = email
        binding.providerTextView.text = provider

        // Log out button
        binding.logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            showLogin()
        }
    }

    private fun showLogin () {
        val intent = Intent(requireContext(), AuthActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}

