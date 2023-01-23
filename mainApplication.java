package StatsProgram;
import java.util.Scanner;
public class mainApplication 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Distributions[] distributions = {new Binomial(), new Geometric(), new Poisson(), new Exponential(), new Normal()};

        System.out.println("Hello User, welcome to the Probability Calculator");
        System.out.println("Select below what distribution you would like to do");
        System.out.println("----------------");
        System.out.println("1: Binomial Distribution");
        System.out.println("2: Geometric Distribution");
        System.out.println("3: Poisson Distribution");
        System.out.println("4: Exponential Distribution");
        System.out.println("5: Normal Distribution");
        System.out.println("----------------");
        
        int userInput = scan.nextInt();
        System.out.println("----------------");
        
        Distributions selected = distributions[userInput-1];
        
        System.out.println(selected.toString() + "\n");
        System.out.println(selected.userPrompt(scan));

        scan.close();

        //Binomial = either-or probability model that uses a p-value as the success rate of an event and events either "succeed" or "fail"
        //Geometric = mostly a Binomial model but is used for find the probability of find the first "success" after x amount of attempts
        //Poisson = probability of a number of a certain amount of events within timeframe/distance
        //Exponential = probability of time between successive events
    }
}
