package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberGeneratorTest {

    @Test
    void 랜덤수는_0과_9_사이이다(){
        assertThat(RandomNumberGenerator.createRandomNumber()).isBetween(0,9);
    }

}