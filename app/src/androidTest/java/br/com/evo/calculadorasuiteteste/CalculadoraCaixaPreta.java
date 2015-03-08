package br.com.evo.calculadorasuiteteste;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import junit.framework.Assert;

public class CalculadoraCaixaPreta extends ActivityInstrumentationTestCase2<SomaDoisNumerosActivity> {

    Solo mSolo;

    public CalculadoraCaixaPreta() {
        super(SomaDoisNumerosActivity.class);
    }

    public void setUp() throws Exception {
        mSolo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        mSolo.finishOpenedActivities();
    }

    public void testSomarDoisNumerosPositivos() throws Exception {
        mSolo.unlockScreen();
        mSolo.enterText(0, "1");
        mSolo.enterText(1, "3");
        mSolo.clickOnButton("somar");
        boolean resultado = mSolo.searchText("4");
        Assert.assertTrue(resultado);
    }
}