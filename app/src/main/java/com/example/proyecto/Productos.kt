package com.example.proyecto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.adapter.Adapter_Producto
import com.example.proyecto.model.Lista_Producto

class Productos : AppCompatActivity() {

    //lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.productos)

        val recycleView_productos = findViewById<RecyclerView>(R.id.recyclerView_Productos)
        recycleView_productos.layoutManager = LinearLayoutManager(this)
        recycleView_productos.setHasFixedSize(true)

        //uso configuracion
        val listaP : MutableList<Lista_Producto> = mutableListOf()
        val  adapterProducto = Adapter_Producto(this, listaP)
        recycleView_productos.adapter = adapterProducto




        // enlace de imagen a mostrar
        // https://images.app.goo.gl/9cEsuijdjModddfQ6

        //ejemplos de productos

//        val producto1 = Lista_Producto(
//            R.drawable.destornillador,
//            "Destirnillador cruz Truper",
//            "Destornillador  de la marca TRUPER, mango confortable",
//            " LPS: 67.00"
//
//        )
//        listaP.add(producto1)

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



}