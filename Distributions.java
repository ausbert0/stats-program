package StatsProgram;
import java.util.Scanner;
abstract public class Distributions 
{
    public Distributions()
    {

    }
    
    //The toString() methods for every class displays information about the distribution it is a part of
    public abstract String toString();


    /***********************************************************************************************************
    *   
    *   The userPrompt() methods for every class is what is used to allow the user to actually pick what methods
    *   they intend on using and returns the answer in a neat string informing the user of what they were
    *   finding and the solution. They all work in the same way of using a large if-elseif-else statement
    *   that determines which function the user wants based on the value they input when prompted
    *
    ***********************************************************************************************************/
    public abstract String userPrompt(Scanner scan);

    protected int factorial(int userN)
    {  
        if (userN == 0)
        {
            return 1;
        }
        else
        {
            return userN * factorial(userN-1);
        }
    }

    protected double combination(int userN, int userX)
    {
        return factorial(userN)/(factorial(userX) * factorial(userN-userX));
    }


    /*****************************************************************************************************
    *   
    *   The code for the erf and phi methods were not originally created by me (Ausberto Colon Jr./AJ)
    *   Here's the citation for those methods:   
    *    
    *   Title: ErrorFunction.java
    *   Author: Robert Sedgewick and Kevin Wayne
    *   Date: Thu Aug 11 10:15:13 EDT 2022
    *   Availability: https://introcs.cs.princeton.edu/java/21function/ErrorFunction.java.html
    *
    ******************************************************************************************************/
    protected double erf(double z)
    {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
        t * ( 1.00002368 +
        t * ( 0.37409196 +
        t * ( 0.09678418 +
        t * (-0.18628806 +
        t * ( 0.27886807 +
        t * (-1.13520398 +
        t * ( 1.48851587 +
        t * (-0.82215223 +
        t * ( 0.17087277))))))))));

        if (z >= 0)
        {
            return ans;
        }
        else
        {
            return -ans;
        }
    }

    protected double phi(double z)
    {
        return 0.5 * (1.0 + erf(z / (Math.sqrt(2.0))));
    }


    /**************************************************************************************************************************
    * 
    *   The getDecimalOrFraction() method receives decimal or fraction values from the user and makes sure it is 
    *   between 0 and 1 inclusive. It first prompts the user for if they want to input a fraction or a decimal.
    *   From there, it'll then run the getFraction() [see below for explanation for this method] method if the user inputs 1
    *   and will repeat it if it is not between 0 and 1 or it'll just use java scanner if the user inputs 2 to signify decimal input
    *   and repreats until the value is between 0 and 1. If the user inputs anything that is NOT 1 or 2, the program will output
    *   "invalid input, try again" and then repeat the getDecimalOrFraction() method until valid inputs are received all throughout.
    *
    ****************************************************************************************************************************/ 
    protected double getDecimalOrFraction(Scanner scan)
    {
        System.out.println("Press 1 to enter a fraction, press 2 to enter a decimal: ");
        System.out.println("----------------");
        double choice = scan.nextDouble();
        System.out.println("----------------");

        if (choice == 1)
        {
            double value = getFraction(scan);
            while (value < 0 || value > 1)
            {
                System.out.println("\nValue is supposed to be between 0 and 1, try other values. ");
                value = getFraction(scan);
            }
            return value;
        }
        else if (choice == 2)
        {
            System.out.print("\nEnter decimal: ");
            double value = scan.nextDouble();
            while (value < 0 || value > 1)
            {
                System.out.println("\nValue is supposed to be between 0 and 1, try another value. ");
                value = scan.nextDouble();
            }
            return value;
        }
        else 
        {
            System.out.println("Invalid input, try again\n");
            return getDecimalOrFraction(scan);
        } 
    }


    /***************************************************************************************************
    *   
    *   The getPositiveInteger() method receives input from the user and makes sure it is non-negative. 
    *   If not, it repeats until the user inputs a non-negative value
    *
    ***************************************************************************************************/
    protected int getPositiveInteger(Scanner scan)
    {
        System.out.print("Enter positive integer value: ");
        int value = scan.nextInt();
        while (value < 0)
        {
            System.out.print("\nValue must be a positive integer, try again: ");
            value = scan.nextInt();
        }
        System.out.println();
        return value;
    }


    /******************************************************************************************************************
    * 
    *   The getFraction() method prompts the user for a numerator and a denominator. If the denominator is equal to 0,
    *   it will repeat prompting the user for a denominator until the value is not 0. Once that is done, the method
    *   divides the numerator and denominator and returns the decimal value that results from it.
    * 
    *******************************************************************************************************************/
    protected double getFraction(Scanner scan)
    {
        System.out.print("\nEnter numerator: ");
        double numerator = scan.nextDouble();

        System.out.print("\nEnter denominator: ");
        double denominator = scan.nextDouble();

        while (denominator == 0)
        {
            System.out.print("\nThe denominator cannot be zero, input another value: ");
            denominator = scan.nextDouble();
        }
        System.out.println();
        return numerator/denominator;
    }


    /*************************************************************************************************************************
    *   
    *   The getPositiveNumber() method prompts the user for a value that is greater than 0. If the user inputs a value that is
    *   less than or equal to 0, it'll repeatedly prompt the user for more input until the value is greater than 0. The method
    *   will then return the valid input value.
    *
    **************************************************************************************************************************/
    protected double getPositiveNumber(Scanner scan)
    {
        //Gets number from user and makes sure it is non-negative and non-zero
        System.out.print("Enter a positive integer or decimal: ");
        double number = scan.nextDouble();
        while (number <= 0)
        {
            System.out.print("\nThe value cannot be less than or equal to 0, input another value: ");
            number = scan.nextDouble(); 
        }
        System.out.println();
        return number;
    }
}
