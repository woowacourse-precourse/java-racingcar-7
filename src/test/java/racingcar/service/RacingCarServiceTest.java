package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;
import racingcar.util.RandomPicker;

class RacingCarServiceTest {

    private final RandomPicker mockPicker = new RandomPicker() {
        final int[] numbers = new int[]{6, 3, 8, 1};
        int index = 0;

        @Override
        public int pickNumberInRange(int min, int max) {
            return numbers[index++];
        }
    };
    private final RacingCarService racingCarService = new RacingCarService(mockPicker);
    private final List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        racingCarList.add(new RacingCar("CarA", 8));
        racingCarList.add(new RacingCar("CarB", 5));
        racingCarList.add(new RacingCar("CarC", 3));
        racingCarList.add(new RacingCar("CarD", 8));
    }

    @Test
    @DisplayName("각 자동차 마다 랜덤 값 뽑은 후 4 이상시 전진")
    void testRandomPickGraterThan4ThenMoveForward() {
        // Given & When
        racingCarService.process(racingCarList);

        // Then
        assertThat(racingCarList.get(0).getDistance()).isEqualTo(9);
        assertThat(racingCarList.get(1).getDistance()).isEqualTo(5);
        assertThat(racingCarList.get(2).getDistance()).isEqualTo(4);
        assertThat(racingCarList.get(3).getDistance()).isEqualTo(8);
    }

    @Test
    void testWinnerCars() {
        // Given & When
        List<RacingCar> winnerRacingCars = racingCarService.getWinnerRacingCars(racingCarList);

        // Then
        assertThat(winnerRacingCars).hasSize(2)
                .extracting(RacingCar::getCarName)
                .containsExactlyInAnyOrder("CarA", "CarD");
    }
}