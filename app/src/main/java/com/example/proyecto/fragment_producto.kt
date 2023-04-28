package com.example.proyecto

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.adapter.Adapter_Producto
import com.example.proyecto.model.Lista_Producto


class fragment_producto : Fragment(R.layout.fragment_producto) {

    private lateinit var adapter: Adapter_Producto
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //intanciacion de datos
        val listaP : MutableList<Lista_Producto> = mutableListOf()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView_Producto)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        adapter = Adapter_Producto(requireContext(),{Lista_Producto-> getProduct(Lista_Producto)},listaP) //get lista producto
        recyclerView.adapter = adapter


        val producto1 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/07/Destornillador-phillips-1-Thrifty-3-16x4-STANLEY.jpg",
            "Destornillador cruz Truper",
            "Destornillador  de la marca TRUPER, mango confortable",
            " LPS: 67.00"

        )
        listaP.add(producto1)
        val producto2 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/06/clavo-p-concreto.jpg",
            "Clavo para Concreto",
            "Clavos para concreto de 1 a 4 pulgadas",
            " LPS: 6.00/12.00"

        )
        listaP.add(producto2)

        val producto3 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/06/TeePvc1.jpg",
            "T PVC ",
            "T de presion para agua para  de 1 a 4 pulgadas",
            " LPS: 6.00/100.00"

        )
        listaP.add(producto3)

        val producto4 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/06/CodoPVC1.jpg",
            "Codo PVC",
            "Codo de PVC para agua de 1 a 4 pulgadas",
            " LPS: 6.00/80.00"

        )
        listaP.add(producto4)
        val producto5 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/06/Tubo-pvc-1-2.jpg",
            "Tubo PVC",
            "Tubo de PVC para agua de 1 a 4 pulgadas",
            " LPS: 95.00/425.00"

        )
        listaP.add(producto5)
        val producto6 = Lista_Producto(
            "https://larealizaciongt.com/tienda/wp-content/uploads/2020/07/cement.jpg",
            "Cemento Pogreso UGC",
            "Cemento para construccion",
            " LPS: 190"

        )
        listaP.add(producto6)



    }
    fun getProduct(producto: Lista_Producto) {
        //creamos un bundle y pasamos al fragment de venta
        val bundle = Bundle()
        bundle.putString("nombre",producto.nombre)//debemos pasarle cada atributo que manejaremos
        bundle.putString("descripcion",producto.descripcion)
        bundle.putString("precio",producto.precio)
        bundle.putString("foto",producto.foto)
        val fragmentV = fragment_venta()

        fragmentV.arguments= bundle
        parentFragmentManager?.beginTransaction()?.replace(R.id.frame_container,fragmentV)?.commit()
//        parentFragmentManager.commit {
//            replace<fragment_venta>(R.id.frame_container)
//            setReorderingAllowed(true)
//            addToBackStack("principal")
//        }

    }
}