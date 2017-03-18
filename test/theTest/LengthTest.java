package theTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import theezconverter.Unit;
import theezconverter.Conversion;

public class LengthTest
{   
    private final double[] INPUT_VALUE = {98765.0, -12345.0, 0.0};;
    private static Unit unit;
    private Conversion conversion;
    private static int counter;
    //Tolerance of 4 decimal places
    private static final double DELTA = 1e-1;
    
    @BeforeClass //Initialising
    public static void setupBeforeClass()
    {
        unit = new Unit();
        counter = 0;
    }//END @BeforeClass
    
    @Before //Intialise object used for every test
    public void setupBefore()
    {
        conversion = new Conversion();
    }//END @Before
    
    @Test //Ref.01
    public void cmToInch()
    {
        double[] expectedResult = {38883.8792, -4860.2388, 0.0};
        unit = new Unit("Centimeter", "Inch");
        
        conversion = new Conversion(INPUT_VALUE[counter], unit.getConversionFormulas());
        assertEquals(expectedResult[counter], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+1], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+1], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+2], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+2], conversion.getOutput(), DELTA);
    }//END @Test cmToInch
    
    @Test //Ref.02
    public void mToFeet()
    {
        double[] expectedResult = {324032.15, -40501.969, 0};      
        unit = new Unit("Meter", "Feet");
        
        conversion = new Conversion(INPUT_VALUE[counter], unit.getConversionFormulas());
        assertEquals(expectedResult[counter], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+1], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+1], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+2], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+2], conversion.getOutput(), DELTA);     
    }//END @Test mToFeet
    
    @Test //Ref.03
    public void cmToFeet()
    {
        double[] expectedResult = {3240.3215, -405.01969, 0};
        unit = new Unit("Centimeter", "Feet");
        
        conversion = new Conversion(INPUT_VALUE[counter], unit.getConversionFormulas());
        assertEquals(expectedResult[counter], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+1], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+1], conversion.getOutput(),DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+2], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+2], conversion.getOutput(), DELTA);
    }//END @Test cmToFeet
    
    @Test //Ref.04
    public void milesToKm()
    {
        double[] expectedResult = {158946.86, -19867.352, 0};
        unit = new Unit("Miles", "Kilometer");
        
        conversion = new Conversion(INPUT_VALUE[counter], unit.getConversionFormulas());
        assertEquals(expectedResult[counter], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+1], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+1], conversion.getOutput(), DELTA);
        
        conversion = new Conversion(INPUT_VALUE[counter+2], unit.getConversionFormulas());
        assertEquals(expectedResult[counter+2], conversion.getOutput(), DELTA);
    }//END @Test milesToKm

}
