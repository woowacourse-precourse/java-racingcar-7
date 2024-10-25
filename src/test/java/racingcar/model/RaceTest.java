package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.strategy.mock.MockMoveStrategy;

class RaceTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("모든 자동차가 전진할 수 있을 때 경주가 올바르게 진행된다")
        void testRaceWithAllCarsMoving() {
            // given
            String carNames = "pobi,woni,jun";
            MockMoveStrategy moveStrategy = new MockMoveStrategy(true);
            Race race = new Race(carNames, moveStrategy, "1");

            // when
            List<Car> cars = race.next();

            // then
            assertSoftly(softly -> {
                softly.assertThat(cars).hasSize(3);
                softly.assertThat(cars.get(0).getPosition()).isEqualTo(1);
                softly.assertThat(cars.get(1).getPosition()).isEqualTo(1);
                softly.assertThat(cars.get(2).getPosition()).isEqualTo(1);

                softly.assertThat(race.hasNext()).isFalse();
            });
        }

        @Test
        @DisplayName("모든 자동차가 움직이지 않을 때 경주가 올바르게 진행된다")
        void testRaceWithNoCarsMoving() {
            // given
            String carNames = "pobi,woni,jun";
            MockMoveStrategy moveStrategy = new MockMoveStrategy(false);
            Race race = new Race(carNames, moveStrategy, "1");

            // when
            List<Car> cars = race.next();

            // then
            assertSoftly(softly -> {
                softly.assertThat(cars).hasSize(3);
                softly.assertThat(cars.get(0).getPosition()).isEqualTo(0);
                softly.assertThat(cars.get(1).getPosition()).isEqualTo(0);
                softly.assertThat(cars.get(2).getPosition()).isEqualTo(0);

                softly.assertThat(race.hasNext()).isFalse();
            });
        }

        @Test
        @DisplayName("경주가 끝난 후 우승자가 올바르게 결정된다")
        void testRaceWinner() {
            // given
            String carNames = "pobi,woni,jun";
            MockMoveStrategy moveStrategy = new MockMoveStrategy(true);
            Race race = new Race(carNames, moveStrategy, "1");

            // when
            race.next();
            List<Car> winners = race.finish();

            // then
            assertSoftly(softly -> {
                softly.assertThat(winners).hasSize(3);
                softly.assertThat(winners.stream().map(Car::getName)).containsExactlyInAnyOrder("pobi", "woni", "jun");
            });
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("경주가 완료됐을 때 next를 호출하면 IllegalStateException을 발생시킨다")
        void testRaceNextWithCompletion() {
            // given
            String carNames = "pobi,woni,jun";
            MockMoveStrategy moveStrategy = new MockMoveStrategy(true);
            Race race = new Race(carNames, moveStrategy, "0");

            // when & then
            assertThatThrownBy(race::next)
                    .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("경주가 완료되지 않았을 때 finish를 호출하면 IllegalStateException을 발생시킨다")
        void testRaceFinishWithoutCompletion() {
            // given
            String carNames = "pobi,woni,jun";
            MockMoveStrategy moveStrategy = new MockMoveStrategy(true);
            Race race = new Race(carNames, moveStrategy, "3");

            // when & then
            assertThatThrownBy(race::finish)
                    .isInstanceOf(IllegalStateException.class);
        }
    }
}
