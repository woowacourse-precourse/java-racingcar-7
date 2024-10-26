package racingcar.util.transporter;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

public class BasicRacingCarTransporterTest {
    private final BasicRacingCarTransporter basicRacingCarTransporter;

    public BasicRacingCarTransporterTest() {
        this.basicRacingCarTransporter = new BasicRacingCarTransporter();
    }

    @Test
    public void 무작위값_4인_경우_테스트() {
        assertSimpleTest(() -> {
            // given
            RacingCar car = new RacingCar("보성");
            int location = 1;
            List<RacingCar> racingCars = List.of(car);
            List<Integer> randomNumbers = List.of(4);

            // when
            basicRacingCarTransporter.transportRacingCar(racingCars, randomNumbers);

            // then
            assertThat(car.getCurrentLocation()).isEqualTo(location);


        });
    }

    @Test
    public void 무작위값_3인_경우_테스트() {
        assertSimpleTest(() -> {
            // given
            RacingCar car = new RacingCar("보성");
            int location = 0;
            List<RacingCar> racingCars = List.of(car);
            List<Integer> randomNumbers = List.of(3);

            // when
            basicRacingCarTransporter.transportRacingCar(racingCars, randomNumbers);

            // then
            assertThat(car.getCurrentLocation()).isEqualTo(location);


        });
    }
}
