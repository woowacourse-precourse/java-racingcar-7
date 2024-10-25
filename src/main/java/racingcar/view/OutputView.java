package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    public void printEndLine() {
        System.out.println();
    }

    public void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(final Car car) {
        String dashString = getDashString(car.getLocation());
        System.out.println(car.getName() + " : " + dashString + " ");
    }

    public void printWinners(final List<Car> winnerList) {
        System.out.print("최종 우승자 : " + createWinnersString(winnerList));
    }

    private static String getDashString(final int dashCount) {
        return "-".repeat(Math.max(0, dashCount));
    }

    private static String createWinnersString(final List<Car> winnerList) {
        return winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
