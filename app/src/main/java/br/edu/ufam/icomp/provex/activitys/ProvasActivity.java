package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.edu.ufam.icomp.provex.R;

public class ProvasActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProvasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_provas);
        recyclerView = findViewById(R.id.list_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProvasAdapter(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }

    public void addProvaClick(View view){
        Intent intent = new Intent(this, EditProvaActivity.class);
        startActivity(intent);
    }

}