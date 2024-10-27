package racingcar.domain.race;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.testutil.testdouble.MoveProviderFake;

class RaceFactoryTest {

    @Test
    void Race객체를_생성할_수_있다() {
        //given
        List<Car> cars = List.of(
                new Car("자동차 1"),
                new Car("자동차 2"),
                new Car("자동차 3")
        );
        MoveProviderFake moveProvider = new MoveProviderFake();
        RaceFactory sut = new RaceFactory();

        //when
        Race result = sut.create(cars, moveProvider);

        //then
        Assertions.assertThat(result).isNotNull();
    }
}