package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import java.util.List;


public class RacingCar {
    private final List<Car> cars;
    private final int attemptCount;

    public RacingCar(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        System.out.println("\nRace start!");
        for (int i = 0; i < attemptCount; i++) {
            raceOnce();       // 한 라운드 진행
            printRaceStatus(); // 라운드 결과 출력
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            if (RandomNumberGenerator.getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.displayPosition());  // Car의 displayPosition() 메서드로 상태 출력
        }
        System.out.println();  // 라운드 간 줄바꿈
    }
}