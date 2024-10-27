package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class RacingcarController {
    private List<Car> cars;
    private int attemptCount;

    public void playGame() {
        inputCarNames();
        inputAttemptCount();
        // 이후 게임 진행 로직
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = Car.createCarsFromNames(input);
    }

    private void inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            attemptCount = Integer.parseInt(input);
            if (attemptCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해 주세요.", e);
        }
    }
}