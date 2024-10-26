package console;

import static console.Message.CAR_NAME_FORMAT_ERROR;
import static console.Message.CAR_NAME_LENGTH_ERROR;
import static console.Message.CAR_NAME_SEPARATOR_ERROR;
import static console.Message.NATURAL_NUMBER_VALIDATION_ERROR;
import static console.Message.NUMBER_TOO_LARGE_ERROR;
import static console.Message.NUMERIC_INPUT_PATTERN;
import static console.Message.PROMPT_FOR_ATTEMPTS;
import static console.Message.PROMPT_FOR_RACING_CARS;
import static console.Message.VALUE_REQUIRED_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUtil {

    public static String readCarName() {
        System.out.println(PROMPT_FOR_RACING_CARS);
        String carName = Console.readLine();
        checkCarNameException(carName);
        return carName;
    }

    public static int readRacingCount() {
        System.out.println(PROMPT_FOR_ATTEMPTS);
        String racingCount = Console.readLine();
        return checkCountException(racingCount);

    }

    public static void closeConsole() {
        Console.close();
    }

    public static void generateExceptionIfNameAbove5(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }

    public static int checkCountException(String racingCount) {
        try {
            checkIsNotNull(racingCount);
            boolean onlyNumber = racingCount.matches(NUMERIC_INPUT_PATTERN);
            if (!onlyNumber) {
                throw new IllegalArgumentException(NATURAL_NUMBER_VALIDATION_ERROR);
            }
            int value = Integer.parseInt(racingCount);
            if (value == 0) {
                throw new IllegalArgumentException(NATURAL_NUMBER_VALIDATION_ERROR);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_TOO_LARGE_ERROR);
        }
    }

    public static void checkCarNameException(String carName) {
        checkIsNotNull(carName);
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(CAR_NAME_FORMAT_ERROR);
        }
        if (carName.contains(",,")) {
            throw new IllegalArgumentException(CAR_NAME_SEPARATOR_ERROR);
        }
        String[] carNames = carName.split(",");
        for (String splitCarName : carNames) {
            generateExceptionIfNameAbove5(splitCarName);
        }


    }

    public static void checkIsNotNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(VALUE_REQUIRED_ERROR);
        }
    }


}
