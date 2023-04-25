package com.example.proyecto.adapter

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.R
import com.example.proyecto.model.Lista_Producto
import java.text.FieldPosition

class Adapter_Producto(private val context: Context,
                       private val onClickListener: (Lista_Producto)-> Unit,
                       private val productos: MutableList<Lista_Producto>):RecyclerView.Adapter<Adapter_Producto.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductoViewHolder{
        val itemLista = LayoutInflater.from(context).inflate(R.layout.lista_producto,parent, false)
        val holder = ProductoViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int){
//        holder.foto.setImageResource(productos[position].foto)
//        holder.nombre.text = productos[position].nombre
//        holder.descripcion.text = productos[position].descripcion
//        holder.precio.text = productos[position].precio
        val producto = productos[position]
        holder.bind(producto,onClickListener)
    }

    override fun getItemCount(): Int = productos.size

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foto = itemView.findViewById<ImageView>(R.id.foto_producto)
        val nombre = itemView.findViewById<TextView>(R.id.nombreProducto)
        val descripcion = itemView.findViewById<TextView>(R.id.descripcionProducto)
        val precio = itemView.findViewById<TextView>(R.id.precioProducto)

        fun bind(producto: Lista_Producto, onClickListener: (Lista_Producto)->Unit){
            Glide.with(foto.context).load(producto.foto).into(foto)
            nombre.text = producto.nombre
            descripcion.text = producto.descripcion
            precio.text = producto.precio
            itemView.setOnClickListener{onClickListener(producto)}
        }

    }

}