package racingcar.server.domain.strategy.random.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.domain.car.strategy.random.PositiveRandomValueGenerator;

class DefaultRandomValueGeneratorTest {

    @Test
    @DisplayName("생성되는 수는 RANDOM_START_NUM과 RANDOM_END_NUM사이여야 한다")
    void generateNumberMustBetweenStartAndEnd() throws NoSuchFieldException, IllegalAccessException {
        // given
        Class<?> strategyClass = PositiveRandomValueGenerator.class;
        Field startNumField = strategyClass.getDeclaredField("RANDOM_START_NUM");
        Field endNumField = strategyClass.getDeclaredField("RANDOM_END_NUM");
        startNumField.setAccessible(true);
        endNumField.setAccessible(true);
        int startNum = (int) startNumField.get(null);
        int endNum = (int) endNumField.get(null);

        // when
        PositiveRandomValueGenerator generator = new PositiveRandomValueGenerator();

        // then
        for (int i = 0; i < 100; i++) {
            PositiveNumber generatedNumber = generator.generate();

            // then
            assertTrue(generatedNumber.greaterThanOrEqualTo(new PositiveNumber(startNum))
                && new PositiveNumber(endNum).greaterThanOrEqualTo(generatedNumber));
        }
    }
}