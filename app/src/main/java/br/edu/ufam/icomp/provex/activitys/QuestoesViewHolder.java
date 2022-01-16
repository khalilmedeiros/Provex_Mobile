package br.edu.ufam.icomp.provex.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ufam.icomp.provex.R;

public class QuestoesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public TextView descricao;
    public int id,provaID;


    public QuestoesViewHolder(ConstraintLayout v, Context context){
        super(v);
        this.context=context;
        descricao=v.findViewById(R.id.descricaoQuestao);
        v.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, EditQuestaoActivity.class);
        intent.putExtra("questaoID",this.id);
        intent.putExtra("provaID",this.provaID);

        context.startActivity(intent);
    }

}
