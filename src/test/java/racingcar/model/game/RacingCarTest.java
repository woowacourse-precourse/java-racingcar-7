package racingcar.model.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.game.RacingCar;
import racingcar.model.game.attempt.Attempt;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Position;
import racingcar.model.game.position.Positions;
import racingcar.model.game.strategy.MovingStrategy;

@DisplayName("자동차 경주 테스트")
class RacingCarTest {

    @Nested
    @DisplayName("시작 테스트")
    class startTest {

        @Test
        @DisplayName("시도횟수가 0이면 모두 출발점에 있다")
        void 성공_시작_시도횟수0() {
            // Given
            MovingStrategy movingStrategy = () -> true;
            Cars cars = new Cars(List.of(new Car("pobi", movingStrategy), new Car("woni", movingStrategy)));
            Attempt attempt = new Attempt(0);
            RacingCar racingCar = new RacingCar(cars, attempt);

            // When
            racingCar.start();

            // Then
            assertThat(racingCar).extracting("positions")
                    .isEqualTo(new Positions(List.of(Position.zero(), Position.zero())));
        }

        @Test
        @DisplayName("시도횟수가 1 이상이면 경주를 수행한다")
        void 성공_시작_시도횟수1이상() {
            // Given
            Cars cars = new Cars(List.of(new Car("pobi", () -> true), new Car("woni", () -> false)));
            Attempt attempt = new Attempt(1);
            RacingCar racingCar = new RacingCar(cars, attempt);

            // When
            racingCar.start();

            // Then
            Positions expected = new Positions(List.of(new Position(1), new Position(0)));
            assertThat(racingCar).extracting("positions")
                    .isEqualTo(expected);
            assertThat(racingCar).extracting("history")
                    .isEqualTo(new History(List.of(expected)));
        }
    }

    @Nested
    @DisplayName("우승자 계산 테스트")
    class calculateWinnersClass {

        @Test
        @DisplayName("우승자가 한 명이면 한 명만 출력한다")
        void 성공_우승자계산_우승자한명() {
            // Given
            Cars cars = new Cars(List.of(new Car("pobi", () -> true), new Car("woni", () -> false)));
            Attempt attempt = new Attempt(1);
            RacingCar racingCar = new RacingCar(cars, attempt);
            racingCar.start();

            // When
            String winners = racingCar.calculateWinners();

            // Then
            assertThat(winners).isEqualTo("pobi");
        }

        @Test
        @DisplayName("우승자가 여러 명이면 모두 출력한다")
        void 성공_우승자계산_우승자여러명() {
            // Given
            Cars cars = new Cars(List.of(new Car("pobi", () -> true), new Car("woni", () -> true)));
            Attempt attempt = new Attempt(1);
            RacingCar racingCar = new RacingCar(cars, attempt);
            racingCar.start();

            // When
            String winners = racingCar.calculateWinners();

            // Then
            assertThat(winners).isEqualTo("pobi, woni");
        }
    }
}
