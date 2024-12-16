package com.example.precafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.precafeteria.ViewModel.CafeteriaViewModel
import com.example.precafeteria.databinding.FragmentPlatosBinding

class platos : Fragment() {
    private val viewModel: CafeteriaViewModel by activityViewModels<CafeteriaViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPlatosBinding.inflate(inflater)

        binding.botonplatos?.setOnClickListener {
            val cantidadPlato = binding.textoplatos.text.toString()
            viewModel.addPlato(cantidadPlato.toString().toInt())
            findNavController().navigate(R.id.action_platos_to_bebidas, null)
        }
        return binding.root
    }

}