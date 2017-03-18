/*
This is the Conversion class.

It has 3 variables, input, output and formulas.

This class has
(1) 3 Constructor.
    - Default
    - Alternate Constructor with input and formulas as parameters.
    - Copy Constructor.

(2) 1 Mutator, setConversion to assign import value to the class
    as well as to perform mathematical calculation to obtain result (output).

(3) 3 Accessor for extenal use.

(4) 2 print method. toString to return result (output).
    printAll to display all the information.
 */
package theezconverter;

public class Conversion
{
    private double input, output, formulas;
    
    //Default Constructor
    public Conversion()
    {
        input = 0.0;
        output = 0.0;
        formulas = 0.0;        
    }
    
    //Alternate with input and formulas as parameters
    public Conversion(double inInput, double inFormulas)
    {
        setConversion(inInput, inFormulas);
    }
    
    //Copy Constructor
    public Conversion(Conversion conversion)
    {
        this(conversion.getInput(), conversion.getFormulas());
    }
    
    public void setConversion(double inInput, double inFormulas)
    {
        input = inInput;
        formulas = inFormulas;
        
        //Celsius to Fahrenheit
        if (inFormulas == 1111)
        {
            output = (inInput * 1.8)+32;
        }
        //Fahrenheit to Celsius
        else if (inFormulas == 2222)
        {
            output = (inInput-32)/1.8;
        }
        //Length
        else
        {
            output = inInput * inFormulas;
        }
    }
    
    public double getInput()
    {
        return input;
    }
    
    public double getOutput()
    {
        return output;
    }
    
    public double getFormulas()
    {
        return formulas;
    }
    
    public String printAll()
    {
        return getInput() + " x " + getFormulas() + " = " +
               getOutput();
    }
    
}
