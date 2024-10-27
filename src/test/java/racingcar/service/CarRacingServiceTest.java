package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.DriveStrategy;

class CarRacingServiceTest {

    @Test
    void 자동차_경주_테스트() {
        // given
        Cars racingCars = Cars.from(List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        ));
        CarRacingService racingService = new CarRacingService(racingCars, new AlwaysDriveForwardStrategy());

        // when
        racingService.race();

        // then
        assertThat(racingCars.cars())
                .allMatch(car -> car.getPosition() == 1);
    }

    @Test
    void 우승자가_여러_명인_경우_테스트() {
        // given
        Cars racingCars = Cars.from(List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        ));
        CarRacingService racingService = new CarRacingService(racingCars, new AlwaysDriveForwardStrategy());

        // when
        racingService.race();

        // then
        assertThat(racingService.getWinner()).hasSize(3);

    }

    private static class AlwaysDriveForwardStrategy implements DriveStrategy {

        @Override
        public int drive(int position) {
            return position + 1;
        }
    }
}