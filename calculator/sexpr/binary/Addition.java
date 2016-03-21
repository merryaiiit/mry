package se.fd.calculator.sexpr.binary;

import se.fd.calculator.Binary;
import se.fd.calculator.Sexpr;
import se.fd.calculator.sexpr.atom.Constant;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public class Addition extends Binary
{

    public Addition(Sexpr left, Sexpr right)
    {
        super(left, right);
    }

    @Override
    public String getName()
    {
        return "+";
    }



    @Override
    public int priority()
    {
        return 2;
    }


    @Override
    public Sexpr eval(Map<String, Sexpr> map)
    {
        Sexpr leftEval = left.eval(map);
        Sexpr rightEval = right.eval(map);

        if (leftEval.isConstant() && rightEval.isConstant())
        {
            return new Constant(leftEval.getValue() + rightEval.getValue());
        }
        else return new Addition(leftEval, rightEval);

    }
}
