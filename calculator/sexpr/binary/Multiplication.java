package se.fd.calculator.sexpr.binary;

import se.fd.calculator.Binary;
import se.fd.calculator.Sexpr;
import se.fd.calculator.sexpr.atom.Constant;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public class Multiplication extends Binary
{

    public Multiplication(Sexpr left, Sexpr right)
    {
        super(left, right);
    }

    @Override
    public String getName()
    {
        return "*";
    }


    @Override
    public int priority()
    {
        return 1;
    }


    @Override
    public Sexpr eval(Map map)
    {
        Sexpr leftEval = left.eval(map);
        Sexpr rightEval = right.eval(map);

        if(left.isConstant() && right.isConstant())
            return new Constant(left.getValue() * right.getValue());
        return new Multiplication(leftEval, rightEval);
    }
}
