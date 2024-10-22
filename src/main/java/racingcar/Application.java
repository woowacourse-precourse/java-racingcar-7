package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;  // 예외를 다시 던져서 테스트가 감지할 수 있도록 함
        }
    }

    private static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");

        InputValidator.validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();
        InputValidator.validateAttempts(attemptsInput);

        int attempts = Integer.parseInt(attemptsInput);

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        RacingGame race = new RacingGame(carList, attempts);
        race.start();

        List<String> winners = race.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}