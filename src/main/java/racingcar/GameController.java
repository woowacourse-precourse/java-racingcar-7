package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final RaceService raceService;

    public GameController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void startGame() {
        try {
            List<Car> cars = getCarsFromInput();
            int attempts = getAttemptsFromInput();

            for (int i = 0; i < attempts; i++) {
                raceService.moveCars(cars);
                printRaceStatus(cars);
            }

            List<String> winners = raceService.getWinners(cars);
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e; // 예외 재발생, 필요시 로깅 또는 에러 메시지 포함
        }
    }

    private List<Car> getCarsFromInput() {
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getAttemptsFromInput() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    private void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}