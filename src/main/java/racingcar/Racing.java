package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> carList;

    public Racing(String cars) {
        carList = Arrays.stream(cars.split(","))
                .map(Car::new)
                .toList();
    }

    public String race(int repeat) {
        System.out.println("실행 결과");
        for (int i = 0; i < repeat; i++) {
            for (Car car : carList) {
                car.move();
            }
            System.out.println(this);
            System.out.println();
        }
        System.out.print("최종 우승자 : ");
        List<Car> winner = getWinner();
        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public List<Car> getWinner() {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();
        return carList.stream()
                .filter(c -> c.getDistance() == maxDistance)
                .toList();
    }

    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
