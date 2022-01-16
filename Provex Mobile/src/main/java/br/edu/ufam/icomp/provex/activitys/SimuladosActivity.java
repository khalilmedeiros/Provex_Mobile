package br.edu.ufam.icomp.provex.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import br.edu.ufam.icomp.provex.R;

public class SimuladosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SimuladosAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulados);
        recyclerView =findViewById(R.id.list_simulados);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimuladosAdapter(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }


}