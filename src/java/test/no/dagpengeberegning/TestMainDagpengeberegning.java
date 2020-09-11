package no.dagpengeberegning;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMainDagpengeberegning {

    private void testBeregnDagpengeSats(int siste, int nesteSiste, int nestNestSiste, int forventet){
        Assert.assertEquals("Feil resultat for beregnDagpengeSats(" + siste + ", " + nesteSiste + ", " + nestNestSiste + ")" ,
                forventet,
                MainDagpengeberegning.beregnDagpengeSats(siste, nesteSiste, nestNestSiste));
    }
    private void testBeregnDagpengeSats(long siste, long nesteSiste, long nestNestSiste, long forventet){
        Assert.assertEquals("Feil resultat for beregnDagpengeSats(" + siste + ", " + nesteSiste + ", " + nestNestSiste + ")" ,
                forventet,
                MainDagpengeberegning.beregnDagpengeSats(siste, nesteSiste, nestNestSiste));
    }

    @Test
    public void testEksempel(){
        testBeregnDagpengeSats(500000, 450000, 400000, 1924);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativInput1(){
        testBeregnDagpengeSats(-500000, 450000, 400000, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativInput2(){
        testBeregnDagpengeSats(500000, -450000, 400000, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativInput3(){
        testBeregnDagpengeSats(500000, 450000, -400000, 0);
    }

    @Test
    public void testJeffBezosSokerDagpenger(){
        testBeregnDagpengeSats(839540246485L, 759540246485L, 829540246485L, 2339);
    }

    @Test
    public void testKanttilfelleOverSatsEttAar(){
        testBeregnDagpengeSats(152027, 0, 0, 585);
    }

    @Test
    public void testKanttilfelleUnderSatsEttAar(){
        testBeregnDagpengeSats(152026, 0, 0, 0);
    }

    @Test
    public void testKanttilfelleUnderSatsFlereAar(){
        testBeregnDagpengeSats(101351, 101351, 101351, 0);
    }

    @Test
    public void testKanttilfelleOverSatsFlereAar(){
        testBeregnDagpengeSats(101351, 101352, 101351, 390);
    }

    @Test
    public void testBrukerHoyeste(){
        testBeregnDagpengeSats(500000, 510000, 510000, 1949);
    }

    @Test
    public void testHoyereEnnMaks(){
        testBeregnDagpengeSats(123456789, 0, 0, 2339);
    }

    @Test
    public void testMaks(){
        testBeregnDagpengeSats(608106, 0, 0, 2339);
    }

    @Test
    public void testRunderOpp(){
        testBeregnDagpengeSats(607881, 0, 0, 2339);
    }

    @Test
    public void testIkkeRunderOpp(){
        testBeregnDagpengeSats(607880, 0, 0, 2338);
    }


}

