package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringSeparator.separate;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.domain.Winners;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.mock.TestRandomNumberGenerator;

public class RacingCarTest {
    static Stream<Arguments> createCarList() {
        return Stream.of(
                Arguments.of(List.of(new Car("car1"), new Car("car2")))
        );
    }

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("MCs");

        assertThat(car.getName()).isEqualTo("MCs");
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("MCs");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("MCs");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 자동차_리스트_생성_테스트(List<Car> carList) {
        RandomGenerator randomNumberGenerator = new RandomNumberGenerator();
        Cars cars = new Cars(carList, randomNumberGenerator);
        List<String> carNames = List.of("car1", "car2");

        CarsDto carsDto = cars.toDto();

        assertThat(carsDto.getCars().stream()
                .map(CarDto::getName))
                .containsExactlyElementsOf(carNames);
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 자동차_전체_이동_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        CarsDto carsDto = cars.toDto();

        assertThat(carsDto.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(carsDto.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 단독_우승자_결정_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,3));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        Winners winners = new Winners(cars.getWinners());

        assertThat(winners.getWinnersList()).isEqualTo("car1");
    }

    @ParameterizedTest
    @MethodSource("createCarList")
    void 공동_우승자_결정_테스트(List<Car> carList) {
        RandomGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(List.of(4,4));
        Cars cars = new Cars(carList, testRandomNumberGenerator);

        cars.moveAll();
        Winners winners = new Winners(cars.getWinners());

        assertThat(winners.getWinnersList()).isEqualTo("car1, car2");
    }

    @ParameterizedTest
    @MethodSource("stringSeparatorArguments")
    void 문자열_분리_테스트(String input, String[] expected) {
        assertThat(separate(input)).isEqualTo(expected);
    }

    static Stream<Arguments> stringSeparatorArguments() {
        return Stream.of(
                Arguments.of("a,b,c", new String[]{"a", "b", "c"}),
                Arguments.of("a,b,c,", new String[]{"a", "b", "c", ""}),
                Arguments.of(",a,b,c", new String[]{"", "a", "b", "c"}),
                Arguments.of("a,,c", new String[]{"a", "", "c"})
        );
    }
}
