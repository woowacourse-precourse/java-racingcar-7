package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String NAME_DISTANCE_SEPARATOR = " : ";
    private static final String HYPHEN = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printRacingResult(List<Car> cars) {
        cars.forEach(car -> printCarInfo(car.getName(), car.getMovedDistance()));
        printEmptyLine();
    }

    private void printCarInfo(String name, int movedDistance) {
        printName(name);
        printSeparator();
        convertDistanceToHyphen(movedDistance);
    }

    public void printWinner(String winner) {
        printWinnerMessage();
        System.out.println(winner);
    }

    private void printWinnerMessage() {
        System.out.print(WINNER_MESSAGE);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    private void printName(String name) {
        System.out.print(name);
    }

    private void printSeparator() {
        System.out.print(NAME_DISTANCE_SEPARATOR);
    }

    private void convertDistanceToHyphen(int movedDistance) {
        System.out.println(HYPHEN.repeat(movedDistance));
    }
}
