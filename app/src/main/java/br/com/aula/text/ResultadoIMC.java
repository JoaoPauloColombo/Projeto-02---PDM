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

import org.w3c.dom.Text;

public class ResultadoIMC extends AppCompatActivity {

    private ImageView btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado_imc);

        // Inicializar as Views
        TextView textoPeso = findViewById(R.id.textoPeso);
        TextView textoAltura = findViewById(R.id.textoAltura);
        TextView textoImc = findViewById(R.id.textoIMC);
        TextView textoNome = findViewById(R.id.textoNome);

        // Receber os dados da Intent
        Intent intent = getIntent();
        String peso = intent.getStringExtra("peso");
        String altura = intent.getStringExtra("altura");
        String imc = intent.getStringExtra("imc");
        String nome = intent.getStringExtra("nome");

        // Atualizar os TextViews com os dados recebidos
        textoPeso.setText(peso);
        textoAltura.setText(altura);
        textoImc.setText(imc);
        textoNome.setText(nome);


        Bundle bundle = intent.getExtras();

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