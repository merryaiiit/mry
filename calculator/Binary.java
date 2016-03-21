package se.fd.calculator;

/**
 * Created by danielghandahari on 2015-11-20.
 */
public abstract class Binary extends Sexpr{

    protected Sexpr left;
    protected Sexpr right;

    public Binary(Sexpr left, Sexpr right)
    {
        this.left = left;
        this.right = right;
    }

    public String toString()
    {
        return ("(" + left.toString() + " " + this.getName() + " " +right.toString() + ")");
    }

}
