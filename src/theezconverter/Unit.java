/*
This is Unit Class.

This class have variables of:
1) A 2D Array of double to store the formulas for conversion
2) Two int of indexFrom and indexTo to track the desire units for conversion
3) A double of conversionFormulas to keep the correct mathematic calculation

This class has 
(1) Only a Consturctor. 
    It is because this class will not receive any parameter upon creation.
    Another reason is I am trying to avoid to initilising the 2D array outside
    of any method. Hence if to implement a alternative constructor, 
    line 38 to line 139 will needed to be repeated. Hence no copy constructor
    for unit class as the result.

(2) 6 Mutator with a object mutator, mutator for other 5 variables 
    except unitFormulas array.

(3) 6 Accessor for each variables for external use.

(4) 2 print method. toString to return the most important data,
    and a printAll to print all the informations.

 */
package theezconverter;

public class Unit
{
    private double[][] unitFormulas;
    private String unitFrom, unitTo;
    private int indexFrom, indexTo;
    private double conversionFormulas;
    
    //Default Constructor
    public Unit()
    {
        unitFormulas = new double[8][8];
        setUnitFormulas();
        unitFrom = "";
        unitTo = "";
        indexFrom = 0;
        indexTo = 0;
        conversionFormulas = 0.0;  
    }
    
    //Alternative Constructor with indexes
    public Unit(int inIndexFrom, int inIndexTo)
    {
        unitFormulas = new double[8][8];
        setUnitFormulas();
        unitFrom = "";
        unitTo = "";
        setUnit(inIndexFrom, inIndexTo);
    }
    
    //Alternative Constructor with unit's name
    public Unit(String inUnitFrom, String inUnitTo)
    {
        unitFormulas = new double[8][8];
        setUnitFormulas();
        setUnitFrom(inUnitFrom);
        setUnitTo(inUnitTo);
        setConversionFormulas();
    }
    
    //Mutator Object with indexes
    public void setUnit(int inIndexFrom, int inIndexTo)
    {
        setIndexFrom(inIndexFrom);
        setIndexTo(inIndexTo);
        setConversionFormulas();
    }
    
    //Mutator Object with unit's name
    public void setUnit(String inUnitFrom, String inUnitTo)
    {
        setUnitFrom(inUnitFrom);
        setUnitTo(inUnitTo);
        setConversionFormulas();
    }
    
    //Mutator of Unit
    public void setUnitFormulas()
    {
        /* Initialize the array Unit Formulas
        cm -> 0   m -> 1   km -> 2
        inch -> 3   feet -> 4   miles -> 5
        celsius -> 6   -> fahenheit -> 7
        */        
        //Centimeter list
        //cm to cm
        unitFormulas[0][0] = 1;
        //cm to m
        unitFormulas[0][1] = 0.01;
        //cm to km
        unitFormulas[0][2] = 0.00001;
        //cm to inch
        unitFormulas[0][3] = 0.39370078740157;
        //cm to feet
        unitFormulas[0][4] = 0.03280839895;
        //cm to miles
        unitFormulas[0][5] = 0.0000062137119224;
        
        //Meter list
        //m to cm   
        unitFormulas[1][0] = 100;
        //m to m
        unitFormulas[1][1] = 1;
        //m to km
        unitFormulas[1][2] = 0.001;
        //m to inch
        unitFormulas[1][3] = 39.37007874;
        //m to feet
        unitFormulas[1][4] = 3.280839895;
        //m to miles
        unitFormulas[1][5] = 0.00062137119224;
        
        //Kilometer list
        //km to cm      
        unitFormulas[2][0] = 100000;
        //km to m
        unitFormulas[2][1] = 1000;
        //km to km
        unitFormulas[2][2] = 1;
        //km to inch
        unitFormulas[2][3] = 39370.07874;
        //km to feet
        unitFormulas[2][4] = 3280.839895;
        //km to miles
        unitFormulas[2][5] = 0.62137119224;
        
        
        //inch list
        //inch to cm
        unitFormulas[3][0] = 2.54;
        //inch to m
        unitFormulas[3][1] = 0.0254;
        //inch to km
        unitFormulas[3][2] = 0.0000254;
        //inch to inch
        unitFormulas[3][3] = 1;
        //inch to feet
        unitFormulas[3][4] = 0.083333333333;
        //inch to miles
        unitFormulas[3][5] = 0.000015782828283 ;
        
        
        //feet list
        //feet to cm
        unitFormulas[4][0] = 30.48;
        //feet to m
        unitFormulas[4][1] = 0.3048;
        //feet to km
        unitFormulas[4][2] = 0.0003048;
        //feet to inch
        unitFormulas[4][3] = 12;
        //feet to feet
        unitFormulas[4][4] = 1;
        //feet to miles
        unitFormulas[4][5] = 0.00018939393939;
        
        
        //miles list
        //miles to cm
        unitFormulas[5][0] = 160934;
        //miles to m
        unitFormulas[5][1] = 1609.344;
        //miles to km
        unitFormulas[5][2] = 1.609344;
        //miles to inch
        unitFormulas[5][3] = 63360.0202752;
        //miles to feet
        unitFormulas[5][4] = 5280.0016896;
        //miles to miles
        unitFormulas[5][5] = 1;
 
        //temperature
        //celsius to celsius
        unitFormulas[6][6] = 1;
        //celsius to fahrenheit
        unitFormulas[6][7] = 1111;
        
        //fahrenheit to celsius
        unitFormulas[7][6] = 2222;
        //fahrenheit to fahrenheit
        unitFormulas[7][7] = 1;
    }
    
    //Mutator 
    public void setUnitFrom(String inUnitFrom)
    {   
        if (inUnitFrom == "Centimeter")
        {
            setIndexFrom(0);
        }
        else if (inUnitFrom == "Meter")
        {
            setIndexFrom(1);
        }
        else if (inUnitFrom == "Kilometer")
        {
            setIndexFrom(2);
        }
        else if (inUnitFrom == "Inch")
        {
            setIndexFrom(3);
        }
        else if (inUnitFrom == "Feet")
        {
            setIndexFrom(4);
        }
        else if (inUnitFrom == "Miles")
        {
            setIndexFrom(5);
        }
        else if (inUnitFrom == "Celsius")
        {
            setIndexFrom(6);
        }
        else if (inUnitFrom == "Fahrenheit")
        {
            setIndexFrom(7);
        }
        else
        {
            throw new IllegalArgumentException("Unit Selected is not valid.");
        }
        
        unitFrom = inUnitFrom;
    }
    
    public void setUnitTo(String inUnitTo)
    {   
        if(inUnitTo == "Centimeter")
        {
            setIndexTo(0);
        }
        else if (inUnitTo == "Meter")
        {
            setIndexTo(1);
        }
        else if (inUnitTo == "Kilometer")
        {
            setIndexTo(2);
        }
        else if (inUnitTo == "Inch")
        {
            setIndexTo(3);
        }
        else if (inUnitTo == "Feet")
        {
            setIndexTo(4);
        }
        else if (inUnitTo == "Miles")
        {
            setIndexTo(5);
        }
        else if (inUnitTo == "Celsius")
        {
            setIndexTo(6);
        }
        else if (inUnitTo == "Fahrenheit")
        {
            setIndexTo(7);
        }
        else
        {
            throw new IllegalArgumentException("Unit Selected is not valid.");
        }
        
        unitTo = inUnitTo;
    }
    
    public void setIndexFrom(int inIndexFrom)
    {
        indexFrom = inIndexFrom;
    }
    
    public void setIndexTo(int inIndexTo)
    {
        indexTo = inIndexTo;
    }
    public void setConversionFormulas()
    {       
        conversionFormulas = unitFormulas[getIndexFrom()][getIndexTo()];
    }
    
    public String getUnitFrom()
    {
        return unitFrom;
    }
    
    public String getUnitTo()
    {
        return unitTo;
    }
    
    public int getIndexFrom()
    {
        return indexFrom;
    }
    
    public int getIndexTo()
    {
        return indexTo;
    }
    
    public double getConversionFormulas()
    {
        return conversionFormulas;
    }
    
    public String printAll()
    {
        return getUnitFrom() + " --> " + getUnitTo() + " : " +
                "unitFormulas[" + getIndexFrom() + "][" + getIndexTo() + " = " + 
               getConversionFormulas() ;
    }
}
