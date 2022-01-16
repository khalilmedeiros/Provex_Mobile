package br.edu.ufam.icomp.provex.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ufam.icomp.provex.Prova;
import br.edu.ufam.icomp.provex.ProvaDAO;
import br.edu.ufam.icomp.provex.R;

public class SimuladosAdapter extends RecyclerView.Adapter<SimuladosViewHolder> {
    private Context context;
    private ArrayList<String>cargos;
    ProvaDAO provaDAO;
    public SimuladosAdapter(Context context){
        this.context=context;
        provaDAO=new ProvaDAO(context);
        update();
    }
    public void update(){
        cargos=provaDAO.getListCargos();
    }
    @NonNull
    @Override
    public SimuladosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_simulados, parent, false);
        return new SimuladosViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull SimuladosViewHolder holder, int position) {
        holder.editCargo.setText(cargos.get(position));
        holder.cargo=cargos.get(position);
    }

    @Override
    public int getItemCount() {
        return cargos.size();
    }
}
