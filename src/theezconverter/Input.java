/*
This is Input Class.
This class is primarily to store user input.
It has
(1) 3 Constructor
    - a default with no input parameter
    - a alternative with a double parameter
    - a copy constructor with object as the parameter

(2) A Mutator to set the variable input, an Accessor and a toString.
 */
package theezconverter;

public class Input
{
    private double input;
    
    public Input()
    {
        input = 0.00;
    }
    
    public Input(double inInput)
    {
        setInput(inInput);        
    }
    
    public Input (Input input)
    {
        this(input.getInput());
    }
    
    public void setInput(double inInput)
    {   
        input = inInput;
    }
    
    public double getInput()
    {
        return input;
    }
    
    public String toString()
    {             
        return Double.toString(getInput());
    }
}
