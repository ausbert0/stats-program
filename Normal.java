package StatsProgram;

import java.util.Scanner;

public class Normal extends Distributions
{
    public Normal()
    {
        super();
    }

    public String toString()
    {
        return "Distribution Selected: Normal" + 
        "\nMethods Available: " + "\n1) Find Probability P(X)" + 
        "\n2) Find Z-score";
    }

    public String userPrompt(Scanner scan)
    {
        System.out.println("Enter the corresponding integer for the function you want performed or enter the integer 0 to cancel: ");
        System.out.println("----------------");
        int userInput = scan.nextInt();
        System.out.println("----------------");

        if (userInput == 1)
        {
            return "----------------\n" + "The probability is: " + String.format("%.5f",findProbability(scan));
        }
        else if (userInput == 2)
        {
            return "----------------\n" + "The Z-score is: " + String.format("%.5f",findZscore(scan));
        }
        else
        {
            return "Invalid input";
        }
    }

    public double findZscore(Scanner scan)
    {
        System.out.println("Press 1 for Z-score of a sample mean X, press 2 for a regular Z-score: ");
        System.out.println("----------------");
        double choice = scan.nextDouble();
        System.out.println("----------------");

        if (choice == 1)
        {
            System.out.println("_______________________\n"); 
            System.out.println("Sample mean (X bar)");
            System.out.println("_______________________\n");
            System.out.print("Enter value: ");
            double x = scan.nextDouble();
            System.out.println();

            System.out.println("_______________________\n"); 
            System.out.println("Population Mean");
            System.out.println("_______________________\n");
            double mean = getPositiveNumber(scan);

            System.out.println("_______________________\n"); 
            System.out.println("Standard deviation (sigma)");
            System.out.println("_______________________\n");
            double deviation = getPositiveNumber(scan);

            System.out.println("_______________________\n"); 
            System.out.println("Enter sample size (n)");
            System.out.println("_______________________\n");
            double n = getPositiveInteger(scan);

            return (x-mean)/(deviation/Math.sqrt(n));
        }
        else if (choice == 2)
        {
            System.out.println("_______________________\n"); 
            System.out.println("Normally distributed variable (X)");
            System.out.println("_______________________\n");
            System.out.print("Enter value: ");
            double x = scan.nextDouble();
            System.out.println();

            System.out.println("_______________________\n"); 
            System.out.println("Population Mean");
            System.out.println("_______________________\n");
            double mean = getPositiveNumber(scan);

            System.out.println("_______________________\n"); 
            System.out.println("Standard deviation (sigma)");
            System.out.println("_______________________\n");
            double deviation = getPositiveNumber(scan);

            return (x-mean)/deviation;
        }
        else
        {
            System.out.println("\nInvalid input.");
            return 0;
        }
    }
    
    public double findProbability(Scanner scan)
    {
        System.out.println("-----------------------");
        System.out.println("Options for Z-score that will be used for the probability calculation:");
        System.out.println("1) Enter various data needed to find the Z-score");
        System.out.println("2) Enter a known Z-score");
        System.out.println("\nEnter number based on which action you want to be done: ");
        System.out.println("-----------------------");
        double choice = scan.nextDouble();
        System.out.println("----------------\n");
    
        if (choice == 1)
        {
            double z = findZscore(scan);
            
            System.out.println("-----------------------");
            System.out.println("Select number based on which probability you want to find:");
            System.out.println("1) x is greater than/greater than or equal to Z-score");
            System.out.println("2) x is less than/less than or equal to Z-score");
            System.out.println("-----------------------");
            double pChoice = scan.nextDouble();
            System.out.println("-----------------------");
    
            if (pChoice == 1)
            {
                return 1-phi(z);
            }
            else if (pChoice == 2)
            {
                return phi(z);
            }
            else 
            {
                System.out.println("Invalid input");
                return 0;
            }
        }
        else if (choice == 2)
        {
            System.out.print("Enter Z-score: ");
            double z = scan.nextDouble();

            System.out.println("-----------------------");
            System.out.println("Select number based on which probability you want to find:");
            System.out.println("1) x is greater than/greater than or equal to Z-score");
            System.out.println("2) x is less than/less than or equal to Z-score");
            System.out.println("-----------------------");
            double pChoice = scan.nextDouble();
            System.out.println("-----------------------");
    
            if (pChoice == 1)
            {
                return 1-phi(z);
            }
            else if (pChoice == 2)
            {
                return phi(z);
            }
            else 
            {
                System.out.println("Invalid input");
                return 0;
            }
        }
        else 
        {
            System.out.println("Invalid input");
            return 0;
        }
    }
}
