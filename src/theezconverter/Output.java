/*
This is Output Class.
This class is primarily to store user output(conversion result).
It has
(1) 3 Constructor
    - a default with no input parameter
    - a alternative with a double parameter
    - a copy constructor with object as the parameter

(2) A Mutator to set the variable output, an Accessor and a toString.
 */
package theezconverter;

public class Output
{
    private double output;
    
    public Output()
    {
        output = 0.00;
    }
    
    public Output(double inOutput)
    {
        setOutput(inOutput);
    }
    
    public Output(Output output)
    {
        this(output.getOutput());
    }
    
    public void setOutput(double inOutput)
    {
        output = inOutput;
    }
    
    public double getOutput()
    {
        return output;
    }
    
    public String toString()
    {
        //return String.format("%4f",Double.toString(getOutput());
        return String.format("%.5f",getOutput());
    }
    
}
