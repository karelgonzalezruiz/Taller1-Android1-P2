package com.example.taller_1_2p;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    private EditText txtId, txtNombre, txtApellido;
    private FeedReaderDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);

        dbHelper = new FeedReaderDBHelper(this);
    }

    public void Guardar(View vista) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.column1, txtNombre.getText().toString());
        values.put(FeedReaderContract.FeedEntry.column2, txtApellido.getText().toString());

        long newRowId = db.insert(FeedReaderContract.FeedEntry.nameTable, null, values);
        db.close();

        Toast.makeText(getApplicationContext(),
                "se guardo el registro: " + newRowId,
                Toast.LENGTH_LONG).show();
    }

    public void Actualizar(View vista) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String nombre = txtNombre.getText().toString();
        String apellido = txtApellido.getText().toString();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.column1, nombre);
        values.put(FeedReaderContract.FeedEntry.column2, apellido);

        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = {txtId.getText().toString()};

        int count = db.update(FeedReaderContract.FeedEntry.nameTable,
                values,
                selection,
                selectionArgs);
        Toast.makeText(getApplicationContext(),
                "se actualizo " + count + " registro(s)",
                Toast.LENGTH_LONG).show();
        db.close();
    }

    public void Buscar(View vista) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                FeedReaderContract.FeedEntry.column1,
                FeedReaderContract.FeedEntry.column2
        };

        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = {txtId.getText().toString()};
        String sortOrder = FeedReaderContract.FeedEntry.column2 + " ASC";

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.nameTable,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        while (cursor.moveToNext()) {
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.column1));
            txtNombre.setText(nombre + "");
            String apellido = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.column2));
            txtApellido.setText(apellido + "");
        }

        cursor.close();
        db.close();
    }

    public void Eliminar(View vista) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = {txtId.getText().toString()};

        int deletedRows = db.delete(FeedReaderContract.FeedEntry.nameTable, selection, selectionArgs);
        db.close();

        Toast.makeText(getApplicationContext(),
                "se elimino " + deletedRows + " registro(s)",
                Toast.LENGTH_LONG).show();
    }

    public void Listar(View vista) {
        Intent listar = new Intent(this, ListarActivity.class);
        startActivity(listar);
    }
}