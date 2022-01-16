package br.edu.ufam.icomp.provex.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ufam.icomp.provex.R;

public class ProvasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public TextView descricao, cargo;
    public int id;

    public ProvasViewHolder(ConstraintLayout v, Context context) {
        super(v);
        this.context= context;
        descricao=v.findViewById(R.id.descricao);
        cargo=v.findViewById(R.id.nomeCargo);
        v.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = new Intent(context, EditProvaActivity.class);
        intent.putExtra("IDprova",this.id);
        context.startActivity(intent);
    }

}
