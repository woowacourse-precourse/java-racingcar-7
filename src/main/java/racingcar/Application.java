package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = inputCarNames();
            int attempts = inputAttempts();
            List<Car> cars = carNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
            RacingGame game = new RacingGame(cars);
            game.executeRace(attempts);
            game.announceWinner();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Arrays.asList(input.split(","));
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int attempts = Integer.parseInt(Console.readLine());
            if (attempts <= 0) {
                throw new IllegalArgumentException();
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}