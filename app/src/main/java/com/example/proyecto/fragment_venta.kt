package com.example.proyecto

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class fragment_venta : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_venta, container, false)
        val view = inflater.inflate(R.layout.fragment_venta, container, false)
        val textNombre : TextView  = view.findViewById(R.id.text_nombreProducto) //nombre del componente
        val textPrecio : TextView  = view.findViewById(R.id.text_precioP)
        val textDescripcion : TextView  = view.findViewById(R.id.text_descripcionP)
        val imageView : ImageView  = view.findViewById(R.id.foto_productoV)


        val args = this.arguments
        val nombre  = args?.get("nombre")
        val descripcion  = args?.get("descripcion")
        val precio  = args?.get("precio")
        val foto  = args?.get("foto")
        textNombre.text = nombre.toString() //asignamos el valor al componente
        textPrecio.text = precio.toString()
        textDescripcion.text = descripcion.toString()

        Glide.with(view.context).load(foto).into(imageView)

        println(nombre.toString())  // para probar si se paso el dato
        return view
    }

}