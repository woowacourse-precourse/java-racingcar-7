package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    void 랜덤넘버는_0이상_9이하로_생성된다() {
        //given
        int minNum = 0;
        int maxNum = 9;
        RandomNumber randomNumber = new RandomNumber();

        //when
        int actual = randomNumber.generate();

        //then
        assertThat(actual).isBetween(minNum, maxNum);
    }
}