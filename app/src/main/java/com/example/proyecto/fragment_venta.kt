package com.example.proyecto

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import java.util.*


class fragment_venta : Fragment(), AdapterView.OnItemClickListener {

    //private lateinit var arrayTamaño: ArrayAdapter<String>
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

        //codigo para el spinner tamaño de productos
        val lista = listOf("Pequeño","Mediano","Grande")
        var spinnerT: Spinner =view.findViewById(R.id.tamañoP)

        val adaptador = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,lista )

        spinnerT.adapter=adaptador
        spinnerT.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val itemsel= spinnerT.selectedItem.toString()
                val itemposi = spinnerT.selectedItemPosition.toString()
                Toast.makeText(requireContext(),itemsel,Toast.LENGTH_SHORT).show()
                println(itemsel)
                println(itemposi)
                Toast.makeText(requireContext(),itemposi,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        //codigo para el spinner de tipo de pago
        val listapago = listOf("Efectivo","Transaccion","Tarjeta")
        var spinnerP: Spinner =view.findViewById(R.id.tipoPago)
        val adaptadorP = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,listapago )

        spinnerP.adapter=adaptadorP
        spinnerP.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val itemPago= spinnerP.selectedItem.toString()
                val itemposiP = spinnerP.selectedItemPosition.toString()
                Toast.makeText(requireContext(),itemPago,Toast.LENGTH_SHORT).show()
                println(itemPago)
                println(itemposiP)
                Toast.makeText(requireContext(),itemposiP,Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }





//        arrayTamaño.addAll(Arrays.asList("Pequeño","Mediano"))
//
//
//        arrayTamaño.addAll(Arrays.asList("Pequeño","Mediano"))
//        //arrayTamaño.add("Pequeño")
//        //arrayTamaño.add("Mediano")
//        arrayTamaño.add("Grande")
//        spinnerT.adapter=arrayTamaño


        return view
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//        val itemselect = arrayTamaño.getItemId(position)
//        Toast.makeText(context,itemselect.toString(), Toast.LENGTH_SHORT).show()
    }
}