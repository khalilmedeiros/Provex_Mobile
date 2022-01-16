package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.ufam.icomp.provex.Questao;
import br.edu.ufam.icomp.provex.QuestaoDAO;
import br.edu.ufam.icomp.provex.R;

public class GerarSimuladoActivity extends AppCompatActivity {
    private String Cargo;
    private QuestaoDAO questaoDAO;
    private ArrayList<Questao>questoes = new ArrayList<Questao>();
    private ArrayList<Integer>ids;
    ArrayList<ArrayList<Questao>> aux = new ArrayList<ArrayList<Questao>>();
    private TextView Questao1,Questao2,Questao3,Questao4,Questao5,
    Resp1,Resp2,Resp3,Resp4,Resp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_simulado);
        Questao1 = findViewById(R.id.texto1);
        Questao2 = findViewById(R.id.texto2);
        Questao3= findViewById(R.id.texto3);
        Questao4 = findViewById(R.id.texto4);
        Questao5 = findViewById(R.id.texto5);
        Resp1 = findViewById(R.id.resposta1);
        Resp2 = findViewById(R.id.resposta2);
        Resp3 = findViewById(R.id.resposta3);
        Resp4 = findViewById(R.id.resposta4);
        Resp5 = findViewById(R.id.resposta5);
        Cargo = getIntent().getStringExtra("Cargo");
        questaoDAO= new QuestaoDAO(this);
        ids=questaoDAO.getProvasID(Cargo);
       for(int i=0;i<ids.size();i++){
           aux.add(questaoDAO.getList(ids.get(i)));
        }
       for(int i =0;i<ids.size();i++){
           questoes.addAll(aux.get(i));
        }
        Collections.shuffle(questoes);
        Questao1.setText("1-"+questoes.get(0).QuestaoCompleta());
        Questao2.setText("2-"+questoes.get(1).QuestaoCompleta());
        Questao3.setText("3-"+questoes.get(2).QuestaoCompleta());
        Questao4.setText("4-"+questoes.get(3).QuestaoCompleta());
        Questao5.setText("5-"+questoes.get(4).QuestaoCompleta());

    }

    public void CorrigirClick(View view){
        if(Resp1.getText().toString().charAt(0)==questoes.get(0).getLetraCorreta()){
            Resp1.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            Resp1.setBackgroundColor(Color.rgb(255,0,0));
        }
        if(Resp2.getText().toString().charAt(0)==questoes.get(1).getLetraCorreta()){
            Resp2.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            Resp2.setBackgroundColor(Color.rgb(255,0,0));
        }
        if(Resp3.getText().toString().charAt(0)==questoes.get(2).getLetraCorreta()){
            Resp3.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            Resp3.setBackgroundColor(Color.rgb(255,0,0));
        }
        if(Resp4.getText().toString().charAt(0)==questoes.get(3).getLetraCorreta()){
            Resp4.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            Resp4.setBackgroundColor(Color.rgb(255,0,0));
        }
        if(Resp5.getText().toString().charAt(0)==questoes.get(4).getLetraCorreta()){
            Resp5.setBackgroundColor(Color.rgb(0,255,0));
        }else{
            Resp5.setBackgroundColor(Color.rgb(255,0,0));
        }

    }
}