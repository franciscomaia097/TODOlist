package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper {
    // Variaveis estáticas
    // Versão da base de daos
    private static final int VERSAO_BD = 1;

    // Nome da base dado
    private static final String NOME_BD = "GestTarefas";

    // Nome da Tabela
    private static final String TABELA_TAREFAS = "tarefas";

    // Nome das colunas da tabela contactos
    private static final String KEY_ID = "id_tarefa";
    private static final String KEY_TITULO = "titulo";
    private static final String KEY_DESCRICAO = "descricao";
    private static final String KEY_DATA = "data";
    private static final String KEY_STATUS = "status";

    public dbHandler(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    //Cria a tabela na base de dados
    @Override
    public void onCreate(SQLiteDatabase bd) {
        String CRIAR_TABELA_TAREFAS = "CREATE TABLE " + TABELA_TAREFAS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_TITULO + " TEXT," + KEY_DESCRICAO + " TEXT," + KEY_DATA + " TEXT," + KEY_STATUS + " INTEGER)";
        bd.execSQL(CRIAR_TABELA_TAREFAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        //Drops table if exists
        bd.execSQL("DROP TABLE IF EXISTS " + TABELA_TAREFAS);

        //Create table again
        onCreate(bd);
    }

    //adiciona nova tarefa
    public boolean adicionarTarefa(Tarefa tarefa) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITULO, tarefa.getTitulo());
        values.put(KEY_DESCRICAO, tarefa.getDescricao());
        values.put(KEY_DATA, tarefa.getData());
        values.put(KEY_STATUS, tarefa.getStatus());

        //Inserting Row
        long result = bd.insert(TABELA_TAREFAS, null, values);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //apaga uma tarefa
    public void apagarTarefa(Tarefa tarefa) {
        SQLiteDatabase bd = this.getWritableDatabase();

        bd.delete(TABELA_TAREFAS, KEY_ID + " = ?", new String[] {String.valueOf(tarefa.getIdTarefa())});
        bd.close();
    }

    //atualiza uma tarefa
    public int atualizarTarefa(Tarefa tarefa) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITULO, tarefa.getTitulo());
        values.put(KEY_DESCRICAO, tarefa.getDescricao());
        values.put(KEY_DATA, tarefa.getData());
        values.put(KEY_STATUS, tarefa.getStatus());

        //updating row
        return bd.update(TABELA_TAREFAS, values, KEY_ID + " = ?", new String[] {String.valueOf(tarefa.getIdTarefa())});
    }

    //all tarefas to arraylist
    public ArrayList<Tarefa> getAllTarefasArrayList() {
        ArrayList<Tarefa> tarefaList = new ArrayList<Tarefa>();

        //Select all query
        String selectQuery = "SELECT * FROM " + TABELA_TAREFAS;

        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursor = bd.rawQuery(selectQuery, null);

        //looping through all rows and adding to list
        if(cursor.moveToFirst()) {
            do {
                Tarefa tarefa = new Tarefa();
                tarefa.setIdTarefa(String.valueOf(Integer.parseInt(cursor.getString(0))));
                tarefa.setTitulo(cursor.getString(1));
                tarefa.setDescricao(cursor.getString(2));
                tarefa.setData(cursor.getString(3));
                tarefa.setStatus(Integer.parseInt(cursor.getString(4)));

                //adding contact to list
                tarefaList.add(tarefa);
            } while (cursor.moveToNext());
        }

        //return contact list
        return tarefaList;
    }


}
