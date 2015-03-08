package br.com.evo.calculadorasuiteteste;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SomaDoisNumerosActivity extends ActionBarActivity implements View.OnClickListener{

    private EditText mEtPrimeiroNumero;
    private EditText mEtSegundoNumero;
    private Button mBtnSomar;
    private TextView mTvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtPrimeiroNumero = (EditText) findViewById(R.id.etPrimeiroNumero);
        mEtSegundoNumero  = (EditText) findViewById(R.id.etSegundoNumero);
        mBtnSomar         = (Button) findViewById(R.id.btnSomar);
        mTvResultado      = (TextView) findViewById(R.id.tvResultado);

        mBtnSomar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mTvResultado.setText(String.valueOf(somar()));
    }

    public int somar() {
        int primeiroNumero = Integer.parseInt(mEtPrimeiroNumero.getText().toString());
        int segundoNumero  = Integer.parseInt(mEtSegundoNumero.getText().toString());
        return primeiroNumero + segundoNumero;
    }
}
