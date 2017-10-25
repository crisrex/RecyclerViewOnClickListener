package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 23/10/2017.
 */

public class CocheAdapter
        extends RecyclerView.Adapter<CocheAdapter.CocheViewHolder> {

    /*Arraylist donde almaceno los datos que se van a mostrar en el RecylerView*/
    private ArrayList<Coche> datos;
    /*Defino listener como objeto de la clase OnItemClickListener*/
    private final OnItemClickListener listener;


    /* Defino un interface con el OnItemClickListener*/
    public interface OnItemClickListener {
        void onItemClick(Coche item);
    }


    /* Incluyo el Viewholder en el Adapter */
    public static class CocheViewHolder
            extends RecyclerView.ViewHolder {
        /* Como atributos se incluyen los elementos que van a referenciar a los elementos de la vista*/
        private TextView tvModelo;
        private TextView tvMatricula;

        /*constructor con parámetro de la vista*/
        public CocheViewHolder(View itemView) {
            super(itemView);
            // Asocia los atributos a los widgets del layout de la vista
            tvModelo = (TextView)itemView.findViewById(R.id.tvModelo);
            tvMatricula = (TextView)itemView.findViewById(R.id.tvMatricula);
        }

        /*Muestra los datos de coche en el item*/
        public void bindCoche(final Coche coche, final OnItemClickListener listener) {
            tvModelo.setText(coche.getModelo());
            tvMatricula.setText(coche.getMatricula());
            /* Coloco el listener a la vista*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(coche);
                }
            });
        }
    }


    /* Constructor con parámetros*/
    public CocheAdapter(ArrayList<Coche> datos, OnItemClickListener listener) {

        this.datos = datos;
        this.listener = listener;

    }

    @Override
    public CocheViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        /*Crea la vista de un item y la "pinta"*/
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_coche, viewGroup, false);
        /* Crea un objeto de la clase CocheViewHolder, pasándole la vista anteriormente creada*/
        CocheViewHolder cocheVH = new CocheViewHolder(itemView);
        /* devuelve la vissta*/
        return cocheVH;
    }

    @Override
    public void onBindViewHolder(CocheViewHolder viewHolder, int pos) {
        Coche coche = datos.get(pos);
        /* Llama a bindCoche, para que "pinte" los datos del coche que se le pasa como parámetro*/
        viewHolder.bindCoche(coche,listener);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
