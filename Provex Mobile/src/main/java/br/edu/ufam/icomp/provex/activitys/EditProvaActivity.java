package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ufam.icomp.provex.Prova;
import br.edu.ufam.icomp.provex.ProvaDAO;
import br.edu.ufam.icomp.provex.R;

public class EditProvaActivity extends AppCompatActivity {
    private ProvaDAO provaDAO;
    private int provaId;
    private TextView editEmpresa, editOrgPub,editEstado,editAno,editNivel,editCargo;
    private Button buttonQuestoes;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prova);
        buttonQuestoes=findViewById(R.id.buttonQuestoes);
        editEmpresa = findViewById(R.id.editEmpresa);
        editOrgPub = findViewById(R.id.editOrgPub);
        editEstado=findViewById(R.id.editEstado);
        editAno=findViewById(R.id.editAno);
        editNivel=findViewById(R.id.editNivel);
        editCargo=findViewById(R.id.editcargo);
        provaDAO= new ProvaDAO(this);
        provaId = getIntent().getIntExtra("IDprova", -1);
        if(provaId==-1){
            buttonQuestoes.setClickable(false);
            buttonQuestoes.setBackgroundColor(0000);
        }
        if(provaId !=-1){
            Prova prova = provaDAO.get(provaId);
            editEmpresa.setText(prova.getNomeEmpresa());
            editOrgPub.setText(prova.getOrgaoPub());
            editEstado.setText(prova.getEstado());
            editAno.setText(Integer.toString(prova.getAnoProva()));
            editNivel.setText(prova.getNivel());
            editCargo.setText(prova.getCargo());

        }
    }
    public void salvarClickado(View v){
        Prova prova = new Prova(provaId,editEmpresa.getText().toString(),editOrgPub.getText().toString(),editEstado.getText().toString()
        ,Integer.parseInt(editAno.getText().toString()),editNivel.getText().toString(),editCargo.getText().toString());
        boolean result;
        if(provaId==-1) result = provaDAO.add(prova);
        else            result = provaDAO.update(prova);

        if(result) finish();
    }
    public void excluirClickado(View v){
       boolean result= provaDAO.delete(provaId);
       if(result) finish();
    }
    public void QuestoesClick(View v){
        Intent intent = new Intent(this,QuestoesActivity.class);
        intent.putExtra("provaID",provaId);
        startActivity(intent);
    }

}