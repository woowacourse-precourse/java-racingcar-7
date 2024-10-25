package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
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
        int max = carList.stream().mapToInt(Car::getDistance).max().getAsInt();
        return carList.stream()
                .filter(c -> c.getDistance() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
