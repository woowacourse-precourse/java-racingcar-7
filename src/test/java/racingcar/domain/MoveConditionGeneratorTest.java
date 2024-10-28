package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveConditionGeneratorTest {

    @Test
    void 랜덤값테스트() {
        final MoveConditionGenerator randomGenerator = new MoveConditionGenerator();

        Assertions.assertThat(randomGenerator.getCondition().getConditionPoint())
                .isBetween(0, 9);
    }
}