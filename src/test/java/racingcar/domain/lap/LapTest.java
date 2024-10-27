package racingcar.domain.lap;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.moveProvider.MoveProvider;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.testutil.testdouble.MoveProviderFake;

class LapTest {

    @Test
    void 경주_결과를_반환한다() {
        //given
        List<Car> cars = List.of(
                new Car("자동차 1"),
                new Car("자동차 2"),
                new Car("자동차 3")
        );
        MoveProvider moveProvider = new MoveProviderFake(true, false);
        Lap sut = new Lap(cars, moveProvider);

        //when
        LapResult result = sut.oneLap();

        //then
        Assertions.assertThat(result.getCarStatuses()).contains(
                CarStatus.of("자동차 1", 1),
                CarStatus.of("자동차 2", 0),
                CarStatus.of("자동차 3", 1)
        );
    }
}