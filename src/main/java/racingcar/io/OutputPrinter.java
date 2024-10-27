package racingcar.io;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputPrinter {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String PRINT_START_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println("\n" + PRINT_START_MESSAGE);
    }

    /**
     * 각 라운드 결과를 출력한다.
     * 출력 형식 예시:
     * Car1 : --
     * Car2 : ---
     */
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + convertToDash(car.getPosition()));
        }
        System.out.println();
    }

    /**
     * 최종 우승자를 쉼표로 구분하여 출력한다.
     * 예시: 최종 우승자 : Car1, Car3
     */
    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }

    private String convertToDash(int number) {
        return "-".repeat(number);
    }

}
