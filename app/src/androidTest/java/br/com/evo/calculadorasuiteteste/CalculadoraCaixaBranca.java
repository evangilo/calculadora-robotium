package br.com.evo.calculadorasuiteteste;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.Assert;

public class CalculadoraCaixaBranca extends ActivityInstrumentationTestCase2<SomaDoisNumerosActivity> {

    public CalculadoraCaixaBranca() {
        super(SomaDoisNumerosActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        mSolo = new Solo(getInstrumentation(), getActivity());
        mEtPrimeiroNumero = (EditText) mSolo.getView(R.id.etPrimeiroNumero);
        mEtSegundoNumero  = (EditText) mSolo.getView(R.id.etSegundoNumero);
        mTvResultado      = (TextView)   mSolo.getView(R.id.tvResultado);
    }

    @Override
    protected void tearDown() throws Exception {
        mSolo.finishOpenedActivities();
    }

    public void testSomarDoisNumerosPositivos() throws Exception {
        mSolo.unlockScreen();
        mSolo.enterText(mEtPrimeiroNumero, "1");
        mSolo.enterText(mEtSegundoNumero, "3");
        mSolo.clickOnButton("somar");
        mSolo.waitForText("4");
        Assert.assertEquals("4", mTvResultado.getText().toString());
    }

    private Solo mSolo;
    private EditText mEtPrimeiroNumero;
    private EditText mEtSegundoNumero;
    private TextView mTvResultado;

}
