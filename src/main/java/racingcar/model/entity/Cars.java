package racingcar.model.entity;

import racingcar.strategy.Strategy;

import java.util.*;

/**
 * 자동차들을 콜렉션으로 저장한 클래스
 */
public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars getOfNamesAndStrategy(CarNames names, Strategy strategy) {
        String lineOfNames = names.getString();
        List<Car> elements = Arrays.stream(lineOfNames.split(",")).
                map(name -> new Car(name, strategy)).
                toList();
        return new Cars(elements);
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarsIterator(this);
    }

    protected int getLength() {
        return cars.size();
    }

    protected Car getCarAt(int index) {
        return cars.get(index);
    }

    public List<String> getMaxProgressCarsName() {
        int maxProgress = cars.stream()
                .mapToInt(Car::getProgress)
                .max().orElse(0);

        return cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .map(Car::getName)
                .toList();
    }
}
