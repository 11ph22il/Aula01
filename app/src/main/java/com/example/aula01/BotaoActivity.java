package com.example.aula01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BotaoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1.findViewById(R.id.btn_somarNum);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mudarTexto("Mudei com o método 4!");
    }

    public void mudarTexto(String texto){
        b1.setText(texto);
    }
}
