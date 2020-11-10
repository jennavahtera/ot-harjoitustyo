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
    
    @Before
    public void setUp() {
        kp = new Kassapaate();
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
    public void ostoToimii() {
        
    }
}
