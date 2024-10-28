package racingcar.io;

import racingcar.domain.Car;

import java.util.List;

public class Printer {

    private static final String CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String PRINT_START_MESSAGE = "실행 결과";


    public void printInputNamesMessage() {
        System.out.println(CARS_MESSAGE);
    }

    public void printInputRoundMessage() {
        System.out.println(ROUND_MESSAGE);
    }

    public void printRaceStartMessage() {
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
