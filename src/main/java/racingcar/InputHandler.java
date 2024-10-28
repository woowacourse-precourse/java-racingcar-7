package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static String[] getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<String> carNamesList = new ArrayList<>(Arrays.asList(carNames));

        for(String carName: carNamesList) {
            checkNameLength(carName);
        }

        return carNames;
    }

    public static int getTimes() {
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNameLength(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException();
        }
    }
}
