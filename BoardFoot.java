import java.util.Scanner;

/**
* The BoardFoot program gets the width and the height from the user.
* It calculates the length, so that the result is exactly 1 board foot.
* It returns the board foot value, then rounds to 2 decimal places.

*
* @author Noah Smith
* @version 1.0
* @since 2025-03-04
*/

final class BoardFoot {

    /**
    * The volume of a board foot in inches cubed.
    */
    public static final double BOARD_FOOT_VOLUME = 144;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private BoardFoot() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Function to calculate length.
     *
     * @param width  The width of the board.
     * @param height The height of the board.
     * @return The length required for one board foot.
     */
    public static double calculateBoardFoot(
            final double width, final double height
        ) {
        // Calculate length
        double length = BOARD_FOOT_VOLUME / (width * height);

        // Return length to function call
        return length;
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {

        // Using Scanner for getting input from user
        Scanner scanner = new Scanner(System.in);

        // Greet user
        System.out.println("Welcome to the board foot program!");

        // Initialize width and height to 0
        double width = 0;
        double height = 0;

        // do while loop to give user another chance to enter valid input
        do {

            // Get width from user
            System.out.print("Enter the width in inches: ");
            try {
                // Convert width to a double
                width = scanner.nextDouble();

                // Make sure width is positive
                if (width <= 0) {
                    System.out.println(width
                    + " is not a valid width. Try again.");
                } else {
                    // Get height from user
                    System.out.print(
                            "Enter the height in inches: "
                        );

                    try {
                        // Convert height to a double
                        height = scanner.nextDouble();

                        // Make sure height is positive
                        if (height <= 0) {
                            System.out.println(height
                            + " is not a valid height. Try again.");
                        } else {
                            // Call calculateLength function
                            double length = calculateBoardFoot(width, height);

                            // Display length rounded to 2 decimal places
                            System.out.print("The length is "
                            + String.format("%.2f", length) + " inches.");
                        }
                    // Catch invalid height
                    } catch (Exception exception) {
                        // If the user does not enter a valid height
                        System.out.println("Enter a number. Try again.");

                        // Move on to the next line of input
                        // to prevent potential infinite loop
                        scanner.nextLine();
                    }
                }
            // catch invalid width
            } catch (Exception exception) {
                System.out.println("Enter a number. Try again.");

                // Move on to the next line of input
                // to prevent potential infinite loop
                scanner.nextLine();
            }
        // End of do while loop
        } while (width <= 0 || height <= 0);

        // Closing Scanner
        scanner.close();
    }
}
