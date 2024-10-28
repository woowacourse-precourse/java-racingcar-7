package racingcar.util.transporter;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.util.generator.RacingCarGameRandomGenerator;

public class BasicRacingCarTransporterTest {
    private final BasicRacingCarTransporter basicRacingCarTransporter;
    private final BasicRacingCarTransporterTest.MockRacingCarRandomGenerator mockRacingCarRandomGenerator;

    public BasicRacingCarTransporterTest() {
        this.mockRacingCarRandomGenerator = new MockRacingCarRandomGenerator();
        this.basicRacingCarTransporter = new BasicRacingCarTransporter(mockRacingCarRandomGenerator);
    }

    @BeforeEach
    public void initMockRandomNumbers() {
        this.mockRacingCarRandomGenerator.clearRandomNumber();
    }

    @Test
    public void 무작위값_4인_경우_테스트() {
        assertSimpleTest(() -> {
            // given
            RacingCar car = new RacingCar("보성");
            int location = 1;
            List<RacingCar> racingCars = List.of(car);
            this.mockRacingCarRandomGenerator.addRandomNumber(4);

            // when
            basicRacingCarTransporter.transportRacingCar(racingCars);

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
            this.mockRacingCarRandomGenerator.addRandomNumber(3);

            // when
            basicRacingCarTransporter.transportRacingCar(racingCars);

            // then
            assertThat(car.getCurrentLocation()).isEqualTo(location);
        });
    }

    class MockRacingCarRandomGenerator implements RacingCarGameRandomGenerator {
        private Queue<Integer> randomNumbers = new ArrayDeque<>();

        public void addRandomNumber(int number) {
            this.randomNumbers.add(number);
        }

        public void clearRandomNumber() {
            this.randomNumbers.clear();
        }

        @Override
        public int generateRandomNumbers() {
            return randomNumbers.poll();
        }
    }
}
