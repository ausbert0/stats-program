package StatsProgram;

import java.util.Scanner;

public class Geometric extends Distributions
{
    public Geometric()
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
        System.out.println("Number of attempts until first success (x)");
        System.out.println("_______________________\n"); 
        int x = getPositiveInteger(scan);
        
        //Decides on <, <=, >, >=, = or != functionality
        System.out.println("-----------------------");
        System.out.println("Select number based on probability you want to calculate that:");
        System.out.println("1) x is equal to how many attempts were needed for the first success");
        System.out.println("2) Less than or equal to the input x-value attempts is needed for first success");
        System.out.println("3) Less than input x-value attempts needed for first success");
        System.out.println("4) Greater than input x-value attempts needed for first success");
        System.out.println("5) Greater than or equal to input x-value attempts needed for first success");
        System.out.println("6) Is NOT equal to input x-value attempts");
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
            return (Math.pow((1-p),(x-1))*p);
        }  
        
        else if (probabilityType == 2)
        {
            double total = 0;
            for (int o = 1; o <= x; o++)
            {
                total += (Math.pow((1-p),(o-1))*p);
            }
            return total;
        }
        else if (probabilityType == 3)
        {
            double total = 0;
            for (int o = 1; o < x; o++)
            {
                total += (Math.pow((1-p),(o-1))*p);
            }
            return total;
        }
        else if (probabilityType == 4)
        {
            double total = 0;
            for (int o = 1; o <= x; o++)
            {
                total += (Math.pow((1-p),(o-1))*p);;
            }
            return 1-total;
        }

        else if (probabilityType == 5)
        {
            double total = 0;
            for (int o = 1; o < x; o++)
            {
                total += (Math.pow((1-p),(o-1))*p);
            }
            return 1-total;
        }

        else if (probabilityType == 6)
        {
            return 1-(Math.pow((1-p),(x-1))*p);
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
        return 1/getDecimalOrFraction(scan);
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
        return (1-p)/(Math.pow(p,2));
    }

    public double findStandardDeviation(Scanner scan)
    {
        return Math.sqrt(findVariance(scan));
    }

    public String toString()
    {
        return "Distribution Selected: Geometric" + 
        "\nMethods Available: " + "\n1) Find Probability P(X)" + 
        "\n2) Find Expected Value E(X)" + 
        "\n3) Find Mean/Average" + "\n4) Find Variance V(X)"
        + "\n5) Find Standard Deviation";
    }
}
