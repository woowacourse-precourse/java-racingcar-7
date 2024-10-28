package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int attempts;

    public void start() {
        inputCarNames();
        inputAttempts();
    }

    // 자동차 이름 입력
    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }
    // 시도 횟수 입력
    private void inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        attempts = Integer.parseInt(Console.readLine());
        if (attempts <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
