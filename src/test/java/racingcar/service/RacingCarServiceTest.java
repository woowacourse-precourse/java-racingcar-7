package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
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
    private final MoveStrategy mockMoveStrategy = new RandomMoveStrategy(mockPicker);
    private final RacingCarService racingCarService = new RacingCarService(mockMoveStrategy);
    private final List<RacingCar> racingCarList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        racingCarList.add(new RacingCar("CarA", 8));
        racingCarList.add(new RacingCar("CarB", 5));
        racingCarList.add(new RacingCar("CarC", 3));
        racingCarList.add(new RacingCar("CarD", 8));
    }

    @Test
    void testWinnerCars() {
        // Given & When
        List<RacingCar> winnerRacingCars = racingCarService.getWinnerRacingCars(racingCarList);

        // Then
        assertThat(winnerRacingCars).hasSize(2).extracting(RacingCar::getCarName)
                .containsExactlyInAnyOrder("CarA", "CarD");
    }

    @Test
    void testGenerateRacingCarList() {
        // Given
        String[] carNames = {"CarA", "CarB", "CarC", "CarD"};

        // When
        List<RacingCar> racingCars = racingCarService.generateRacingCarList(List.of(carNames));

        // Then
        assertThat(racingCars).hasSize(4);
        assertThat(racingCars).extracting(RacingCar::getCarName).containsExactlyInAnyOrder(carNames);
    }
}