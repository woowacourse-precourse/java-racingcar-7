package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingCarServiceTest {
    RacingCarService racingCarService;

    @Test
    void 우승자_출력_테스트() {
        racingCarService = new RacingCarService();
        Race race = new Race();
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");
        car1.move();
        car1.move();
        car2.move();
        car2.move();
        race.addCar(car1);
        race.addCar(car2);
        race.addCar(car3);

        Assertions.assertThat(racingCarService.getRaceWinner(race)).isEqualTo("a, b");
    }
}
