# stats-program

<p>
Java program that I made to review basic probability and statistics and object-oriented programming at the same time. The way this program works is that all the distribution types have their own specific class but all of those classes are children classes of Distributions. Because of this, I have an array of the class Distributions that has an instantiation of each distribution. The program will print to the screen all the different distribution types and based on the number the user types in, it will print information about the chosen distribution and then proceed to ask the user what they want to find from each distribution. Then based on what the user chooses, more prompts will come up asking for the information needed to complete specific computations. The distributions I implemented were Binomial, Geometric, Normal, Poisson, and Exponential distributions. 
  
Here is a list of what can be calculated from each distribution:
</p>

##### *Binomial, Geometric, and Poisson Distributions*
<ul>
  <li> Probability P(X) </li>
    <ul>
      <li> P(X = x) </li>
      <li> P(X <= x) </li>
      <li> P(X < x) </li>
      <li> P(X > x) </li>
      <li> P(X >= x) </li>
      <li> P(X != x) </li>
    </ul>
  <li> Mean </li>
  <li> Expected value E(X) </li>
  <li> Variance </li>
  <li> Standard Deviation </li>
</ul>

##### *Exponential Distribution*
<ul>
  <li> Probability P(X) </li>
    <ul>
      <li> P(X < x) </li>
      <li> P(X > x) </li>
    </ul>
  <li> Mean </li>
  <li> Expected value E(X) </li>
  <li> Variance </li>
  <li> Standard Deviation </li>
</ul>

##### *Normal Distribution*
<ul>
  <li> Probability P(X) </li>
    <ul>
      <li> P(X <= x) </li>
      <li> P(X >= x) </li>
    </ul>
  <li> Z-score </li>
    <ul>
      <li> With sample mean </li>
      <li> Without sample mean </li>
    </ul>
</ul>
