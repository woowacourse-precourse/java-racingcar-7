package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {
        //given
        racingGame = new RacingGame(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("자동차 리스트 초기화 테스트")
    @Test
    public void testCarListInit() {
        //when
        List<Car> cars = racingGame.getCars();
        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @DisplayName("한 라운드 진행시 자동차 리스트 이동 테스트")
    @Nested
    class testPlayRound {
        @Test
        @DisplayName("한 라운드에서 모든 자동차가 이동하지 못하는 경우")
        public void testNoCarsMoving() {
            //given
            MoveStrategy moveStrategy = () -> false;
            //when
            racingGame.playRound(moveStrategy);
            //then
            for (Car car : racingGame.getCars()) {
                assertThat(car.getPosition()).isEqualTo(0);
            }
        }

        @Test
        @DisplayName("한 라운드에서 한 대의 자동차만 이동하는 경우")
        public void testOneCarMoving() {
            //given
            MoveStrategy testMoveStrategy = new MoveStrategy() {
                private int count = 0;

                @Override
                public boolean canMove() {
                    return count++ < 1;
                }
            };
            //when
            racingGame.playRound(testMoveStrategy);
            //then
            List<Car> cars = racingGame.getCars();
            assertThat(cars.get(0).getPosition()).isEqualTo(1);
            assertThat(cars.get(1).getPosition()).isEqualTo(0);
            assertThat(cars.get(2).getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("한 라운드에서 두 대의 자동차만 이동하는 경우")
        public void testTwoCarsMoving() {
            //given
            MoveStrategy testMoveStrategy = new MoveStrategy() {
                private int count = 0;

                @Override
                public boolean canMove() {
                    return count++ < 2;
                }
            };
            //when
            racingGame.playRound(testMoveStrategy);
            //then
            List<Car> cars = racingGame.getCars();
            assertThat(cars.get(0).getPosition()).isEqualTo(1);
            assertThat(cars.get(1).getPosition()).isEqualTo(1);
            assertThat(cars.get(2).getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("한 라운드에서 모든 자동차가 이동하는 경우")
        public void testAllCarsMoving() {
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
    class testWinner{
        @Test
        @DisplayName("단일 우승자 테스트")
        public void testSingleWinner(){
            //given
            MoveStrategy testMoveStrategy = new MoveStrategy() {
                private int count = 0;

                @Override
                public boolean canMove() {
                    return count++ < 1;
                }
            };
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactly("pobi");
        }

        @Test
        @DisplayName("공동 우승자 테스트")
        public void testMultipleWinner(){
            //given
            MoveStrategy testMoveStrategy = new MoveStrategy() {
                private int count = 0;

                @Override
                public boolean canMove() {
                    return count++ < 2;
                }
            };
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrder("pobi","woni");
        }
        @Test
        @DisplayName("모든 자동차 이동 x 테스트")
        public void testAllWinner(){
            //given
            MoveStrategy testMoveStrategy = () -> false;
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            racingGame.playRound(testMoveStrategy);
            //when
            List<String> winners = racingGame.getWinners();
            //then
            assertThat(winners).containsExactlyInAnyOrder("pobi","woni","jun");
        }
    }
}
