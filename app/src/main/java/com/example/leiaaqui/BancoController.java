package com.example.leiaaqui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDadosCatLeitores(String DIAS_LEITORES, String DESCRICAO_LEITORES){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getDiasLeitores(), DIAS_LEITORES);
        valores.put(CriaBanco.getDescricaoLeitores(), DESCRICAO_LEITORES);
        resultado = db.insert(CriaBanco.getTabelaLeitores(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosCatLeitores(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLeitores(),CriaBanco.getDiasLeitores()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLeitores(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


}