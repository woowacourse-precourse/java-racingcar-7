package racingcar;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String CAR_SYMBOL = "-"; // 자동차 이동을 나타내는 기호

    public static void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printRacingStatus(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(CAR_SYMBOL);
            }
            System.out.println();
        }
    }

    public static void printLineBreak() {
        System.out.println();
    }

}
