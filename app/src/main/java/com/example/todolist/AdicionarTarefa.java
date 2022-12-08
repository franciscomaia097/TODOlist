package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarTarefa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);


        EditText titulo = findViewById(R.id.editTextTitulo);
        EditText data = findViewById(R.id.editTextDate);
        EditText descricao = findViewById(R.id.editTextDescrição);

        dbHandler db = new dbHandler(this);


        Intent voltar = new Intent(this, MainActivity.class);


        Button adicionarTarefaBt = findViewById(R.id.button3);

        adicionarTarefaBt.setOnClickListener(v -> {
            String tituloTarefa = titulo.getText().toString();
            String dataTarefa = data.getText().toString();
            String descricaoTarefa = descricao.getText().toString();
            Tarefa tarefa1 = new Tarefa(tituloTarefa, dataTarefa, descricaoTarefa, 0);
            db.adicionarTarefa(tarefa1);
            startActivity(voltar);

        });

        Button voltarBt = findViewById(R.id.button5);
        voltarBt.setOnClickListener(v -> {
            startActivity(voltar);
        });

        };
    }
