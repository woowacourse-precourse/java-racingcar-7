package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
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

    private RacingCarService racingCarService;

    /**
     * 뽑게될 숫자 pickNumber을 인자로 하여 mockRandomPicker 생성 후 MoveStrategy 생성
     *
     * @param pickNumber - 레이싱카 뽑게 될 숫자
     * @return
     */
    private MoveStrategy createMoveStrategyWithMockPicker(int[] pickNumber) {
        RandomPicker randomPicker = new RandomPicker() {
            int index = 0;

            @Override
            public int pickNumberInRange(int min, int max) {
                return pickNumber[index++];
            }
        };

        return new RandomMoveStrategy(randomPicker);
    }

    @BeforeEach
    void setUpRacingCar() {
        // 기본 racingCarService, RandomPicker mocking 시 테스트 내에서 변경 가능
        racingCarService = new RacingCarService(new RandomMoveStrategy(new RandomPicker()));
    }

    @ParameterizedTest
    @MethodSource("testRunCarRacing")
    @DisplayName("runCarRacing 메서드 실행 후, 레이싱 카 전진 확인")
    void testRunCarRacing(List<RacingCar> racingCars, int moveCount, int[] pickNumbers, int[] expectedMove) {
        // Given
        racingCarService = new RacingCarService(createMoveStrategyWithMockPicker(pickNumbers));

        // When
        racingCarService.runCarRacing(racingCars, moveCount);

        // Then
        IntStream.range(0, racingCars.size()).forEach(index -> {
            System.out.println(racingCars.get(index).getCarName());
            assertThat(racingCars.get(index).getDistance()).isEqualTo(expectedMove[index]);
        });
    }

    static Stream<Object[]> testRunCarRacing() {
        return Stream.of(
                new Object[]{
                        List.of(RacingCar.of("A"), RacingCar.of("B"), RacingCar.of("C")),
                        5,
                        new int[] {
                                5, 4, 4,
                                4, 3, 5,
                                6, 6, 6,
                                1, 2, 3,
                                4, 6, 8,
                        },
                        new int[] {4, 3, 4}
                },
                new Object[]{
                        List.of(RacingCar.of("A"), RacingCar.of("B"), RacingCar.of("C")),
                        2,
                        new int[] {
                                4, 4, 4,
                                4, 3, 5,
                        },
                        new int[] {2, 1, 2}
                },
                new Object[]{
                        List.of(RacingCar.of("A"), RacingCar.of("B"), RacingCar.of("C")),
                        1,
                        new int[] {
                                3, 3, 3,
                        },
                        new int[] {0, 0, 0}
                }
        );
    }

    @ParameterizedTest
    @MethodSource("testWinnerCars")
    @DisplayName("레이싱 게임 우승자 반환 함수 테스트")
    void testWinnerCars(List<RacingCar> racingCars, String[] winners) {
        // Given & When
        List<RacingCar> winnerRacingCars = racingCarService.getWinnerRacingCars(racingCars);

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