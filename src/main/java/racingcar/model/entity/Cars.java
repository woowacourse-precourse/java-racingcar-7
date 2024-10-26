package racingcar.model.entity;

import racingcar.model.dto.CarNames;
import racingcar.strategy.MoveStrategy;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

/**
 * 자동차들을 콜렉션으로 저장한 클래스
 */
public record Cars(List<Car> cars) implements Iterable<Car> {

    public static Cars getOfNamesAndStrategy(CarNames names, MoveStrategy strategy) {
        List<Car> elements = StreamSupport.stream(names.spliterator(), false)
                    .map(name -> new Car(name, strategy))
                    .toList();
        return new Cars(elements);
    }

    @Override
    public Iterator<Car> iterator() {
        return new CarsIterator();
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

    private final class CarsIterator implements Iterator<Car> {

        private int index;

        private CarsIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < cars.size();
        }

        @Override
        public Car next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Car car = cars.get(index);
            index++;
            return car;
        }
    }
}
