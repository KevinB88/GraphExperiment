public class Function {
    public Function(){

    }
    private int power(int constant, int exponent){
        if(exponent == 0) return 1;
        else if(exponent < 0)
            throw new IllegalArgumentException("This method does not deal with negative exponents!(not yet)");
        int product = 1;
        for(int i = 0; i < exponent; i++){
            product *= constant;
        }
            return product;
    }

    /*
        the first type should simply be linear.

        x + 2 then use the tokenizer to take out the individual values.

        translate the string input into a function

        the value of x is able to change between any given real number

        How could we translate something like:

        x^2 + 5x + 6

        into machine instructions?

        And the machine could determine that this is a perfect square.

        Take in as a string:

        "x^2 + 5x + 6"

        The calculus calculator project.



    */

}
