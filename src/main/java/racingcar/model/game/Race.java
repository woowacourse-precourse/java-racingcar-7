package racingcar.model.game;

import java.util.List;
import java.util.Objects;
import racingcar.model.car.Car;

public class Race {

    private final Carrier carrier;
    private final int tryCount;

    public Race(int tryCount) {
        this.carrier = new Carrier();
        this.tryCount = tryCount;
    }

    public void addCar(Car car) {
        if (Objects.isNull(car)) {
            return;
        }
        carrier.addCar(car);
    }

    private void moveAll() {
        carrier.adaptAll(car -> {
            car.drive();
            System.out.println(car);
        });
        System.out.println();
    }

    public List<String> simulate() {
        System.out.println("\n실행 결과");

        if (tryCount == 0) {
            moveAll();
        }
        for (int i = 0; i < tryCount; i++) {
            moveAll();
        }

        return carrier.aggregateTop().stream().map(Car::getName).toList();
    }
}
