import java.util.*;
/**
    Walther Alvarez
    CISC 500
    Assignment #13
    This is an extension of class that can compute the value of an arithmetic expression in 13.6. 
    While taking into precedence the exponent before other operands. 
    It can also compute the % operand. 
 */ 
 public class Evaluator
 {
     private ExpressionTokenizer tokenizer;
  
    /**
       Constructs an evaluator. 
       @param anExpression a string containing the expression 
       to be evaluated 
    */
    public Evaluator(String anExpression)
    {
       tokenizer = new ExpressionTokenizer(anExpression);
    }
   
    /**
       Evaluates the expression. 
       @return the value of the expression 
    */
    public double getExpressionValue()
    {
      double value = getTermValue();
      boolean done = false;
      while (!done)
      {
         String next = tokenizer.peekToken();
         if ("+".equals(next) || "-".equals(next))
         {
            tokenizer.nextToken(); // Discard "+" or "-" 
            double value2 = getTermValue();
            if ("+".equals(next)) { value = value + value2; }
            else { value = value - value2; }
         }
         else 
         {
            done = true;
         }
      }
      return value;
   }
   
   /**
      Evaluates the next term found in the expression. 
      @return the value of the term 
   */
   public double getTermValue()
   {
      double value = getOperandValue();
      boolean done = false;
      while (!done)
      {
         String next = tokenizer.peekToken();
         if ("*".equals(next) || "/".equals(next))
         {
            tokenizer.nextToken();
            double value2 = getOperandValue();
            if ("*".equals(next)) { value = value * value2; }
            else { value = value / value2; }
         }
         else 
         {
            done = true;
         }
      }
      return value;
   }   
   
   public double getOperandValue()
   {
      double value = getFactorValue();
      boolean done = false;
      while (!done)
      {
         String next = tokenizer.peekToken();
         if ("^".equals(next) || "%".equals(next))
         {
            tokenizer.nextToken();
            double value2 = getFactorValue();
            if ("^".equals(next)) 
            { 
               value = Math.pow(value, value2); 
            }
            else { value = value % value2; }
         }
         else 
         {
            done = true;
         }
      }
      return value;
   }

      
   /**
      Evaluates the next factor found in the expression. 
      @return the value of the factor 
   */
   public double getFactorValue()
   {
      double value;
      String next = tokenizer.peekToken();
      if ("(".equals(next))
      {
         tokenizer.nextToken(); // Discard "(" 
         value = getExpressionValue();
         tokenizer.nextToken(); // Discard ")"  
      } 
      else 
      {
         value = Integer.parseInt(tokenizer.nextToken());
      }
      return value;
   }
}
