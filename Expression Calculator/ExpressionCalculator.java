import java.util.Scanner;
/**
    Walther Alvarez
    CISC 500
    Assignment #13
    This is an extension of class that can compute the value of an arithmetic expression in 13.6. 
    While taking into precedence the exponent before other operands. 
    It can also compute the % operand. 
 */ 
/** 
   This program calculates the value of an expression 
   consisting of numbers, arithmetic operators, and parentheses. 
*/
public class ExpressionCalculator
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter an expression: ");
      String input = in.nextLine();
      Evaluator e = new Evaluator(input);
      double value = e.getExpressionValue();
      System.out.println(input + "=" + value);
   }
}
