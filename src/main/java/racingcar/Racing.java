package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    List<Car> cars;
    final int attemptCount;

    public Racing(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public int makeRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void playRacing() {
        for (Car car : cars) {
            car.move(makeRandomValue());
        }
    }

    public void printRacingResult() {
        for (Car car : cars) {
            car.printCarInfo();
        }
    }

    public void printAllRacingResult() {
        System.out.printf("%n실행 결과%n");
        for (int i = 0; i < attemptCount; i++) {
            playRacing();
            printRacingResult();
            System.out.println();
        }
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max()
                .orElseThrow(() -> new RuntimeException("No cars found"));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }


}
