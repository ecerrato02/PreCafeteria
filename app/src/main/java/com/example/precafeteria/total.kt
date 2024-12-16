package com.example.precafeteria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.precafeteria.ViewModel.CafeteriaViewModel
import com.example.precafeteria.databinding.FragmentTotalBinding

class total : Fragment() {

    private val viewModel: CafeteriaViewModel by activityViewModels<CafeteriaViewModel>()
    private lateinit var binding: FragmentTotalBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTotalBinding.inflate(inflater)

        viewModel.menuClient.observe(viewLifecycleOwner) {menu ->
            binding.numeroplato.text = "${menu.plato}"
            binding.numerobebida.text = "${menu.bebida}"

            var precioplatos = 0.0
            var preciobebidas = 0.0

            if(menu.plato > 10){
                precioplatos = menu.precioPlato * menu.plato * 0.95
            }else{
                precioplatos = menu.precioPlato * menu.plato
            }

            binding.precio1.text = "${precioplatos.toString()}€"

            if(menu.bebida > 10){
                preciobebidas = menu.preuBegudes * menu.preuBegudes * 0.95

            }else{
                preciobebidas = menu.preuBegudes * menu.bebida
            }

            binding.precio2.text = "${preciobebidas.toString()}€"
            binding.numerototal.text = "${precioplatos + preciobebidas}€"

        }
        return binding.root
    }
}