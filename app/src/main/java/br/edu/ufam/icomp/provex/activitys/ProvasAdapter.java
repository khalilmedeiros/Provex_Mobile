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

public class ProvasAdapter extends RecyclerView.Adapter<ProvasViewHolder> {
    private final Context context;
    private ArrayList<Prova> provas;
    ProvaDAO provaDAO;

    public ProvasAdapter(Context context){
        this.context=context;
        provaDAO = new ProvaDAO(context);
        update();
    }

    public void update(){
        provas = provaDAO.getList();
    }

    @NonNull
    @Override
    public ProvasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_provas, parent, false);
        return new ProvasViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(ProvasViewHolder holder, int position) {
        holder.descricao.setText(provas.get(position).descricaoTexto1());
        holder.cargo.setText(provas.get(position).getCargo());
        holder.id = provas.get(position).getId();


    }

    @Override
    public int getItemCount() {
        return provas.size();
    }

}
