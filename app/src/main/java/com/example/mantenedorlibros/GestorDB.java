package com.example.mantenedorlibros;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.google.android.material.tabs.TabLayout;

public class GestorDB  extends SQLiteOpenHelper{
    public static abstract class TablaDatos implements BaseColumns{
        public static final String NOMBRE_TABLA = "Libro";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_TITULO = "titulo";
        public static final String COLUMNA_AUTOR = "autor";

        public static final String TEXT_TYPE = "TEXT";
        public static final String COMMA_SEP = ",";
        public static final String CREAR_TABLA =
                "CREATE TABLE " + TablaDatos.NOMBRE_TABLA + " (" +
                    TablaDatos.COLUMNA_ID + " INTEGER PRIMARY KEY," +
                    TablaDatos.COLUMNA_TITULO + TEXT_TYPE + COMMA_SEP+
                    TablaDatos.COLUMNA_AUTOR + TEXT_TYPE + ")";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXIST " + TablaDatos.NOMBRE_TABLA;
    }
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="BaseLibro.db";

    public GestorDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TablaDatos.CREAR_TABLA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL((TablaDatos.SQL_DELETE_ENTRIES));
        onCreate(db);
    }

}
