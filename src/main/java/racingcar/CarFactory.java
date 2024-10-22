package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    public CommaTokenizer commaTokenizer;

    public CarFactory(CommaTokenizer commaTokenizer) {
        this.commaTokenizer = commaTokenizer;
    }

    public List<Car> createCarsFromInput(String input) {
        String[] carNames = commaTokenizer.split(input);
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }
}
