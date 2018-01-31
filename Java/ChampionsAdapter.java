package com.example.eag.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jlram on 16/12/2017.
 */

public class ChampionsAdapter extends RecyclerView.Adapter<ChampionsAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        /*
         * En mi recyclerview se mostrara un textview con la informacion del campeon
         * y una foto en funcion a si esta disponible el cofre de bonificacion.
        */
        public TextView nombre;
        public ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.textoRec);
            icon = (ImageView) itemView.findViewById(R.id.fotoRec);
        }
    }

    List <Champion> mChampions;



    public ChampionsAdapter(List<Champion> mChampions) {
        this.mChampions = mChampions;

    }

    @Override
    public ChampionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View championView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(championView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChampionsAdapter.ViewHolder viewHolder, int position) {
        /*Comprobante del valor chest para asignar una fotografia u otra.*/
        if (mChampions.get(position).isChest() == true) {
            viewHolder.icon.setImageResource(R.drawable.chest_true);
        } else {
            viewHolder.icon.setImageResource(R.drawable.chest_false);
        }
        /*Asignacion de los valores de cada campeon a cada elemento del recycler view*/
        viewHolder.nombre.setText(mChampions.get(position).getName() + " " +mChampions.get(position).getId() + "\nLevel: " + mChampions.get(position).getLevel()
                                    + "\n Mastery Points: " + mChampions.get(position).getPoints());

    }

    @Override
    public int getItemCount() {
        return mChampions.size();
    }
}
