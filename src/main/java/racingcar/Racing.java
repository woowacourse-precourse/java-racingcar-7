package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    Cars cars;

    public Racing(String carNames) {
        List<Car> carList = getCarList(carNames);

        this.cars = new Cars(carList);
    }

    public void race(int number) {
        System.out.println("실행 결과");

        IntStream.range(0, number).forEach(i -> {
            cars.move();
            cars.print();
            System.out.println();
        });
    }

    private static List<Car> getCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
