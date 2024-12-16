package com.example.precafeteria.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CafeteriaViewModel : ViewModel() {
    private var _menuClient = MutableLiveData<CafeteriaModel>()
    val menuClient: LiveData<CafeteriaModel> = _menuClient

    fun addPlato(cantidadPlatos: Int){
        _menuClient.value = CafeteriaModel(cantidadPlatos, 0, 0.0, 0.0)
    }

    fun addBebidas(cantidadBebidas: Int){
        _menuClient.value?.bebida = (cantidadBebidas)

        _menuClient.value?.precioPlato = 10.0
        _menuClient.value?.preuBegudes = 10.0

    }
}