package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.fake.FakeRacingStrategy;

class RacingServiceTest {

    @DisplayName("무조건 전진을 하는 경주 전략으로 자동차가 경주 하는 테스트")
    @Test
    void racingTest() {
        Cars cars = new Cars();
        cars.registerCar(new Car("car1"));
        cars.registerCar(new Car("car2"));
        cars.registerCar(new Car("car3"));
        FakeRacingStrategy fakeRacingStrategy = new FakeRacingStrategy();
        RacingService racingService = new RacingService(fakeRacingStrategy);
        racingService.race(cars);
        for(Car car : cars.getCars()) {
            assertThat(car.getCarPosition()).isEqualTo(1);
        }
    }
}
