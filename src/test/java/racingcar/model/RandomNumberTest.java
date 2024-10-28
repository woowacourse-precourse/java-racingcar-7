package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {
    @Test
    void isMovableTrue() {
        RandomNumber randomNumber = new RandomNumber(4);

        assertThat(randomNumber.isMovable()).isTrue();
    }

    @Test
    void isMovableFalse() {
        RandomNumber randomNumber = new RandomNumber(3);

        assertThat(randomNumber.isMovable()).isFalse();
    }

}