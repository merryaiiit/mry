package se.fd.calculator.sexpr.command;

import se.fd.calculator.Sexpr;
import se.fd.calculator.Command;

import java.util.Collections;
import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-25.
 */
public class Vars extends Command
{
    @Override
    public String getName()
    {
        return "vars";
    }

    @Override
    public Sexpr eval(Map<String, Sexpr> map)
    {
        for (Map.Entry<String, Sexpr> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        return this;
    }
}
