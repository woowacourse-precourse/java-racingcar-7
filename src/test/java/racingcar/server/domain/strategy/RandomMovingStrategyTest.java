package racingcar.server.domain.strategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.domain.car.Position;
import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.RandomMovingStrategy;
import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.RandomValueGenerator;

class RandomMovingStrategyTest {

    static class MockRandomValueGenerator implements RandomValueGenerator {

        private final PositiveNumber mockValue;

        public MockRandomValueGenerator(Long mockValue) {
            this.mockValue = new PositiveNumber(mockValue);
        }

        @Override
        public PositiveNumber generate() {
            return mockValue;
        }
    }

    @Test
    @DisplayName("생성된 값이 pivot값보다 값이 크다면 Position.ONE을 반환해야 한다")
    void returnPositionOneIfGeneratedValueIsGreaterThanPivot() throws NoSuchFieldException, IllegalAccessException {
        // given
        Class<?> strategyClass = RandomMovingStrategy.class;
        Field pivotNumField = strategyClass.getDeclaredField("RANDOM_PIVOT_NUM");
        pivotNumField.setAccessible(true);
        PositiveNumber pivotNumber = (PositiveNumber) pivotNumField.get(null);

        // when
        Long number = pivotNumber.getNumber();
        RandomMovingStrategy strategy = new RandomMovingStrategy(new MockRandomValueGenerator(number + 1));
        Position distance = strategy.getDistance();

        // then
        assertThat(distance).isEqualTo(Position.ONE);
    }

    @Test
    @DisplayName("생성된 값이 pivot값보다 값이 작다면 Position.ZERO를 반환해야 한다")
    void returnPositionZEROIfGeneratedValueIsSmallerThanPivot() throws NoSuchFieldException, IllegalAccessException {
        // given
        Class<?> strategyClass = RandomMovingStrategy.class;
        Field pivotNumField = strategyClass.getDeclaredField("RANDOM_PIVOT_NUM");
        pivotNumField.setAccessible(true);
        PositiveNumber pivotNumber = (PositiveNumber) pivotNumField.get(null);

        // when
        Long number = pivotNumber.getNumber();
        RandomMovingStrategy strategy = new RandomMovingStrategy(new MockRandomValueGenerator(number - 1));
        Position distance = strategy.getDistance();

        // then
        assertThat(distance).isEqualTo(Position.ZERO);
    }
}