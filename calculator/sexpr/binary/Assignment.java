package se.fd.calculator.sexpr.binary;

import se.fd.calculator.Binary;
import se.fd.calculator.Sexpr;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public class Assignment extends Binary
{

    public Assignment(Sexpr left, Sexpr right)
    {
        super(left, right);
    }


    @Override
    public String getName()
    {
        return "=";
    }

    @Override
    public int priority()
    {
        return 3;
    }

    @Override
    public Sexpr eval(Map<String, Sexpr> map)
    {
        map.put(right.getName(), left);
        return left.eval(map);
    }

}
