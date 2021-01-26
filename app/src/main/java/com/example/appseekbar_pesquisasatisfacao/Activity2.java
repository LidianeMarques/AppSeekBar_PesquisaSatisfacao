package com.example.appseekbar_pesquisasatisfacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imageView = findViewById(R.id.imageView);

        //ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle paramers;
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null) {
            paramers = intent.getExtras();

            if (paramers != null) {
                String nome = paramers.getString("nome");
                String cidadeSelecionada = paramers.getString("cidadeSelecionada");
                String progresso = paramers.getString("progresso");
                textViewResultado.setText("Obrigada por responder a pesquisa, " + nome.toString() + "." +
                        "\nA cidade que você marcou foi: " + cidadeSelecionada + ".\nE " +
                        "o seu nível de satisfação com a administração do governo" +
                        " atual foi: ");

                if (progresso.equals("2")) {
                    imageView.setImageResource(R.drawable.bom);
                } else if (progresso.equals("3")) {
                    imageView.setImageResource(R.drawable.otimo);
                } else {
                    imageView.setImageResource(R.drawable.ruim);
                }

            }
        }
    }

    //Metódo para voltar para tela anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //identificar a ação de voltar a tela
            case android.R.id.home:
                //encerra a activity
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}