package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.constant.NumberType.START_LOCATION;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @Test
    @DisplayName("Cars 객체가 정상적으로 생성되어야한다.")
    void makeCars() {
        //given
        List<String> names = List.of("aaaa", "bbbb", "cccc");
        //when
        Cars cars = Cars.of(names);
        List<String> carNames = cars.getCars().stream().map(Car::getName).toList();
        //then
        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(carNames).containsExactly("aaaa", "bbbb", "cccc");
    }

    @Test
    @DisplayName("Cars의 getCars() 메소드를 통해 가져온 Car 리스트는 불변이여야한다.")
    void getCars() {
        // given
        Cars cars = createCars();
        List<Car> getCars = cars.getCars();
        // when & then
        assertThrows(UnsupportedOperationException.class, () -> getCars.add(Car.of("aaaa")));
        assertThrows(UnsupportedOperationException.class, () -> getCars.remove(0));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("각 경주마다 Car들은 각자 랜덤 숫자를 돌려 앞으로 갈지 결정한다.")
    void startRace(int randomNumber1, int randomNumber2, int randomNumber3) {
        // given
        Cars cars = createCars();

        // when & then
        assertRandomNumberInRangeTest(() -> {
            //when
            cars.startRace();
            List<Car> carList = cars.getCars();
            //then
            int result1 = START_LOCATION.getNumber();
            int result2 = START_LOCATION.getNumber();
            int result3 = START_LOCATION.getNumber();
            if (randomNumber1 >= 4) {
                result1++;
            }
            if (randomNumber2 >= 4) {
                result2++;
            }
            if (randomNumber3 >= 4) {
                result3++;
            }
            assertThat(carList.get(0).getLocation()).isEqualTo(result1);
            assertThat(carList.get(1).getLocation()).isEqualTo(result2);
            assertThat(carList.get(2).getLocation()).isEqualTo(result3);
        }, randomNumber1, randomNumber2, randomNumber3);
    }

    static Stream<Arguments> startRace() {
        return Stream.of(
                Arguments.of(4, 1, 6),
                Arguments.of(2, 5, 7),
                Arguments.of(3, 3, 3),
                Arguments.of(5, 6, 4)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("우승자는 location이 가장 큰 값을 가진 Car 들로 추출되어야한다.")
    void getWinners(int randomNumber1, int randomNumber2, int randomNumber3) {
        // given
        Cars cars = createCars();
        // when & then
        assertRandomNumberInRangeTest(() -> {
            //when
            cars.startRace();
            List<Car> winners = cars.getWinners();
            //then
            List<Car> carList = cars.getCars();
            OptionalInt max = carList.stream().mapToInt(Car::getLocation).max();
            assertThat(winners.size()).isGreaterThan(0);
            assertThat(winners.get(0).getLocation()).isEqualTo(max.getAsInt());
        }, randomNumber1, randomNumber2, randomNumber3);
    }

    static Stream<Arguments> getWinners() {
        return Stream.of(
                Arguments.of(4, 1, 6),
                Arguments.of(2, 5, 7),
                Arguments.of(3, 3, 3),
                Arguments.of(5, 6, 4),
                Arguments.of(4, 4, 4)
        );
    }

    private Cars createCars() {
        List<String> names = List.of("jang", "jae", "hyeon");
        return Cars.of(names);
    }

}