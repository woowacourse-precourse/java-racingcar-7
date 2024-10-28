package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CarIntegrationTest {

    static Stream<Arguments> provideStopEngine() {
        return Stream.of(
                arguments(List.of("stopA", "stopB"), 0),
                arguments(List.of("stopA", "stopB"), 1),
                arguments(List.of("stopA", "stopB"), 2),
                arguments(List.of("stopA", "stopB"), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStopEngine")
    void 종합_테스트_멈춤(List<String> carNames, final int engineValue) {
        Cars cars = CarGenerator.generateCars(carNames, () -> engineValue);
        List<Car> carList = cars.getCars();

        IntStream.range(0, 50).forEach(i -> cars.move());

        IntStream.range(0, carList.size())
                .forEach(i -> Assertions.assertThat(carList.get(i).getPosition()).isEqualTo(0));
    }

    static Stream<Arguments> provideMoveEngine() {
        return Stream.of(
                arguments(List.of("moveA", "moveB"), 4),
                arguments(List.of("moveA", "moveB"), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMoveEngine")
    void 종합_테스트_이동(List<String> carNames, final int engineValue) {
        Cars cars = CarGenerator.generateCars(carNames, () -> engineValue);
        List<Car> carList = cars.getCars();

        IntStream.range(0, 50).forEach(i -> cars.move());

        IntStream.range(0, carList.size())
                .forEach(i -> Assertions.assertThat(carList.get(i).getPosition()).isEqualTo(50));
    }
}
