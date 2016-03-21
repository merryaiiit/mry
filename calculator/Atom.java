package se.fd.calculator;

import se.fd.calculator.Sexpr;

/**
 * Created by danielghandahari on 2015-11-21.
 */
public abstract class Atom extends Sexpr
{
    public String toString()
    {
        return getName();
    }

}
