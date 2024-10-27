package racingcar.domain.race;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.lap.Lap;
import racingcar.domain.moveProvider.MoveProvider;
import racingcar.domain.referee.Referee;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.dto.RaceResult;
import racingcar.testutil.testdouble.MoveProviderFake;

class RaceTest {

    @Test
    void 레이스를_시작하면_레이스결과를_알_수_있다() {
        //given
        List<Car> cars = List.of(
                new Car("자동차 1"),
                new Car("자동차 2"),
                new Car("자동차 3")
        );
        MoveProvider moveProvider = new MoveProviderFake(true, false);
        Referee referee = new Referee();
        Lap lap = new Lap(cars, moveProvider);
        Race sut = new Race(lap, referee);

        //when
        RaceResult result = sut.start(10);

        //then
        Assertions.assertThat(result.getLapResults()).contains(
                LapResult.fromCarStatuses(1, List.of(
                        CarStatus.of("자동차 1", 1),
                        CarStatus.of("자동차 2", 0),
                        CarStatus.of("자동차 3", 1)
                )),
                LapResult.fromCarStatuses(10, List.of(
                        CarStatus.of("자동차 1", 5),
                        CarStatus.of("자동차 2", 5),
                        CarStatus.of("자동차 3", 5)
                ))
        );
        Assertions.assertThat(result.getWinners())
                .extracting("name")
                .containsExactlyInAnyOrder("자동차 1", "자동차 2", "자동차 3");
    }
}