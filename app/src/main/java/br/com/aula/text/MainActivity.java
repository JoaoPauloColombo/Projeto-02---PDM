package br.com.aula.text;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ImageView btnVoltar;
    private Button btnResultado;
    private TextInputEditText inputPeso;
    private TextInputEditText inputAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializando os campos de input com findViewById
        inputPeso = findViewById(R.id.textInputEditPeso);
        inputAltura = findViewById(R.id.textInputEditAltura);
        btnResultado = findViewById(R.id.btnResultado);

        Intent inte = getIntent();
        String nome = inte.getStringExtra("nome");


        // Configurando o clique no botão de resultado
        // Configurando o clique no botão de resultado
        btnResultado.setOnClickListener(view -> {
            String peso = inputPeso.getText() != null ? inputPeso.getText().toString() : "";
            String altura = inputAltura.getText() != null ? inputAltura.getText().toString() : "";

            Intent intent = null;
            try {
                double pesoValue = Double.parseDouble(peso);
                double alturaValue = Double.parseDouble(altura);
                double imc = pesoValue / (alturaValue * alturaValue);

                DecimalFormat df = new DecimalFormat("#.##");
                String imcFormatado = df.format(imc);

                // Enviando os dados para a página de resultado
                intent = new Intent(MainActivity.this, ResultadoIMC.class);
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", imcFormatado);
                intent.putExtra("nome", nome);

                startActivity(intent);

            } catch (Exception e) {
                TextView erroTextView = findViewById(R.id.erroTextView);
                erroTextView.setText("ENTRADA INVÁLIDA");
                erroTextView.setTextColor(Color.RED);
                erroTextView.setVisibility(View.VISIBLE);
            }
        });

        // Implementação do botão de voltar
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> {
            Intent voltarIntent = new Intent(MainActivity.this, Login.class);
            startActivity(voltarIntent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void limpar(View view) {
        TextInputEditText inputPeso = findViewById(R.id.textInputEditPeso);
        TextInputEditText inputAltura = findViewById(R.id.textInputEditAltura);
        inputPeso.setText("");
        inputAltura.setText("");
        TextView erroTextView = findViewById(R.id.erroTextView);
        erroTextView.setVisibility(View.GONE);
    }
}