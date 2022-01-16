package br.edu.ufam.icomp.provex.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.ufam.icomp.provex.R;

public class SimuladosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public TextView editCargo;
    String cargo;
    public SimuladosViewHolder(ConstraintLayout v,Context context) {
        super(v);
        this.context=context;
        editCargo=v.findViewById(R.id.editCargo2);
        v.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, GerarSimuladoActivity.class);
        intent.putExtra("Cargo",this.cargo);
        context.startActivity(intent);
    }
}
