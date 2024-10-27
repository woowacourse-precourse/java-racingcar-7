package racingcar.view;

import racingcar.vo.Car;

import java.util.List;

public class OutputView {

    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String COLON = " : ";
    private final static String POSITION = "-";
    private final static String WINNER_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        printGameRoundEnd();
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarsPosition(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + COLON + POSITION.repeat(car.getPosition()));
        });
        printGameRoundEnd();
    }

    public void printWinner(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    private void printGameRoundEnd() {
        System.out.println();
    }

}
