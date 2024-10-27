package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Utility class for parsing input strings into various data types.
 * <p>
 * This class contains static methods for parsing and converting string inputs
 * into appropriate data structures and primitive types.
 */
public final class InputParser {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private InputParser() {}

    /**
     * Parses a comma-separated string of names into an ArrayList.
     * Removes leading and trailing whitespace from each name.
     *
     * @param names comma-separated string of names to be parsed
     * @return ArrayList containing the parsed names with whitespace removed
     */
    public static ArrayList<String> parseNames(String names) {
        return Arrays.stream(names.split(","))
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Parses a string representation of a number into an Integer.
     * Removes leading and trailing whitespace before parsing.
     *
     * @param number string representation of the number to be parsed
     * @return the parsed integer value
     */
    public static Integer parseTimes(String number) {
        return Integer.parseInt(number.strip());
    }
}