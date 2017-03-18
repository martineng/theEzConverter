/*
=================================
Name: UnitFormulasStringTest.java
=================================
The test will match the expected formulas with 
the formulas declared within the origianl function.

The string values are taken from jOptionPane.
Hence no other string will be passes to the function.
However, Illegal Argument Exception have also been 
handled in the original function.

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
public class UnitFormulasStringTest
{
    private double expectedFormulas;
    private String unitFrom;
    private String unitTo;
    //Tolerance is at least 10 decimal places
    private static final double DELTA = 1e-10;
    
    @Parameters //Collection Setup
    public static Collection getTestParameters()
    {
        return Arrays.asList(new Object[][] {
            //=====cm=================
            {1.0, "Centimeter", "Centimeter"},
            {0.01, "Centimeter", "Meter"},
            {0.00001, "Centimeter", "Kilometer"},
            {0.3937007874, "Centimeter", "Inch"},
            {0.03280839895, "Centimeter", "Feet"},
            {0.0000062137119224, "Centimeter", "Miles"},
            //======m=================
            {100.0, "Meter", "Centimeter"},
            {1.0, "Meter", "Meter"},
            {0.001, "Meter", "Kilometer"},
            {39.37007874, "Meter", "Inch"},
            {3.280839895, "Meter", "Feet"},
            {0.00062137119224, "Meter", "Miles"},
            //======km=================
            {100000.0, "Kilometer", "Centimeter"},
            {1000.0, "Kilometer", "Meter"},
            {1.0, "Kilometer", "Kilometer"},
            {39370.07874, "Kilometer", "Inch"},
            {3280.839895, "Kilometer", "Feet"},
            {0.62137119224, "Kilometer", "Miles"},
            //======inch===============
            {2.54, "Inch", "Centimeter"},
            {0.0254, "Inch", "Meter"},
            {0.0000254, "Inch", "Kilometer"},
            {1.0, "Inch", "Inch"},
            {0.083333333333, "Inch", "Feet"},
            {0.000015782828283, "Inch", "Miles"},
            //======feet================
            {30.48, "Feet", "Centimeter"},
            {0.3048, "Feet", "Meter"},
            {0.0003048, "Feet", "Kilometer"},
            {12.0, "Feet", "Inch"},
            {1.0, "Feet", "Feet"},
            {0.00018939393939, "Feet", "Miles"},
            //=====miles================
            {160934.0, "Miles", "Centimeter"},
            {1609.344, "Miles", "Meter"},
            {1.609344, "Miles", "Kilometer"},
            {63360.0202752, "Miles", "Inch"},
            {5280.0016896, "Miles", "Feet"},
            {1.0, "Miles", "Miles"},
            /*===========================
              Due to the complexity of temperature,
              temperature formulas will store indicator,
              it will further begin identify in other function
              to obtain its' formulas.
            =============================*/
            //======celsius=============
            {1.0, "Celsius", "Celsius"},
            {1111.0, "Celsius", "Fahrenheit"}, 
            //====fahrenheit============
            {2222.0, "Fahrenheit", "Celsius"},
            {1.0, "Fahrenheit", "Fahrenheit"},
        });//END return
    }//END @Parameters
    
    //Constructor
    public UnitFormulasStringTest(double inExpectedFormulas, String inUnitFrom, String inUnitTo)
    {
        this.expectedFormulas = inExpectedFormulas;
        this.unitFrom = inUnitFrom;
        this.unitTo = inUnitTo;
    }// END Constructor
    
    @Test //Ref. 01 Test each value with the Collection.
    public void unit()
    {
        Unit unit = new Unit();
        unit.setUnit(unitFrom, unitTo);
        
        System.out.printf("[%s][%s] -> %f%n",
                          unitFrom,
                          unitTo,
                          expectedFormulas);
        
        
        assertEquals("VALUE UNMATCHED", expectedFormulas, unit.getConversionFormulas(), DELTA);
    }//END @test
}