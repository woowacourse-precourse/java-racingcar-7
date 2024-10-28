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
        runRace();
        announceWinners();
    }

    // 자동차 이름 입력
    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            validateCarName(name.trim());
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

    // 자동차 이동
    private void runRace() {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPosition());
            }
            System.out.println();
        }
    }

    // 경주 결과 출력
    private void announceWinners() {
        List<Car> winners = findWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("최종 우승자 : " + winnerNames);
    }

    // 최종 우승자 찾기
    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPositionLength)
                .max()
                .orElse(0);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPositionLength() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    // 입력 검증
    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
    }
}
