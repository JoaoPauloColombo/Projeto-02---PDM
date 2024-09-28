package br.com.aula.text;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoIMC extends AppCompatActivity {

    private ImageView btnVoltar;
    private TextView textoPeso;
    private TextView textoAltura;
    private TextView resultadoImc;
    private TextView textoNome;
    private TextView textIMC;
    private TextView classificacaoIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_imc);

        // Inicializar as Views
        textoPeso = findViewById(R.id.textoPeso);
        textoAltura = findViewById(R.id.textoAltura);
        resultadoImc = findViewById(R.id.resultadoImc);
        textIMC = findViewById(R.id.textIMC);
        textoNome = findViewById(R.id.textoNome);
        classificacaoIMC = findViewById(R.id.valorClaIMC);

        // Receber os dados da Intent
        Intent intent = getIntent();
        String peso = intent.getStringExtra("peso");
        String altura = intent.getStringExtra("altura");
        String imc = intent.getStringExtra("imc");
        String nome = intent.getStringExtra("nome");
        String erro = intent.getStringExtra("erro");

        // Atualizar os TextViews com os dados recebidos
        textoPeso.setText(peso);
        textoAltura.setText(altura);
        textIMC.setText(imc);
        textoNome.setText(nome);

        if (erro != null) {
            textoPeso.setText("ERRO");
            textoAltura.setText(erro);
            textoPeso.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            textoAltura.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        } else {
            // Exibir os resultados aqui
            textIMC.setText("Seu IMC é:");
            resultadoImc.setText(imc);

            // Classificar o IMC
            double imcValue = Double.parseDouble(imc);
            if (imcValue < 18.5) {
                classificacaoIMC.setText("Baixo peso");
            } else if (imcValue >= 18.5 && imcValue < 25) {
                classificacaoIMC.setText("Peso normal");
            } else if (imcValue >= 25 && imcValue < 30) {
                classificacaoIMC.setText("Sobrepeso");
            } else if (imcValue >= 30 && imcValue < 35) {
                classificacaoIMC.setText("Obesidade grau 1");
            } else if (imcValue >= 35 && imcValue < 40) {
                classificacaoIMC.setText("Obesidade grau 2");
            } else {
                classificacaoIMC.setText("Obesidade extrema");
            }
        }

        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(view -> {
            Intent voltarIntent = new Intent(ResultadoIMC.this, MainActivity.class);
            startActivity(voltarIntent);
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}