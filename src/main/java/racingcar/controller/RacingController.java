package racingcar.controller;

import racingcar.exceptions.ErrorView;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {
    private static String racingCars;
    private static String moveCount;

    public static void start() {
        set();
        inputValid();
        RacingService.racingStart(racingCars, moveCount);
    }

    private static void set() {
        racingCars = InputView.inputCar();
        moveCount = InputView.inputCount();
    }

    private static void inputValid() {

        if (racingCars == null || racingCars.trim().isEmpty()) {
            ErrorView.error_Empty();
        }
        String[] names = racingCars.split(",");
        if (names.length < 2) {
            ErrorView.error_OneCar();
        }
        String[] nameList = new String[names.length];
        int count = 0;
        for (String name : names) {
            name = name.trim();

            if (name.length() > 5) {
                ErrorView.error_OverName();
            }

            if (!name.matches("[a-zA-Z0-9\\s!@#$%^&*()-_=+]+")) {
                ErrorView.error_InvalidName();
            }

            for (int j = 0; j < count; j++) {
                if (nameList[j].equals(name)) {
                    ErrorView.error_SameName();
                }
            }

            nameList[count] = name;
            count++;
        }
        if (moveCount == null || moveCount.trim().isEmpty()) {
            ErrorView.error_EmptyCount();
        } else if (moveCount.startsWith("-")) {
            ErrorView.error_InvalidCount2();
        } else if (!moveCount.matches("\\d+")) {
            ErrorView.error_InvalidCount1();
        }
    }
}
