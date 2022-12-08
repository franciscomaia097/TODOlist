package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        dbHandler db = new dbHandler(this);

        ArrayList<Tarefa> listaTarefas = db.getAllTarefasArrayList();


        TarefaListAdaptar adapter = new TarefaListAdaptar(this, R.layout.adapter_view_layout, listaTarefas);



        listView.setAdapter(adapter);

        Button btnAdicionar = findViewById(R.id.button4);
        Intent AdicionarTarefa = new Intent(this, AdicionarTarefa.class);



        btnAdicionar.setOnClickListener(v -> {
            startActivity(AdicionarTarefa);
        });
    }
}