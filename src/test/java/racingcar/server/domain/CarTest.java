package racingcar.server.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.racinggame.domain.car.Name;
import racingcar.gameplayer.game.racinggame.domain.car.Car;
import racingcar.gameplayer.game.racinggame.domain.car.Position;
import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.MovingStrategy;

class CarTest {

    static class MockStrategy implements MovingStrategy {

        @Override
        public Position getDistance() {
            return Position.ONE;
        }
    }

    @Test
    @DisplayName("move가 호출되면 Car는 strategy의 position만큼 이동한다")
    void addPositionWhenMoveCalled() throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car = new Car(new Name("car1"), new MockStrategy());
        Class<?> carClass = car.getClass();
        Field positionField = carClass.getDeclaredField("position");
        positionField.setAccessible(true);

        // when
        car.move();

        // then
        Position position = (Position) positionField.get(car);
        assertThat(position).isEqualTo(Position.ONE);
    }
}