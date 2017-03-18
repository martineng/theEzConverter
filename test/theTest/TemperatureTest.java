package theTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import theezconverter.Conversion;
import theezconverter.Unit;

public class TemperatureTest
{
    //Tolerance for 4 decimal places
    private static final double DELTA = 1e-4;
 
    private Unit testUnit;
    private Conversion conversion;
    private static int testCounter;
    
    @BeforeClass   //initialise counter
    public static void setupBeforeClass()
    {
        testCounter = 1;
        System.out.printf("TEST BEGIN%n%n");
    }
   
    @Before   //initialise instance
    public void setupBefore()
    {
        testUnit = new Unit();
        System.out.printf("Test %d:%n", testCounter);
        testCounter++;
    }
    
    @After   //print information on console
    public void setupAfter()
    {
        System.out.printf("%s to %s:%n%.4f -> %.4f%n%n",
                          testUnit.getUnitFrom(),
                          testUnit.getUnitTo(),
                          conversion.getInput(),
                          conversion.getOutput());
    }
    //==============Test Begin Below=================
    @Test //Ref.01 Celsius to Fahrenheit
    public void celsiusPositiveInputTest()
    {
        testUnit = new Unit("Celsius", "Fahrenheit");
        conversion = new Conversion(1010.0, testUnit.getConversionFormulas());
        assertEquals(1850.0, conversion.getOutput(), DELTA);
    }
    
    @Test //Ref.02 Celsius to Fahrenheit
    public void celsiusNegativeInputTest()
    {
        testUnit = new Unit("Celsius", "Fahrenheit");
        conversion = new Conversion(-789.0, testUnit.getConversionFormulas());
        assertEquals(-1388.2, conversion.getOutput(), DELTA);
    }
    
    @Test //Ref. 03 Celsius to Fahrenheit
    public void ceisiusZeroInputTest()
    {
        testUnit = new Unit("Celsius", "Fahrenheit");
        conversion = new Conversion(0, testUnit.getConversionFormulas());
        assertEquals(32.0, conversion.getOutput(), DELTA);
    }
    
    @Test //Ref. 04 Fahrenheit to Celsius
    public void fahrenheitPositiveInputTest()
    {
        testUnit = new Unit("Fahrenheit", "Celsius");
        conversion = new Conversion(1010.0, testUnit.getConversionFormulas());
        assertEquals(543.3333, conversion.getOutput(), DELTA);
    }
    
    @Test //Ref. 05 Fahrenheit to Celsius
    public void fahrenheitNegativeInputTest()
    {
        testUnit = new Unit("Fahrenheit", "Celsius");
        conversion = new Conversion(-789.0, testUnit.getConversionFormulas());
        assertEquals(-456.1111, conversion.getOutput(), DELTA);
    }
    
    @Test //Ref. 06 Fahrenheit Celsius
    public void fahrenheitZeroInputTest()
    {
        testUnit = new Unit("Fahrenheit", "Celsius");
        conversion = new Conversion(0, testUnit.getConversionFormulas());
        assertEquals(-17.7778, conversion.getOutput(), DELTA);
    }
}
