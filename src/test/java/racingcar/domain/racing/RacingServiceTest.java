package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.fake.FakeRacingStrategy;

class RacingServiceTest {

    @DisplayName("무조건 전진을 하는 경주 전략으로 자동차가 경주 하는 테스트")
    @Test
    void racingTest() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        FakeRacingStrategy fakeRacingStrategy = new FakeRacingStrategy();
        RacingService racingService = new RacingService(fakeRacingStrategy);
        racingService.race(cars);
        for(Car car : cars) {
            assertThat(car.getCarPosition()).isEqualTo(1);
        }
    }


}