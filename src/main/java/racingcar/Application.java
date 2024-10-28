package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCarNames();
        int turn = inputTurnCount();

        RacingGame game = new RacingGame(cars, turn);
        game.start();
    }

    private static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력하였습니다.");
        }

        return Arrays.stream(carNamesInput.split(","))
                .map(Car::new)
                .toList();
    }

    private static int inputTurnCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String turnInput = Console.readLine();
        System.out.println();

        try {
            return Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 정수형으로 입력하여야 합니다.");
        }
    }
}
