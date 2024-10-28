package racingcar.view;

import racingcar.model.Cars;

public class OutputView {
    private static final String RACE_RESULT = "\n실행 결과";

    public static void printRaceResult() {
        System.out.println(RACE_RESULT);
    }

    public static void printRaceProgress(Cars cars) {
        System.out.println(cars);
    }
}
