package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jennanathalie
 */
public class KassapaateTest {
    
    Kassapaate kp;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kp = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void oikeaRaha() {
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void oikeatLounaat() {
        assertEquals(0, kp.maukkaitaLounaitaMyyty());
        assertEquals(0, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassaOikeinEdullisenOstonJalkeen() {
        kp.syoEdullisesti(300);
        assertEquals(100240, kp.kassassaRahaa());
    }
    
    @Test
    public void kassaPysyySamanaEdullisestiMaksunJalkeen() {
        kp.syoEdullisesti(200);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void kassaPysyySamanaMaukkaanOstonJalkeen() {
        kp.syoMaukkaasti(200);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void kassaOikeinMaukkaanOstonJalkeen() {
        kp.syoMaukkaasti(500);
        assertEquals(100400, kp.kassassaRahaa());
    }
    
    @Test
    public void vaihtorahaOikein() {
        assertEquals(60,kp.syoEdullisesti(300));
        assertEquals(100,kp.syoMaukkaasti(500));
    }
    
    @Test
    public void edullinenVeloitusToimiiKassapaatteella() {
        kp.syoEdullisesti(240);
        assertEquals(100240, kp.kassassaRahaa());
    }
    
    @Test
    public void maukasVeloitusToimiiKassapaatteella() {
        kp.syoMaukkaasti(500);
        assertEquals(100400, kp.kassassaRahaa());
    }
    
    @Test
    public void edullinenVeloitusToimiiKortilla() {
        kp.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    public void maukasVeloitusToimiiKortilla() {
        kp.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }
    
    @Test
    public void maukkaatLisaantyy() {
        kp.syoMaukkaasti(400);
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisetLisaantyy() {
        kp.syoEdullisesti(400);
        assertEquals(1, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void edullinenEiRiita() {
        kp.syoMaukkaasti(kortti);
        kp.syoMaukkaasti(kortti);
        kp.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(0, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasEiRiita() {
        kp.syoMaukkaasti(kortti);
        kp.syoMaukkaasti(kortti);
        kp.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(2, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanMaaraEiMuutuKortillaOstaessa() {
        kortti.otaRahaa(200);
        assertEquals(800, kortti.saldo());
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    @Test
    public void rahanLataaminenKortti() {
        kp.lataaRahaaKortille(kortti, 200);
        assertEquals(1200, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKassapaate() {
        kp.lataaRahaaKortille(kortti, 200);
        assertEquals(100200, kp.kassassaRahaa());
    }
    
    @Test
    public void rahanLataaminenKorttiEiToimi() {
        kp.lataaRahaaKortille(kortti, -200);
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKassapaateEiToimi() {
        kp.lataaRahaaKortille(kortti, -200);
        assertEquals(100000, kp.kassassaRahaa());
    }
    
    
}
