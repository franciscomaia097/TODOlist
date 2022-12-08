package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;



public class TarefaListAdaptar extends ArrayAdapter<Tarefa> {
    private Context mContext;
    int mResource;

    public TarefaListAdaptar(Context context, int resource, ArrayList<Tarefa> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String titulo = getItem(position).getTitulo();
        String descricao = getItem(position).getDescricao();
        String data = getItem(position).getData();
        int status = getItem(position).getStatus();

        Tarefa tarefa = new Tarefa(titulo, descricao, data, status);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTitulo = convertView.findViewById(R.id.textView);
        TextView tvDescricao = convertView.findViewById(R.id.textView2);
        TextView tvData = convertView.findViewById(R.id.textView3);
        Switch Status = convertView.findViewById(R.id.switch1);

        tvTitulo.setText(titulo);
        tvDescricao.setText(descricao);
        tvData.setText(data);
        Status.setChecked(status == 1);

        return convertView;
    }
}

