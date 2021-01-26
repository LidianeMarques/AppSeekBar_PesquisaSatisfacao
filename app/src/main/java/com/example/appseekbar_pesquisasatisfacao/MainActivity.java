package com.example.appseekbar_pesquisasatisfacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Programação para Dispositivos Móveis I.
 * INTERFACE DO USUÁRIO
 * Pesquisa de Satisfação
 * Material de apoio: https://fagno.github.io/des-movel-i-ifto/activity/#_interface
 * <p>
 * Crie um aplicativo que simule uma pesquisa de satisfação conforme instruções e exemplo da figura a seguir.
 * 1. Utilize o componente AutoCompleteTextView para carregar a cidades do estado do Tocantins.
 * 2. Utilize o componente Seekbar e ImageView para definir o nível de satisfação. As imagens estão
 * no arquivo anexo a tarefa. Ao finalizar a tarefa, apresente o resultado em um TextVIew.
 * <p>
 * SeekBar é um componente que define uma barra de progresso com nível.
 */

public class MainActivity extends AppCompatActivity {


    private AutoCompleteTextView autoCompleteTextCidade;
    private SeekBar seekBar;
    private EditText editTextNome;
    private ImageView imageView;
    int progressChangedValue = 0;

    private String[] cidadesTocantins = {"Abreulândia", "Aguiarnópolis", "Aliança do Tocantins", "Almas", "Alvorada",
            "Ananás", "Angico", "Aparecida do Rio Negro", "Aragominas", "Araguacema", "Araguaçu", "Araguaína", "Araguanã",
            "Araguatins", "Arapoema", "Arraias", "Augustinópolis", "AuroradoTocantins", "AxixádoTocantins", "Babaçulândia",
            "BandeirantesdoTocantins", "BarradoOuro", "Barrolândia", "BernardoSayão", "BomJesusdoTocantins", "BrasilândiadoTocantins",
            "BrejinhodeNazaré", "BuritidoTocantins", "Cachoeirinha", "CamposLindos", "CariridoTocantins", "Carmolândia", "CarrascoBonito",
            "Caseara", "Centenário", "ChapadadaNatividade", "ChapadadeAreia", "ColinasdoTocantins", "Colmeia", "Combinado", "ConceiçãodoTocantins",
            "CoutoMagalhães", "Cristalândia", "CrixásdoTocantins", "Darcinópolis", "Dianópolis", "DivinópolisdoTocantins", "DoisIrmãosdoTocantins",
            "Dueré", "Esperantina", "Fátima", "Figueirópolis", "Filadélfia", "FormosodoAraguaia", "FortalezadoTabocão", "Goianorte", "Goiatins", "Guaraí",
            "Gurupi", "Ipueiras", "Itacajá", "Itaguatins", "Itapiratins", "ItaporãdoTocantins", "JaúdoTocantins", "Juarina", "LagoadaConfusão",
            "LagoadoTocantins", "Lajeado", "Lavandeira", "Lizarda", "Luzinópolis", "MarianópolisdoTocantins", "Mateiros", "MaurilândiadoTocantins",
            "MiracemadoTocantins", "Miranorte", "MontedoCarmo", "MonteSantodoTocantins", "Muricilândia", "Natividade", "Nazaré", "NovaOlinda",
            "NovaRosalândia", "NovoAcordo", "NovoAlegre", "NovoJardim", "OliveiradeFátima", "Palmas", "Palmeirante", "PalmeirasdoTocantins", "Palmeirópolis",
            "ParaísodoTocantins", "Paranã", "Paud'Arco", "PedroAfonso", "Peixe", "Pequizeiro", "PindoramadoTocantins", "Piraquê", "Pium", "PonteAltadoBomJesus",
            "PonteAltadoTocantins", "PortoAlegredoTocantins", "PortoNacional", "PraiaNorte", "PresidenteKennedy", "Pugmil", "Recursolândia", "Riachinho",
            "RiodaConceição", "RiodosBois", "RioSono", "Sampaio", "Sandolândia", "SantaFédoAraguaia", "SantaMariadoTocantins", "SantaRitadoTocantins",
            "SantaRosadoTocantins", "SantaTerezadoTocantins", "SantaTerezinhadoTocantins", "SãoBentodoTocantins", "SãoFélixdoTocantins", "SãoMigueldoTocantins",
            "SãoSalvadordoTocantins", "SãoSebastiãodoTocantins", "SãoValério", "Silvanópolis", "SítioNovodoTocantins", "Sucupira", "Taguatinga", "TaipasdoTocantins",
            "Talismã", "Tocantínia", "Tocantinópolis", "Tupirama", "Tupiratins", "Wanderlândia", "Xambioá"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        imageView = findViewById(R.id.imageView);

        autoCompleteTextCidade = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextCidade);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, cidadesTocantins);
        autoCompleteTextCidade.setAdapter(adapter);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progressChangedValue = progress;

                if (progressChangedValue == 2) {
                    imageView.setImageResource(R.drawable.bom);
                } else if (progressChangedValue == 3) {
                    imageView.setImageResource(R.drawable.otimo);
                } else {
                    imageView.setImageResource(R.drawable.ruim);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void botaoEnviar(View view) {

        String cidadeSelecionada = autoCompleteTextCidade.getText().toString();
        String nome = editTextNome.getText().toString();
        String progresso = String.valueOf(progressChangedValue);

        Intent intent = new Intent(MainActivity.this, Activity2.class);
        intent.putExtra("nome", nome);
        intent.putExtra("cidadeSelecionada", cidadeSelecionada);
        intent.putExtra("progresso", progresso);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Pesquisa respondida", Toast.LENGTH_SHORT).show();

    }
}