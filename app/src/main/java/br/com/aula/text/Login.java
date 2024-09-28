package br.com.aula.text;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private TextInputEditText inputNome;
    private TextInputEditText inputEmail;
    private TextInputEditText inputSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("Ciclo de Vida", "Tela 1 - onCreate");

        TextInputLayout nomeLayout = findViewById(R.id.textInputNome);
        TextInputLayout emailLayout = findViewById(R.id.textInputEmail);
        TextInputLayout senhaLayout = findViewById(R.id.textInputSenha);

        inputNome = (TextInputEditText) nomeLayout.getEditText();
        inputEmail = (TextInputEditText) emailLayout.getEditText();
        inputSenha = (TextInputEditText) senhaLayout.getEditText();

        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(view -> {
            try {
                String nome = inputNome.getText().toString();
                String email = inputEmail.getText().toString();
                String senha = inputSenha.getText().toString();

                // Verificando se algum campo está vazio
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
                }

                Intent intent = new Intent(Login.this, MainActivity.class);

                intent.putExtra("nome", nome);
                intent.putExtra("email", email);
                intent.putExtra("senha", senha);

                startActivity(intent);
            } catch (IllegalArgumentException e) {
                Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Input Error", "Erro: " + e.getMessage());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
