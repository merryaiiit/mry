package se.fd.calculator;

import se.fd.calculator.sexpr.atom.Constant;
import se.fd.calculator.sexpr.atom.Variable;
import se.fd.calculator.sexpr.binary.*;
import se.fd.calculator.sexpr.command.Quit;
import se.fd.calculator.sexpr.command.Vars;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;



/**
 * Created by danielghandahari on 2015-12-05.
 */
public class Parser
{
    StreamTokenizer st;



    // ########## Constructors ########## //
    public Parser()
    {
        st = new StreamTokenizer(new InputStreamReader(System.in));
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
    }

    public Parser(String str)
    {
        st = new StreamTokenizer(new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
        st.ordinaryChar('-');
        st.eolIsSignificant(true);
    }

    // ########## Methods ########## //
    public Sexpr statement() throws IOException
    {
        st.nextToken();

        if (st.ttype == st.TT_WORD && (!st.sval.equals("quit") && !st.sval.equals("vars")))
        {
            st.pushBack();
            return assignment();
        }
        return command();
    }

    public Sexpr command()
    {
        if (st.sval.equals("quit")) return new Quit();
        return new Vars();
    }

    public Sexpr assignment() throws IOException
    {
        Sexpr exp = expression();

        if (st.nextToken() != '=')
        {
            st.pushBack();
            return exp;
        }
        else
        {
            Sexpr var = identifier();
            Sexpr result = new Assignment(exp, var);

            while (st.nextToken() == '=')
            {
                var = identifier();
                result = new Assignment(result, var);
            }
            st.pushBack();
            return result;
        }
    }

    public Sexpr expression() throws IOException
    {
        Sexpr sum = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-')
        {
            if (st.ttype == '+')
                sum = new Addition(sum, term());
            else
                sum = new Subtraction(sum, term());
        }
        st.pushBack();
        return sum;
    }

    public Sexpr term() throws IOException
    {
        Sexpr sum = factor();
        st.nextToken();
        while (st.ttype == '*' || st.ttype == '/')
        {
            if (st.ttype == '*')
                sum = new Multiplication(sum, factor());
            else
                sum = new Division(sum, factor());
        }
        st.pushBack();
        return sum;
    }

    public Sexpr factor() throws IOException
    {
        return primary();
    }

    public Sexpr primary() throws IOException
    {
        st.nextToken();

        String unary = st.sval == null ? ""+((char)st.ttype) : st.sval;

        if (st.ttype == '(')
        {
            Sexpr result = assignment();
            if (st.nextToken() == ')')
            {
                return result;
            }
            else
                throw new SexprException("Missmatched paranthesis; Expected ')'");
        }
        else if (Unary.UNARY_OPS.containsKey(unary))//else if (st.ttype == st.TT_WORD && Unary.UNARY_OPS.containsKey(st.sval))
        {
            return unary(Unary.UNARY_OPS.get(unary));
        }
        else if (st.ttype == st.TT_NUMBER)
        {
            return number();
        }
        else
        {
            return identifier();
        }
    }

    public Sexpr unary(Class c) throws IOException
    {
        try
        {
            Constructor<Unary> constr = c.getConstructor(Sexpr.class);

            if (st.nextToken() == '(')
            {
                Sexpr primary = primary();
                if (st.nextToken() == ')')
                    return constr.newInstance(primary); //om sin: new Sin(primary);
            }
            throw new Exception();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new SexprException("Failed to parse unary operation");
        }
    }

    public Sexpr number()
    {
        return new Constant(st.nval);
    }

    public Sexpr identifier() throws IOException
    {
        return new Variable(st.sval);
    }


}
