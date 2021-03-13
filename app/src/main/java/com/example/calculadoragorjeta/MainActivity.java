package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // objetos formatadores de moeda:
    private static final NumberFormat currencyFormat =  NumberFormat.getCurrencyInstance();

    private double vlrConta = 0.0; // valor da conta inserida pelo usuario
    private double percent = 15; // porcentagem inicial da gorjeta
    private TextView valorContaTextView; // mostra o valor da conta
    private TextView valorTotalTextView; // mostra o valor total da conta calculada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter referencias para o TextView manipulados via programação
        valorContaTextView = (TextView)findViewById(R.id.valorConta);
    }
}