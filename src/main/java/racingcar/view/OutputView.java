package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    private static final String OUTPUT_STRING = "실행 결과";
    private static final String WINNER_STRING = "최종 우승자 : ";

    public void printOutputString() {
        System.out.println(OUTPUT_STRING);
    }

    public void printResult(Car car) {
        System.out.println(car.getName() + " : " + car.getCurLocation());
    }

    public void printNewLine() {
        System.out.println();
    }
}
