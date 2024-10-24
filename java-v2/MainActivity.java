package com.example.verificanotaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editNota;
    private TextView textResultado;
    private TextView msgError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa os elementos da interface
        editNome = findViewById(R.id.editNome);
        editNota = findViewById(R.id.editNota);
        textResultado = findViewById(R.id.textResultado);
        msgError = findViewById(R.id.msgError);

        // Configura o botão para calcular
        Button btnVerificarNota = findViewById(R.id.btnVerificarNota);
        btnVerificarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarNota(v);
            }
        });

        // Configura o botão para resetar os campos
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetarCampos();
            }
        });
    }

    // Método para verificar a nota do aluno
    private void verificarNota(View view) {
        String nome = editNome.getText().toString();
        String notaStr = editNota.getText().toString();

        // Resetar mensagens de erro e resultado
        msgError.setVisibility(View.GONE);
        textResultado.setText("");

        // Verificar se os campos estão preenchidos
        if (nome.isEmpty() || notaStr.isEmpty()) {
            msgError.setVisibility(View.VISIBLE);
            msgError.setText("Por favor, preencha todos os campos.");
            return;
        }

        // Tentar converter a nota para número
        try {
            double nota = Double.parseDouble(notaStr);

            // Verificar se a nota é válida
            if (nota < 0 || nota > 100) {
                msgError.setVisibility(View.VISIBLE);
                msgError.setText("Insira uma nota válida entre 0 e 100.");
                return;
            }

            // Verificar aprovação ou reprovação
            if (nota >= 60) {
                textResultado.setText("Aluno " + nome + " está APROVADO com nota " + nota);
                textResultado.setTextColor(getResources().getColor(R.color.green)); // Cor verde
            } else {
                textResultado.setText("Aluno " + nome + " está REPROVADO com nota " + nota);
                textResultado.setTextColor(getResources().getColor(R.color.red)); // Cor vermelha
            }

        } catch (NumberFormatException e) {
            msgError.setVisibility(View.VISIBLE);
            msgError.setText("Insira uma nota válida.");
        }
    }

    // Método para resetar os campos
    private void resetarCampos() {
        editNome.setText("");
        editNota.setText("");
        textResultado.setText("");
        msgError.setVisibility(View.GONE);
    }
}
