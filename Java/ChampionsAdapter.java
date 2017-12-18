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

    /*****************************************/

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;
        public ImageView icon;



        public ViewHolder(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.textoRec);
            icon = (ImageView) itemView.findViewById(R.id.fotoRec);
        }
    }

    /****************************************/

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

        viewHolder.icon.setImageResource(R.mipmap.ic_launcher);
        viewHolder.nombre.setText(mChampions.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mChampions.size();
    }
}
