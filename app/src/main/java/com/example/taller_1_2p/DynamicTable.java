package com.example.taller_1_2p;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;

public class DynamicTable {
    private TableLayout tabla;
    private Context context;
    private String[] cabecera;
    private ArrayList<String[]> datos;
    private TableRow fila;
    private TextView celda;

    // Colores (mismos que colors.xml)
    private final int COLOR_CABECERA = Color.parseColor("#3F51B5");
    private final int COLOR_FILA_PAR = Color.parseColor("#FFFFFF");
    private final int COLOR_FILA_IMPAR = Color.parseColor("#EEF0F8");
    private final int COLOR_TEXTO = Color.parseColor("#212121");

    public DynamicTable(TableLayout tabla, Context contexto){
        this.tabla = tabla;
        this.context = contexto;
    }

    public void setCabecera(String[] cabecera){
        this.cabecera = cabecera;
    }

    public void setDatos(ArrayList<String[]> datos){
        this.datos = datos;
    }

    private void nuevaFila(){
        fila = new TableRow(context);
    }

    private void nuevaCelda(){
        celda = new TextView(context);
        celda.setGravity(Gravity.CENTER);
        celda.setPadding(16, 20, 16, 20);
    }

    public void crearCabecera() {
        nuevaFila();
        for (String titulo : cabecera){
            nuevaCelda();
            celda.setText(titulo);
            celda.setTextSize(16);
            celda.setTextColor(Color.WHITE);
            celda.setTypeface(null, Typeface.BOLD);
            celda.setBackgroundColor(COLOR_CABECERA);
            fila.addView(celda, parametrosCelda());
        }
        tabla.addView(fila);
    }

    public void crearFilas(){
        int indice = 0;
        for (String[] datosfila : datos){
            nuevaFila();
            int colorFila = (indice % 2 == 0) ? COLOR_FILA_PAR : COLOR_FILA_IMPAR;
            for (String dato : datosfila){
                nuevaCelda();
                celda.setText(dato);
                celda.setTextSize(15);
                celda.setTextColor(COLOR_TEXTO);
                celda.setBackgroundColor(colorFila);
                fila.addView(celda, parametrosCelda());
            }
            tabla.addView(fila);
            indice++;
        }
    }

    private TableRow.LayoutParams parametrosCelda(){
        TableRow.LayoutParams parametros = new TableRow.LayoutParams();
        parametros.setMargins(1, 1, 1, 1);
        parametros.weight = 1;
        return parametros;
    }
}