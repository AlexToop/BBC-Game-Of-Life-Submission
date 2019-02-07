package main.toop.alexander;

/**
 * Runnable class providing entry point to the game of life.
 */
public class Main {

    /**
     * Creates a game with the specified seed and number of iterations to run.
     *
     * @param args String array arguments provided with the run command.
     */
    public static void main(String[] args) {
        errorCheckArguments(args);

        System.out.println("Welcome, the game will now be run.\n");
        Game game = new Game(args[0], getIntegerFromStringArgument(args[1]));
        System.out.println("Thank you for running this submission.");
    }


    /**
     * Ensures arguments supplied are in the format as desired. Stops program and supplies information on how to
     * adjust arguments if incorrect.
     *
     * @param args The arguments as supplied by the user.
     */
    private static void errorCheckArguments(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Please provide two arguments as specified below:\n " +
                    "Arg1: Grid seed argument. Available seed arguments: 'random' or 'scenario6'.\n " +
                    "Arg2: Number of iterations to run. Integer number.");
            System.exit(0);
        }
        if (!isAcceptableSeedArgument(args[0])) {
            System.out.println("Error: Please ensure the first argument is either 'random' or 'scenario6' and remove single quotes.");
            System.exit(0);
        }
        if (getIntegerFromStringArgument(args[1]) == null) {
            System.out.println("Error: Please ensure the second argument is in an Integer format such as '2' or '100' without single quotes.");
            System.exit(0);
        }
    }


    /**
     * Determines if the argument provided matches one of the seed scenarios available.
     *
     * @param argument String provided to be checked.
     * @return Boolean determining if argument is acceptable.
     */
    private static Boolean isAcceptableSeedArgument(String argument) {
        if ("random".equalsIgnoreCase(argument)) {
            return true;
        }
        if ("scenario6".equalsIgnoreCase(argument)) {
            // scenario6 refers to the requirement as specified in the candidate instructions.
            return true;
        }
        return false;
    }


    /**
     * Retrieves the number of iterations desired to be run from the string argument supplied.
     *
     * @param argument to be converted to an Integer.
     * @return Integer result. Null if issues in retrieval.
     */
    private static Integer getIntegerFromStringArgument(String argument) {
        // Will return as null in the event in issues during Integer retrieval.
        Integer result = null;
        try {
            result = Integer.parseInt(argument);
        } catch (Exception e) {
            //  Currently no wish to further process the exception.
        }
        return result;
    }
}
