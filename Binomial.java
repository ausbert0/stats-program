package StatsProgram;

import java.util.Scanner;

public class Binomial extends Distributions
{
    public Binomial()
    {
        super();
    }
    
    public String userPrompt(Scanner scan)
    {
        System.out.println("Enter the corresponding integer for the function you want performed or enter the integer 0 to cancel: ");
        System.out.println("----------------");
        int userInput = scan.nextInt();
        System.out.println("----------------");

        if (userInput == 0)
        {
            return "No operations performed";
        }
        else if (userInput == 1)
        {
            return "----------------\n" + "The probability is: " + String.format("%.5f",findProbability(scan));
        }
        else if (userInput == 2)
        {
            return "----------------\n" + "The expected value is: " + String.format("%.5f",findExpectedValue(scan));
        }
        else if (userInput == 3)
        {
            return "----------------\n" + "The mean is: " + String.format("%.5f",findMean(scan));
        }
        else if (userInput == 4)
        {
            return "----------------\n" + "The variance is: " + String.format("%.5f",findVariance(scan));
        }
        else if (userInput == 5)
        {
            return "----------------\n" + "The standard deviation is: " + String.format("%.5f",findStandardDeviation(scan));
        }
        else
        {
            return "Invalid Input";
        }
    }



    public double findProbability(Scanner scan)
    {   
        System.out.println("_______________________\n"); 
        System.out.println("p-value (Success Rate)");
        System.out.println("_______________________\n");
        double p = getDecimalOrFraction(scan);

        System.out.println("_______________________\n");
        System.out.println("Number of total observations (n)");
        System.out.println("_______________________\n");
        int n = getPositiveInteger(scan);

        System.out.println("_______________________\n");
        System.out.println("Number of successes (x)");
        System.out.println("_______________________\n");
        int x = getPositiveInteger(scan);

        //Decides on <, <=, >, >=, = or != functionality
        System.out.println("-----------------------");
        System.out.println("Select number based on which probability you want to find:");
        System.out.println("1) x is equal to input number of successes");
        System.out.println("2) x is less than or equal to input number of successes");
        System.out.println("3) x is less than input number of successes");
        System.out.println("4) x is greater than input number of successes");
        System.out.println("5) x is greater than or equal to input number of successes");
        System.out.println("6) x is NOT equal to input number of successes");
        System.out.println("-----------------------");
        
        int probabilityType = scan.nextInt();

        /************************************************************
        *   
        *   Calculates probability with previous inputs and the
        *   factorial() and combination() functions 
        *   from the Distribution parent abstract class.
        *   The if-else statements control which type of probability
        *   that will be calculated based on user input
        *
        *************************************************************/

        if (probabilityType == 1)
        {
            return combination(n,x) * Math.pow(p, x) * Math.pow(1-p, n-x);
        }  
        
        else if (probabilityType == 2)
        {
            double total = 0;
            for (int o = 0; o <= x; o++)
            {
                total += combination(n,o) * Math.pow(p, o) * Math.pow(1-p, n-o);
            }
            return total;
        }
        else if (probabilityType == 3)
        {
            double total = 0;
            for (int o = 0; o < x; o++)
            {
                total += combination(n,o) * Math.pow(p, o) * Math.pow(1-p, n-o);
            }
            return total;
        }
        else if (probabilityType == 4)
        {
            double total = 0;
            for (int o = 0; o <= x; o++)
            {
                total += combination(n,o) * Math.pow(p, o) * Math.pow(1-p, n-o);
            }
            return 1-total;
        }

        else if (probabilityType == 5)
        {
            double total = 0;
            for (int o = 0; o < x; o++)
            {
                total += combination(n,o) * Math.pow(p, o) * Math.pow(1-p, n-o);
            }
            return 1-total;
        }

        else if (probabilityType == 6)
        {
            return 1-(combination(n,x) * Math.pow(p, x) * Math.pow(1-p, n-x));
        }

        else
        {
            System.out.println("\nInvalid input.");
            return 0;
        }
    }

    public double findMean(Scanner scan)
    {
        System.out.println("_______________________\n"); 
        System.out.println("p-value (Success Rate)");
        System.out.println("_______________________\n");
        double p = getDecimalOrFraction(scan);

        System.out.println("_______________________\n");
        System.out.println("Number of total observations (n)");
        System.out.println("_______________________\n");
        int n = getPositiveInteger(scan);
        return n*p;  
    } 

    public double findExpectedValue(Scanner scan)
    {
        return findMean(scan);
    }

    public double findVariance(Scanner scan)
    {
        System.out.println("_______________________\n"); 
        System.out.println("p-value (Success Rate)");
        System.out.println("_______________________\n");
        double p = getDecimalOrFraction(scan);

        System.out.println("_______________________\n");
        System.out.println("Number of total observations (n)");
        System.out.println("_______________________\n");
        int n = getPositiveInteger(scan);
        return n*p*(1-p);
    }

    public double findStandardDeviation(Scanner scan)
    {
        return Math.sqrt(findVariance(scan));
    }

    public String toString()
    {
        return "Distribution Selected: Binomial" + 
        "\nMethods Available: " + "\n1) Find Probability P(X)" + 
        "\n2) Find Expected Value E(X)" + 
        "\n3) Find Mean/Average" + "\n4) Find Variance V(X)"
        + "\n5) Find Standard Deviation";
    }
}
