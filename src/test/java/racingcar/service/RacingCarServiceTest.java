package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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

    @ParameterizedTest
    @MethodSource("testWinnerCars")
    @DisplayName("레이싱 게임 우승자 반환 함수 테스트")
    void testWinnerCars(List<RacingCar> racingCarList, String[] winners) {
        // Given & When
        List<RacingCar> winnerRacingCars = racingCarService.getWinnerRacingCars(racingCarList);

        // Then
        assertThat(winnerRacingCars).hasSize(winners.length).extracting(RacingCar::getCarName)
                .containsExactlyInAnyOrder(winners);
    }

    static Stream<Object[]> testWinnerCars() {
        return Stream.of(
                new Object[]{
                    List.of(new RacingCar("CarA", 8), new RacingCar("CarB", 5),
                            new RacingCar("CarC", 3), new RacingCar("CarD", 8)),
                    new String[]{"CarA", "CarD"}},
                new Object[]{
                    List.of(new RacingCar("CarA", 8), new RacingCar("CarB", 5),
                            new RacingCar("CarC", 3), new RacingCar("CarD", 1)),
                    new String[]{"CarA"}},
                new Object[]{
                    List.of(new RacingCar("Car", 1)),
                    new String[]{"Car"}
                }
        );
    }

    @Test
    @DisplayName("자동차 이름 인자 전달 시 RacingCar 도메인 리스트 생성 함수 테스트")
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