package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

/**
 * 레이스의 실행 및 자동차 이동, 현재 상태 출력
 */
public class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            moveEachCar();
            printCurrentStatus();
        }
    }

    private void moveEachCar() {
        for (final Car car : cars) {
            final int number = pickNumberInRange(0, 9);
            if (number >= 4) {
                car.move();
            }
        }
    }

    private void printCurrentStatus() {
        for (final Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
