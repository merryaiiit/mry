package se.fd.calculator.sexpr.unary;

import se.fd.calculator.Sexpr;
import se.fd.calculator.Unary;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public class Negation extends Unary
{
    public Negation(Sexpr argument)
    {
        super(argument);
    }

    @Override
    public String getName()
    {
        return "!";
    }

    @Override
    public Sexpr eval(Map map)
    {
        return null;
    }
}
