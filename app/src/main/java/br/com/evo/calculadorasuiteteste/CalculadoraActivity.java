package br.com.evo.calculadorasuiteteste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculadoraActivity extends Activity {

    private EditText mEtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        mEtResultado = (EditText) findViewById(R.id.etResultado);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIgual:
                calcular();
                break;
            case R.id.btnDel:
                removerCaracter();
                break;
            default:
                Button btn = (Button) v;
                addCaracter(btn.getText().toString());
        }
    }

    private String getText() {
        return mEtResultado.getText().toString();
    }

    private void setText(String text) {
        mEtResultado.setText(text);
    }

    private void addCaracter(String caracter) {
        mEtResultado.setText(getText() + caracter);
    }

    private void removerCaracter() {
        String display = getText();
        mEtResultado.setText(display.substring(0, display.length() -1));
    }

    private void calcular() {
        try {
            Expression e = new ExpressionBuilder(getText()).build();
            setText(String.valueOf(e.evaluate()));
        } catch (ArithmeticException e) {
            mEtResultado.setText("Erro");
        }
    }
}
