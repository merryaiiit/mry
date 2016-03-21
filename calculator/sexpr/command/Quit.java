package se.fd.calculator.sexpr.command;

import se.fd.calculator.Sexpr;
import se.fd.calculator.Command;

import java.util.Map;

/**
 * Created by danielghandahari on 2015-11-25.
 */
public class Quit extends Command
{
    @Override
    public String getName()
    {
        return "quit";
    }

    @Override
    public Sexpr eval(Map map)
    {
        System.out.println("Quitting program");
        return this;
    }
}
