package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int attempts = inputAttempts();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        RacingGame game = new RacingGame(cars);
        // TODO: 추가 구현
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    private static int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}