package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static racingcar.message.InfoMessage.STATUS_NOTIFICATION_MESSAGE;

public class Cars {
    private List<Car> cars;

    private Cars(String[] names) {
        cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    public static Cars from(String[] names) {
        return new Cars(names);
    }

    public void racing(int moveNum) {
        System.out.println(STATUS_NOTIFICATION_MESSAGE.getMessage());
        IntStream.range(0, moveNum)
                .forEach(i -> {
                    cars.forEach(Car::moveOrStop);
                    printStatus();
                });
    }

    private void printStatus() {
        cars.forEach(Car::getStatus);
        System.out.println();
    }

    // 테스트 전용 메서드
    public Car getCar(int carNumber) {
        return cars.get(carNumber);
    }

    public Winners determineWinner() {
        int maxAdvanceNum = getMaxAdvanceNum();
        return createWinners(maxAdvanceNum);
    }

    public int getMaxAdvanceNum() {
        return cars.stream()
                .mapToInt(Car::getAdvanceNum)
                .max()
                .orElse(0);
    }

    private Winners createWinners(int maxAdvanceNum) {
        List<Car> winners = cars.stream()
                .filter(car -> car.getAdvanceNum() == maxAdvanceNum)
                .toList();
        return new Winners(winners);
    }
}
