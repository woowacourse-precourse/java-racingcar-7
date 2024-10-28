package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollectionFactory {
    private Processor processor;
    private AbstractCarFactory carFactory;

    public CarCollectionFactory(Processor processor, AbstractCarFactory carFactory) {
        this.processor = processor;
        this.carFactory = carFactory;
    }

    public CarCollection create(String input) {
        String[] carNames = processor.process(input);

        List<Car> cars = createCars(carNames);
        return CarCollection.of(cars);
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carFactory::create)
                .collect(Collectors.toList());
    }
}
