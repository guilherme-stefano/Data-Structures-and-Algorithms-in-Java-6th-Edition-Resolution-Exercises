package R11;

/**********************************************************

* Program to implement the method inputAllBaseTypes() *

* that reads different base type input from input device *

* and print the input back to standard output device *

**********************************************************/

//Import the required java package

import java.util.Scanner;

//Main class definition

public class InputBaseType

{

    // Main function

    public static void main(String[] args)

    {

        // Display the header

        System.out.println("Basic input types.");

        // Make a call to the function

        inputAllBaseTypes();

    }

    /*
     * Method definition to input the different values of base types from the user
     * and prints it back on the screen
     */

    public static void inputAllBaseTypes()

    {

        // Read input from user

        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the integer value

        System.out.print("Enter an integer value: ");

        /* Read value from the user until the user enter the integer value */

        while (!input.hasNextInt())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.print("Not an integer, try again: ");

        }

        /* Display the entered integer value into output device */

        System.out.println("You entered: " + input.nextInt());

        // Prompt the user to enter the BigDecimal value

        System.out.print("Enter a BigDecimal: ");

        /*
         * 
         * Call the function hasNextBigDecimal() to check whether the given input is an
         * big decimal or not
         * 
         */

        while (!input.hasNextBigDecimal())

        {
            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.print("Not a BigDecimal, try again: ");

        }

        /* Display the entered big decimal into output device */

        System.out.println("You entered: " + input.nextBigDecimal());

        // Read the long value

        System.out.println("Enter a long value: ");

        /*
         * Call the function hasNextLong() to check whether the given input is a long or
         * not
         */

        while (!input.hasNextLong())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.println("Not a long, try again");

        }

        /* Display the entered long value into output device */

        System.out.println("You entered: " + input.nextLong());

        // Read the double value

        System.out.println("Enter a double value: ");

        /*
         * 
         * Call the function hasNextDouble() to check whether the given input is an
         * 
         * double or not
         * 
         */

        while (!input.hasNextDouble())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.println("Not a double, try again");

        }

        /* Display the entered double value into output device. */

        System.out.println("You entered: " + input.nextDouble());

        // Read the Boolean value

        System.out.println("Enter a boolean value: ");

        /*
         * 
         * Call the function hasNextBoolean () to check the given input is an boolean or
         * not
         * 
         */

        while (!input.hasNextBoolean())

        {

            // Return the skipped input

            input.next();

            // Display the error message

            System.out.println("Not a boolean, try again");

        }

        // Display the entered boolean into output device

        System.out.println("You entered: " + input.nextBoolean());

        // Read the big integer value

        System.out.println("Enter a BigInteger value: ");

        /*
         * 
         * Call the function hasNextBigInteger() to check whether the given input is a
         * BigInteger or not
         * 
         */

        while (!input.hasNextBigInteger())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.println("Not a BigInteger, try again");

        }

        /* Display the entered big integer into output device */

        System.out.println("You entered: " + input.nextBigInteger());

        // Read the byte value

        System.out.println("Enter a Byte value: ");

        /* Call the function hasNextByte() to check the given input is a byte or not */

        while (!input.hasNextByte())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.println("Not a Byte, try again");

        }

        // Display the entered byte into output device

        System.out.println("You entered: " + input.nextByte());

        // Read the float value

        System.out.println("Enter a Float: ");

        /*
         * Call the function hasNextFloat() to check the given input is a float or not
         */

        while (!input.hasNextFloat())

        {

            // Return the skipped input

            input.nextLine();

            // Display the error message

            System.out.println("Not a Float, try again");

        }

        // Display the entered float into output device

        System.out.println("You entered: " + input.nextFloat());
    	input.close();
    }

}