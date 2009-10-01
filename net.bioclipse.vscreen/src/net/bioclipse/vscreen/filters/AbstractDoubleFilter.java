package net.bioclipse.vscreen.filters;


/**
 * 
 * @author ola
 *
 */
public abstract class AbstractDoubleFilter implements IDoubleFilter {

    public final static int OPERATOR_GRT=0x0;
    public final static int OPERATOR_GRTEQ=0x1;
    public final static int OPERATOR_LT=0x2;
    public final static int OPERATOR_LTEQ=0x3;
    public final static int OPERATOR_EQ=0x4;
    public final static int OPERATOR_UNKNOWN=0x5;
    

    private int operator;
    private double Threshold;
    
    public int getOperator() {
        return operator;
    }
    
    public void setOperator( String operator ) {
        this.operator = parseoperatorString( operator );
    }
    
    public double getThreshold() {
        return Threshold;
    }
    
    public void setThreshold( double threshold ) {
        Threshold = threshold;
    }
    
    private int parseoperatorString( String operator ) {

        if (operator.equals( ">" ))
            return OPERATOR_GRT;
        if (operator.equals( ">=" ))
            return OPERATOR_GRTEQ;
        if (operator.equals( "<" ))
            return OPERATOR_LT;
        if (operator.equals( "<=" ))
            return OPERATOR_LTEQ;
        if (operator.equals( "=" ))
            return OPERATOR_EQ;
        if (operator.equals( "==" ))
            return OPERATOR_EQ;

        return OPERATOR_UNKNOWN;
    }


    public boolean compare(Comparable num1, 
                           Comparable num2){

        if (operator==OPERATOR_EQ){
            if (num1.compareTo( num2 )==0)
                return true;
        }
        else if (operator==OPERATOR_GRT){
            if (num1.compareTo( num2 )>0)
                return true;
        }
        else if (operator==OPERATOR_GRTEQ){
            if (num1.compareTo( num2 )>=0)
                return true;
        }
        else if (operator==OPERATOR_LT){
            if (num1.compareTo( num2 )<0)
                return true;
        }
        else if (operator==OPERATOR_LTEQ){
            if (num1.compareTo( num2 )<=0)
                return true;
        }
        
        return false;
    }

}
