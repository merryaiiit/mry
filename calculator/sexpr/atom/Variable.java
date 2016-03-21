package se.fd.calculator.sexpr.atom;

import se.fd.calculator.Atom;
import se.fd.calculator.Sexpr;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-21.
 */
public class Variable extends Atom
{
    private String ident;




    public Variable(String ident)
    {
        this.ident = ident;
    }




    public String getName()
    {
        return ident;
    }

    @Override
    public Sexpr eval(Map<String, Sexpr> map)
    {
        if (map.containsKey(ident))
            return map.get(ident).eval(map);
        return this;
    }
}
