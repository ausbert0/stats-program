package StatsProgram;

import java.util.Scanner;

public class Exponential extends Distributions
{
    public Exponential()
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
        System.out.println("Average rate of event (lambda)");
        System.out.println("_______________________\n");
        double lambda = getDecimalOrFraction(scan);

        System.out.println("_______________________\n");
        System.out.println("Number of events (x)");
        System.out.println("_______________________\n");
        int x = getPositiveInteger(scan);

        System.out.println("-----------------------");
        System.out.println("Select number based on which probability you want to find:");
        System.out.println("1) x is greater than input number of events");
        System.out.println("2) x is less than input number of events");
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
            return Math.exp(-lambda*x);
        }
        else if(probabilityType == 2)
        {
            return 1-Math.exp(-lambda*x);
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
        System.out.println("Average rate of event (lambda)");
        System.out.println("_______________________\n");
        double lambda = getDecimalOrFraction(scan);
        return 1/lambda;
    }

    public double findExpectedValue(Scanner scan)
    {
        return findMean(scan);
    }

    public double findVariance(Scanner scan)
    {
        return Math.pow(findMean(scan), 2);
    }

    public double findStandardDeviation(Scanner scan)
    {
        return findMean(scan);
    }

    public String toString()
    {
        return "Distribution Selected: Exponential" + 
        "\nMethods Available: " + "\n1) Find Probability P(X)" + 
        "\n2) Find Expected Value E(X)" + 
        "\n3) Find Mean/Average" + "\n4) Find Variance V(X)"
        + "\n5) Find Standard Deviation";
    }
}
