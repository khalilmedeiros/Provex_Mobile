package br.edu.ufam.icomp.provex.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.ufam.icomp.provex.Questao;
import br.edu.ufam.icomp.provex.QuestaoDAO;
import br.edu.ufam.icomp.provex.R;

public class QuestoesAdapter extends RecyclerView.Adapter<QuestoesViewHolder> {
    private Context context;
    private ArrayList<Questao> questoes;
    QuestaoDAO questaoDAO;
    private int provaID;

    public QuestoesAdapter(Context context,int provaID){
        this.context=context;
        this.provaID=provaID;
        questaoDAO = new QuestaoDAO(context);
        update();
    }
    public void update(){
        questoes=questaoDAO.getList(provaID);
    }
    @NonNull
    @Override
    public QuestoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_questoes, parent, false);
        QuestoesViewHolder vh = new QuestoesViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestoesViewHolder holder, int position) {
        holder.descricao.setText(questoes.get(position).previa());
        holder.id = questoes.get(position).getQuestaoID();
        holder.provaID=provaID;
    }

    @Override
    public int getItemCount() {
        return questoes.size();
    }
}
