/*
=================================
Name: UnitFormulasIndexTest.java
=================================
The test will match the expected formulas with 
the formulas declared within the origianl function.
[DO NOTE] 
that temperature formulas will return 1111 or 2222.
It is an indicator set due to the complexity of temperature
conversion. The function in Conversion class will identify
the value and perform the correct mathematic algorithm in
later stage.
=================================
*/
package theTest;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import theezconverter.Unit;

@RunWith(Parameterized.class)
public class UnitFormulasIndexTest
{
    private double expectedFormulas;
    private int indexFrom;
    private int indexTo;
    //Tolerance is at least 10 decimal places
    private static final double DELTA = 1e-10;
    
    @Parameters //Collection Setup
    public static Collection getTestParameters()
    {
        return Arrays.asList(new Object[][] {
            //=====cm=================
            {1.0, 0, 0},
            {0.01, 0, 1},
            {0.00001, 0, 2},
            {0.3937007874, 0, 3},
            {0.03280839895, 0, 4},
            {0.0000062137119224, 0, 5},
            //======m=================
            {100.0, 1, 0},
            {1.0, 1, 1},
            {0.001, 1, 2},
            {39.37007874, 1, 3},
            {3.280839895, 1, 4},
            {0.00062137119224, 1, 5},
            //======km=================
            {100000.0, 2, 0},
            {1000.0, 2, 1},
            {1.0, 2, 2},
            {39370.07874, 2, 3},
            {3280.839895, 2, 4},
            {0.62137119224, 2, 5},
            //======inch===============
            {2.54, 3, 0},
            {0.0254, 3, 1},
            {0.0000254, 3, 2},
            {1.0, 3, 3},
            {0.083333333333, 3, 4},
            {0.000015782828283, 3, 5},
            //======feet================
            {30.48, 4, 0},
            {0.3048, 4, 1},
            {0.0003048, 4, 2},
            {12.0, 4, 3},
            {1.0, 4, 4},
            {0.00018939393939, 4, 5},
            //=====miles================
            {160934.0, 5, 0},
            {1609.344, 5, 1},
            {1.609344, 5, 2},
            {63360.0202752, 5, 3},
            {5280.0016896, 5, 4},
            {1.0, 5, 5},
            /*===========================
              Due to the complexity of temperature,
              temperature formulas will store indicator,
              it will further begin identify in other function
              to obtain its' formulas.
            =============================*/
            //======celsius=============
            {1.0, 6, 6},
            {1111.0, 6, 7}, 
            //====fahrenheit============
            {2222.0, 7, 6},
            {1.0, 7, 7},
        });//END return
    }//END @Parameters
    
    //Constructor
    public UnitFormulasIndexTest(double inExpectedFormulas, int inIndexFrom, int inIndexTo)
    {
        this.expectedFormulas = inExpectedFormulas;
        this.indexFrom = inIndexFrom;
        this.indexTo = inIndexTo;
    }// END Constructor
    
    @Test // Ref. 01 Test each value with the Collection.
    public void unit()
    {
        Unit unit = new Unit();
        unit.setUnit(indexFrom, indexTo);
        
        System.out.printf("[%d][%d] -> %f%n",
                          indexFrom,
                          indexTo,
                          expectedFormulas);
        
        if (indexTo == 5 || indexTo == 7)
        {
            System.out.printf("%n");
        }//END if
        
        assertEquals("VALUE UNMATCHED", expectedFormulas, unit.getConversionFormulas(), DELTA);
    }//END @test
}