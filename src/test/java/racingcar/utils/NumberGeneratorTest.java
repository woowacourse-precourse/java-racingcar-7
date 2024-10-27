package racingcar.utils;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void beforeEach() {
        numberGenerator = new RandomNumberGenerator();
    }

    @Test
    public void generator_메서드가_랜덤_값_4를_반환한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    int result = numberGenerator.generator();
                    assertEquals(4, result);
                }, 4
        );
    }

}