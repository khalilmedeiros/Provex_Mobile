package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import br.edu.ufam.icomp.provex.Prova;
import br.edu.ufam.icomp.provex.Questao;
import br.edu.ufam.icomp.provex.QuestaoDAO;
import br.edu.ufam.icomp.provex.R;

public class EditQuestaoActivity extends AppCompatActivity {
    private QuestaoDAO questaoDAO;
    private int provaID,questaoID;
    private TextView editEnunciado, editAltA, editAltB, editAltC, editAltD,
            editAltE, editAltF, editAltCorreta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_questao);
        getSupportActionBar().hide();
         editEnunciado = findViewById(R.id.addEnunciado);
         editAltA=findViewById(R.id.addAltA);
         editAltB=findViewById(R.id.addAltB);
         editAltC=findViewById(R.id.addAltC);
         editAltD=findViewById(R.id.addAltD);
         editAltE=findViewById(R.id.addAltE);
         editAltF=findViewById(R.id.addAltF);
         editAltCorreta=findViewById(R.id.addAltCorreta);
         questaoDAO=new QuestaoDAO(this);
         questaoID= getIntent().getIntExtra("questaoID",-1);
         provaID = getIntent().getIntExtra("provaID",-1);
         if(questaoID!=-1){
             Questao questao = questaoDAO.get(questaoID);
             editEnunciado.setText(questao.getEnunciado());
             editAltA.setText(questao.getA());
             editAltB.setText(questao.getB());
             editAltC.setText(questao.getC());
             editAltD.setText(questao.getD());
             editAltE.setText(questao.getE());
             editAltF.setText(questao.getF());
             String correta=""+questao.getLetraCorreta();
             editAltCorreta.setText(correta);
         }
    }

    public void salvarClickado(View v){
        Questao questao = new Questao(questaoID,provaID,editEnunciado.getText().toString(),editAltA.getText().toString(),editAltB.getText().toString(),
                editAltC.getText().toString(),editAltD.getText().toString(),editAltE.getText().toString(),editAltF.getText().toString(),
                editAltCorreta.getText().charAt(0));
        boolean result;
        if(questaoID==-1) result = questaoDAO.add(questao);
        else            result = questaoDAO.update(questao);

        if(result) finish();
    }
    public void excluirClickado(View v){
        boolean result= questaoDAO.delete(questaoID);
        if(result) finish();
    }
}