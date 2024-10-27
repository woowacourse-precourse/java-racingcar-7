package racingcar.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private final List<String> carNames = List.of("pobi", "woni", "jun");

    @BeforeEach
    void initRacingGameTest() {
        //given
        racingGame = new RacingGame(carNames);
    }

    @DisplayName("자동차 리스트 초기화 테스트")
    @Test
    void testCarListInit() {
        //when
        List<Car> cars = racingGame.getCars();
        //then
        assertThat(cars).hasSize(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(carNames.get(i));
        }
    }

    @DisplayName("한 라운드 진행시 자동차 리스트 이동 테스트")
    @Nested
    class TestPlayRound {
        @Test
        @DisplayName("한 라운드에서 모든 자동차가 이동하지 못하는 경우")
        void testNoCarsMoving() {
            //given
            MoveStrategy moveStrategy = () -> false;
            //when
            racingGame.playRound(moveStrategy);
            //then
            for (Car car : racingGame.getCars()) {
                assertThat(car.getPosition()).isEqualTo(0);
            }
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2})
        @DisplayName("한 라운드에서 일부 자동차만 이동하는 경우")
        void testSomeCarsMoving(int moveCount) {
            //given
            MoveStrategy moveStrategy = createMoveStrategy(moveCount);
            //when
            racingGame.playRound(moveStrategy);
            //then
            List<Car> cars = racingGame.getCars();
            for (int i = 0; i < moveCount; i++) {
                assertThat(cars.get(i).getPosition()).isEqualTo(1);
            }
            for (int i = moveCount; i < cars.size(); i++) {
                assertThat(cars.get(i).getPosition()).isEqualTo(0);
            }
        }

        @Test
        @DisplayName("한 라운드에서 모든 자동차가 이동하는 경우")
        void testAllCarsMoving() {
            //given
            MoveStrategy moveStrategy = () -> true;
            //when
            racingGame.playRound(moveStrategy);
            //then
            for (Car car : racingGame.getCars()) {
                assertThat(car.getPosition()).isEqualTo(1);
            }
        }
    }

    @Nested
    @DisplayName("우승자 결정 테스트")
    class TestWinner {
        @Test
        @DisplayName("단일 우승자 테스트")
        void testSingleWinner() {
            //given

            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactly(carNames.get(0));
        }

        @Test
        @DisplayName("공동 우승자 테스트")
        void testMultipleWinner() {
            //given
            MoveStrategy moveStrategy = createMoveStrategy(2);
            racingGame.playRound(moveStrategy);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrder(carNames.get(0), carNames.get(1));
        }

        @Test
        @DisplayName("모든 자동차 이동하지 않는 경우 우승자 테스트")
        void testNoCarsMovingWinner() {
            //given
            MoveStrategy moveStrategy = () -> false;
            racingGame.playRound(moveStrategy);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrderElementsOf(carNames);
        }
    }

    private MoveStrategy createMoveStrategy(int moveCount) {
        return new MoveStrategy() {
            private int count = moveCount;

            @Override
            public boolean canMove() {
                return count-- > 0;
            }
        };
    }
}
