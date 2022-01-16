package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.edu.ufam.icomp.provex.R;

public class QuestoesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuestoesAdapter adapter;
    int provaID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes);
        recyclerView = findViewById(R.id.list_questoes);
        provaID = getIntent().getIntExtra("provaID",-1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuestoesAdapter(this,provaID);

        recyclerView.setAdapter(adapter);
    }
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }

    public void addQuestaoClick(View view){
        Intent intent = new Intent(this, EditQuestaoActivity.class);
        intent.putExtra("provaID",provaID);
        startActivity(intent);
    }
}