package view;

import model.RaceInput;
import validator.InputValidator;
import util.InputParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

/**
 * Handles user input for the racing game by reading and validating console inputs for participant names
 * and running times.
 */
public class InputView {
    /**
     * Validator for checking input constraints.
     */
    private final InputValidator validator = new InputValidator();

    /**
     * Reads and validates participant names and running times from console input.
     * The names are read as a single line and parsed into a list, while times are read as a single integer value.
     * Both inputs are validated before being processed.
     *
     * @return RaceInput object containing the validated participant names and running times
     * @throws IllegalArgumentException if the input names or times are invalid according to game rules
     */
    public RaceInput getInput() {
        ArrayList<String> names = InputParser.parseNames(Console.readLine().strip());
        String times = Console.readLine().strip();

        validator.validateNames(names);
        validator.validateTimes(times);

        return new RaceInput(names, InputParser.parseTimes(times));
    }
}