package com.example.tipoprueba.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tipoprueba.R
import com.example.tipoprueba.databinding.FragmentContactBinding
import com.example.tipoprueba.viewModels.ContactViewModel


class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
    private val contactViewModel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
      _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactViewModel.contacts.observe(viewLifecycleOwner, Observer { result ->
            result.fold(
                onSuccess = {
                    println("Contactos: ${it.results}")
                },
                onFailure = { exception ->
                    println("Error: ${exception}")
                }
            )
        })
    }


}