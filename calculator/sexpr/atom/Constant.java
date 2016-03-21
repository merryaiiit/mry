package se.fd.calculator.sexpr.atom;

import se.fd.calculator.Atom;
import se.fd.calculator.Sexpr;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-21.
 */
public class Constant extends Atom
{
    private double value;


    public Constant(double value)
    {
        this.value = value;
    }

    public String getName()
    {
        return String.valueOf(value);
    }


    public double getValue()
    {
        return value;
    }


    @Override
    public boolean isConstant()
    {
        return true;
    }


    @Override
    public Sexpr eval(Map<String, Sexpr> map)
    {
        return this;
    }
}
