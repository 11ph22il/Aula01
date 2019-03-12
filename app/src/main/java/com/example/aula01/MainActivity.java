package com.example.aula01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText in_edt_num1;
    private EditText in_edt_num2;

    protected Button in_btn_somarNum;
    protected Button in_btn_subtrairNum;
    protected Button in_btn_multiplicarNum;
    protected Button in_btn_dividirNum;

    @SuppressWarnings(value = "unused")
    protected TextView out_txt_texto_fixo;
    protected TextView out_txt_resultado;

    double num1, num2, resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in_edt_num1 = findViewById(R.id.edt_num1);
        in_edt_num2 = findViewById(R.id.edt_num2);

        in_btn_somarNum = findViewById(R.id.btn_somarNum);
        in_btn_subtrairNum = findViewById(R.id.btn_subtrairNum);
        in_btn_multiplicarNum = findViewById(R.id.btn_multiplicarNum);
        in_btn_dividirNum = findViewById(R.id.btn_dividirNum);

        out_txt_texto_fixo = findViewById(R.id.txt_texto_fixo);
        out_txt_resultado = findViewById(R.id.txt_resultado);

        in_btn_somarNum.setOnClickListener(this);
        in_btn_subtrairNum.setOnClickListener(this);
        in_btn_multiplicarNum.setOnClickListener(this);
        in_btn_dividirNum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(!TextUtils.isEmpty(in_edt_num1.getText()) && !TextUtils.isEmpty(in_edt_num2.getText())){
            num1 = Double.parseDouble(in_edt_num1.getText().toString());
            num2 = Double.parseDouble(in_edt_num2.getText().toString());
            switch (v.getId()){
                case R.id.btn_somarNum:
                    resultado = num1 + num2;
                    out_txt_resultado.setText(String.valueOf(resultado));
                    break;
                case R.id.btn_subtrairNum:
                    resultado = num1 - num2;
                    out_txt_resultado.setText(String.valueOf(resultado));
                    break;
                case R.id.btn_multiplicarNum:
                    resultado = num1 * num2;
                    out_txt_resultado.setText(String.valueOf(resultado));
                    break;
                case R.id.btn_dividirNum:
                    NumberFormat formatter = NumberFormat.getNumberInstance();
                    formatter.setMinimumFractionDigits(2);
                    formatter.setMaximumFractionDigits(2);
                    resultado = num1 / num2;
                    out_txt_resultado.setText(String.valueOf(formatter.format(resultado)));
                    break;
            }
        }
        else{
            out_txt_resultado.setText(R.string.msg_campoVazio);
        }
    }
}
