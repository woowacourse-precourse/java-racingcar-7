package racingcar.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RacingGame racingGame;
    private MoveStrategy moveStrategy;
    private final List<String> carNames = List.of("pobi", "woni", "jun");

    @BeforeEach
    void initRacingGameTest() {
        //given
        racingGame = new RacingGame(carNames);
        moveStrategy = new RandomMoveStrategy();
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
            assertRandomNumberInRangeTest(() -> {
                //when
                racingGame.playRound(moveStrategy);
                //then
                for (Car car : racingGame.getCars()) {
                    assertThat(car.getPosition()).isEqualTo(0);
                }
            }, STOP,STOP,STOP);
        }

        @Test
        @DisplayName("한 라운드에서 일부 자동차만 이동하는 경우")
        void testSomeCarsMoving() {
            assertRandomNumberInRangeTest(() -> {
                //when
                racingGame.playRound(moveStrategy);
                //then
                List<Car> cars = racingGame.getCars();
                assertThat(cars.get(0).getPosition()).isEqualTo(1);
                assertThat(cars.get(1).getPosition()).isEqualTo(1);
                assertThat(cars.get(2).getPosition()).isEqualTo(0);
            }, MOVING_FORWARD,MOVING_FORWARD,STOP);
        }

        @Test
        @DisplayName("한 라운드에서 모든 자동차가 이동하는 경우")
        void testAllCarsMoving() {
            assertRandomNumberInRangeTest(() -> {
                //when
                racingGame.playRound(moveStrategy);
                //then
                List<Car> cars = racingGame.getCars();
                for(Car car : cars){
                    assertThat(car.getPosition()).isEqualTo(1);
                }
            }, MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD);
        }
    }

    @Nested
    @DisplayName("우승자 결정 테스트")
    class TestWinner {
        @Test
        @DisplayName("단일 우승자 테스트")
        void testSingleWinner() {
            //given
            assertRandomNumberInRangeTest(() -> {
                racingGame.playRound(moveStrategy);
                },MOVING_FORWARD,STOP,STOP);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactly(carNames.get(0));
        }

        @Test
        @DisplayName("공동 우승자 테스트")
        void testMultipleWinner() {
            //given
            assertRandomNumberInRangeTest(() -> {
                racingGame.playRound(moveStrategy);
                },MOVING_FORWARD,MOVING_FORWARD,STOP);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrder(carNames.get(0), carNames.get(1));
        }

        @Test
        @DisplayName("모든 자동차 이동하지 않는 경우 우승자 테스트")
        void testNoCarsMovingWinner() {
            //given
            assertRandomNumberInRangeTest(() -> {
                racingGame.playRound(moveStrategy);
                }, STOP,STOP,STOP);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrderElementsOf(carNames);
        }
    }
}
