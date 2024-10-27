package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class RaceController {
    private final int attemptCount;
    private final LinkedHashMap<Car, Integer> cars;

    public RaceController(LinkedHashMap<Car, Integer> cars, int attemptCount) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }

    public void start() {
        OutputPrinter printer = new OutputPrinter();
        for (int i = 0; i < attemptCount; i++) {
            forward();
            printer.showRace(cars);
        }
    }

    private void forward() {
        Iterator<Car> carIterator = cars.keySet().iterator();
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            if (getRandomNumber() >= 4) {
                cars.put(car, cars.get(car) + 1);
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
