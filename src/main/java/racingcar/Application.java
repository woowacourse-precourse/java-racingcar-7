package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.InputValidator;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String input = Console.readLine();
        final List<String> carNames = Arrays.asList(input.split(","));

        InputValidator.validateCarNames(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        System.out.println("시도할 횟수는 몇 회인가요?");
        final String attemptInput = Console.readLine();
        final int attemptCount = InputValidator.validateAndParseAttempts(attemptInput);

        RacingGame racingGame = new RacingGame(cars);
        racingGame.play(attemptCount);
    }

}
