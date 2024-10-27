package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;
import racingcar.Model.CarFactory;
import racingcar.Service.RacingGame;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> raceCars = CarFactory.createCars(getCarNames());
            int numberOfAttempts = getAttemptCount();

            RacingGame racingGame = new RacingGame(raceCars, numberOfAttempts);
            racingGame.startRace();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분, 최대 5자)");
        String input = Console.readLine();
        return input.split(",");
    }

    private static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int numberOfAttempts = Integer.parseInt(input);
            if (numberOfAttempts <= 0) throw new NumberFormatException();
            return numberOfAttempts;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(RacingGame.INVALID_ATTEMPT_COUNT_MESSAGE);
        }
    }
}
