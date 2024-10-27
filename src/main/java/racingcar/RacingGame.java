package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public static List<Car> initializeCars() {
        String input = inputCarNames();
        List<String> carNames = parseAndTrimCarNames(input);
        validateCarNames(carNames);
        return createCarList(carNames);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> parseAndTrimCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    protected static void validateCarNames(List<String> carNames) {
        carNames.forEach(name -> {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        });
    }

    private static List<Car> createCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public static int initializeRounds() {
        String input = inputRounds();
        return parseRounds(input);
    }

    private static String inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    protected static int parseRounds(String input) {
        try {
            int rounds = Integer.parseInt(input);
            validateRounds(rounds);
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 0보다 커야 합니다.");
        }
    }

    private void raceRound() {
        cars.forEach(Car::move);
        printRoundResults();
    }

    private void printRoundResults() {
        cars.forEach(car -> System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition())));
        System.out.println();
    }

}
