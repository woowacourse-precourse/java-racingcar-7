package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public abstract class OutputView {

    public static void printCarStatus(List<RacingCar> cars) {
        cars.forEach(System.out::println);
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
