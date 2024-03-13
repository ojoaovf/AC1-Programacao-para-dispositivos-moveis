package com.example.ac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumberDog1, editTextNumberDog2, editTextNumberDog3,editTextNumberAcompanhamento1,editTextNumberAcompanhamento2,editTextNumberAcompanhamento3,editTextNumberBebida1, editTextNumberBebida2, editTextNumberBebida3;
    TextView textViewValorTotal;
    Button buttonCalcular, buttonLimpar;

    float precoDog1 = 10.50f, precoDog2 = 14.50f, precoDog3 = 16f;
    float precoAcompanhamento1 = 10f, precoAcompanhamento2 = 8f, precoAcompanhamento3 = 15f;
    float precoBebida1 = 4, precoBebida2 = 6f, precoBebida3 = 10f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumberDog1 =  findViewById(R.id.editTextNumberDog1);
        editTextNumberDog2 =  findViewById(R.id.editTextNumberDog2);
        editTextNumberDog3 =  findViewById(R.id.editTextNumberDog3);
        editTextNumberAcompanhamento1 =  findViewById(R.id.editTextNumberAcompanhamento1);
        editTextNumberAcompanhamento2 =  findViewById(R.id.editTextNumberAcompanhamento2);
        editTextNumberAcompanhamento3 =  findViewById(R.id.editTextNumberAcompanhamento3);
        editTextNumberBebida1 =  findViewById(R.id.editTextNumberBebida1);
        editTextNumberBebida2 =  findViewById(R.id.editTextNumberBebida2);
        editTextNumberBebida3 =  findViewById(R.id.editTextNumberBebida3);

        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpar = findViewById(R.id.buttonLimpar);

        textViewValorTotal = findViewById(R.id.textViewValorTotal);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void calcularTotal() {
        try {
            int quantidadeDog1 = parseInputValue(editTextNumberDog1.getText().toString());
            int quantidadeDog2 = parseInputValue(editTextNumberDog2.getText().toString());
            int quantidadeDog3 = parseInputValue(editTextNumberDog3.getText().toString());
            int quantidadeAcompanhamento1 = parseInputValue(editTextNumberAcompanhamento1.getText().toString());
            int quantidadeAcompanhamento2 = parseInputValue(editTextNumberAcompanhamento2.getText().toString());
            int quantidadeAcompanhamento3 = parseInputValue(editTextNumberAcompanhamento3.getText().toString());
            int quantidadeBebida1 = parseInputValue(editTextNumberBebida1.getText().toString());
            int quantidadeBebida2 = parseInputValue(editTextNumberBebida2.getText().toString());
            int quantidadeBebida3 = parseInputValue(editTextNumberBebida3.getText().toString());

            double total = quantidadeDog1 * precoDog1 + quantidadeDog2 * precoDog2 + quantidadeDog3 * precoDog3
                    + quantidadeAcompanhamento1 * precoAcompanhamento1 + quantidadeAcompanhamento2 * precoAcompanhamento2 + quantidadeAcompanhamento3 * precoAcompanhamento3
                    + quantidadeBebida1 * precoBebida1 + quantidadeBebida2 * precoBebida2 + quantidadeBebida3 * precoBebida3;

            textViewValorTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, insira uma quantidade válida!!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        editTextNumberDog1.setText("");
        editTextNumberDog2.setText("");
        editTextNumberDog3.setText("");
        editTextNumberAcompanhamento1.setText("");
        editTextNumberAcompanhamento2.setText("");
        editTextNumberAcompanhamento3.setText("");
        editTextNumberBebida1.setText("");
        editTextNumberBebida2.setText("");
        editTextNumberBebida3.setText("");
        textViewValorTotal.setText(String.valueOf("$$"));
    }
    public int parseInputValue(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(string);
        }
    }

}


