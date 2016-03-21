package se.fd.calculator;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public abstract class Sexpr {

    public abstract String getName();


    public double getValue()
    {
        //TODO: need filed in subclass
        return -1;
    }


    public int priority()
    {
        //TODO: need info
        return -1;
    }


    public boolean isConstant()
    {
        return false;
    }

    public abstract Sexpr eval(Map<String, Sexpr> map);
}
