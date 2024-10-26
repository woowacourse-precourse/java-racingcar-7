package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String[] getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");

        for(String carName: carNames) {
            checkNameIsAvailable(carName);
        }

        return carNames;
    }

    public static void checkNameIsAvailable(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException();
        }
    }
}
