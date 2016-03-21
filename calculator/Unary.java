package se.fd.calculator;

import se.fd.calculator.sexpr.unary.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public abstract class Unary extends Sexpr
{
    public static final HashMap<String, Class<? extends Unary>> UNARY_OPS = new HashMap();
    static
    {
        UNARY_OPS.put("-", Negation.class);
        UNARY_OPS.put("exp", Exp.class);
        UNARY_OPS.put("log", Log.class);
        UNARY_OPS.put("sin", Sin.class);
        UNARY_OPS.put("cos", Cos.class);
    }

    protected Sexpr argument;

    public Unary(Sexpr argument)
    {
        this.argument = argument;
    }

    public String toString()
    {
        return this.getName() + "(" + argument.toString() + ")";
    }


    public int priority()
    {
        return 0;
    }
}
