package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.dto.CarStatusDto;
import racingcar.util.randomnumber.RandomNumberGenerator;
import racingcar.util.randomnumber.StubRandomNumberGenerator;

class CarTest {

    @DisplayName("Car를 생성할 수 있다.")
    @Test
    void createCarByName() {
        //given
        String carName = "pobi";

        //when
        Car car = Car.of(carName, new RandomNumberGenerator());

        //then
        assertThat(car).isEqualTo(Car.of(carName, new RandomNumberGenerator()));
    }

    @DisplayName("랜덤값의 크기가 4이상이라면 전진할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    void tryMove(int randomNumber, int expectedPosition) {
        //given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(randomNumber));

        //when
        car.tryMove();

        //then
        CarStatusDto carStatusDto = car.mapStatusToDto();
        assertThat(carStatusDto.position()).isEqualTo(expectedPosition);
    }

    @DisplayName("주어진 전진값과 현재 자동차의 전진값을 비교하여 더 큰 전진값을 반환한다.")
    @Test
    void findMaxPosition() {
        //given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(4));
        int position = 2;

        car.tryMove();
        car.tryMove();
        car.tryMove();

        //when
        int maxPosition = car.findMaxPosition(position);

        //then
        assertThat(maxPosition).isEqualTo(car.findMaxPosition(position));
    }

    @DisplayName("주어진 최대 전진값과 현재 자동차의 전진값을 비교하여 참, 거짓을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"3, true", "2, false"})
    void isMaxPosition(int maxPosition, boolean expectedValue) {
        //given
        Car car = Car.of("pobi", new StubRandomNumberGenerator(4));

        car.tryMove();
        car.tryMove();
        car.tryMove();

        //when
        boolean result = car.isMaxPosition(maxPosition);

        //then
        assertThat(result).isEqualTo(expectedValue);
    }
}