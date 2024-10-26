package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp(){
        numberGenerator=new RandomNumberGenerator();
    }

    @Test
    void 랜덤수는_0과_9_사이이다(){
        assertThat(numberGenerator.generateNumber()).isBetween(0,9);
    }
}