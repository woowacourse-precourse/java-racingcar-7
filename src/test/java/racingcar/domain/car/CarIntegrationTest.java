package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class CarIntegrationTest {

    @Test
    void 종합_테스트() {
        List<String> carNames = List.of("stopCarA", "stopCarB", "stopCarC", "stopCarD");

        Cars cars = CarGenerator.generateCars(carNames, () -> 0);
        List<Car> carList = cars.getCars();

        IntStream.range(0, 50).forEach(i -> cars.move());

        IntStream.range(0, carList.size())
                .forEach(i -> Assertions.assertThat(carList.get(i).getPosition()).isEqualTo(0));
    }
}
