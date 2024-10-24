package validator;

import java.util.ArrayList;

import static exception.GameException.*;

/**
 * Validates user input for a game application.
 * This class handles validation of player names and game attempt counts.
 * It ensures that player names meet specific criteria and game attempts are valid.
 */
public class InputValidator {
    /**
     * Validates that all player names are 5 characters or less.
     *
     * @param names list of player names to validate
     * @throws IllegalArgumentException if any name exceeds 5 characters
     */
    private void validateFiveLetters(ArrayList<String> names) {
        String invalidName = names.stream()
                .filter(str -> str.length() > 5)
                .findFirst()
                .orElse(null);

        if (invalidName != null) {
            throw new IllegalArgumentException(UNDER_FIVE_LETTERS.getMessage());
        }
    }

    /**
     * Validates that all player names are unique.
     *
     * @param names list of player names to validate
     * @throws IllegalArgumentException if any duplicate names are found
     */
    private void validateDistinct(ArrayList<String> names) {
        long distinctCount = names.stream().distinct().count();
        if (distinctCount < names.size()) {
            throw new IllegalArgumentException(DUPLICATE_PARTICIPANTS.getMessage());
        }
    }

    /**
     * Validates that there is more than one player.
     *
     * @param names list of player names to validate
     * @throws IllegalArgumentException if only one player is provided
     */
    private void validateOneSize(ArrayList<String> names) {
        if (names.size() == 1) {
            throw new IllegalArgumentException(SINGLE_PARTICIPANTS.getMessage());
        }
    }

    /**
     * Validates a list of player names against game rules.
     * Performs the following validations:
     * <ul>
     *   <li>Ensures there are at least two players</li>
     *   <li>Verifies all names are 5 characters or less</li>
     *   <li>Checks for duplicate player names</li>
     * </ul>
     *
     * @param names list of player names to validate
     * @throws IllegalArgumentException if any validation check fails
     */
    public void validateNames(ArrayList<String> names) {
        validateOneSize(names);
        validateFiveLetters(names);
        validateDistinct(names);
    }

    /**
     * Validates the number of game attempts.
     * The number must be a positive integer.
     *
     * @param times string representation of the number of attempts
     * @throws IllegalArgumentException if the input is not a positive integer
     * @throws NumberFormatException if the input cannot be parsed as an integer
     */
    public void validateTimes(String times) {
        try {
            int parsedTimes = Integer.parseInt(times);
            if (parsedTimes <= 0) {
                throw new IllegalArgumentException(POSITIVE_TIMES.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_TIMES.getMessage());
        }
    }
}