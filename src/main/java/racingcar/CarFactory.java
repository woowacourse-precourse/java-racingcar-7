package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    public CommaCarNameTokenizer commaCarNameTokenizer;

    public CarFactory(CommaCarNameTokenizer commaCarNameTokenizer) {
        this.commaCarNameTokenizer = commaCarNameTokenizer;
    }

    public List<Car> createCarsFromInput(String input) {
        String[] carNames = commaCarNameTokenizer.split(input);
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }
}
