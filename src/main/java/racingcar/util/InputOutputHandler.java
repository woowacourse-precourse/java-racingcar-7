package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

public class InputOutputHandler {

    private final InputParser inputParser;

    public InputOutputHandler() {
        this.inputParser = new InputParser();
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return inputParser.parseCars(input);
    }

    public int getRound() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = Console.readLine();
        return inputParser.parseRound(input);
    }

    public void printRunResult() {
        System.out.println("\n실행 결과");
    }

    public void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println(
                "최종 우승자 : " + String.join(", ", winners.stream().map(Car::getName).toList()));
    }
}
