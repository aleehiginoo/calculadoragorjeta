package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // objetos formatadores de moeda:
    private static final NumberFormat currencyFormat =  NumberFormat.getCurrencyInstance();

    private double vlrConta = 0.0; // valor da conta inserida pelo usuario
    private double percent = 15; // porcentagem inicial da gorjeta
    private TextView valorContaTextView; // mostra o valor da conta
    private TextView valorGorjetaTextView; // mostra o valor da gorjeta
    private TextView valorTotalTextView; // mostra o valor total da conta calculada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter referencias para o TextView manipulados via programação
        valorContaTextView = (TextView)findViewById(R.id.valorConta);
        valorTotalTextView = (TextView)findViewById(R.id.valorTotal);
        valorGorjetaTextView = (TextView)findViewById(R.id.valorGorjeta);

        // zerando exibições na tela
        valorTotalTextView.setText(currencyFormat.format(0));
        valorGorjetaTextView.setText(currencyFormat.format(0));

        // configura o receptor TextWatcher de valorContaTextView
        EditText valorContaEditText = (EditText) findViewById(R.id.valorConta);
        valorContaEditText.addTextChangedListener(valorContaEditWatcher);

        // configura o receptor OnSeekBarChangeListener de porcentagemBar
        SeekBar percentSeekBar = (SeekBar)findViewById(R.id.porcentagemBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }



    private final TextWatcher valorContaEditWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            vlrConta = Double.parseDouble(s.toString());
            valorTotalTextView.setText(currencyFormat.format(vlrConta));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void calcular(){
        try{
            double gorjeta = vlrConta * percent;
            double total = vlrConta + gorjeta;
            valorTotalTextView.setText(currencyFormat.format(total));
            valorGorjetaTextView.setText(currencyFormat.format(gorjeta));
        } catch (Exception ex){
            String y = ex.getMessage();
        }
    }

    private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0;
            calcular();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}