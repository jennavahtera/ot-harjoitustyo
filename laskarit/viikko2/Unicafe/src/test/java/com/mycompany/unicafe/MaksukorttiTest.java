package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(2);
        assertEquals("saldo: 0.12", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(5);
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.0", kortti.toString());
        //return true;
    }
    
    @Test
    public void saldoEiMuutuJosRahatEiRiita() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
        //return false;
    }
}
