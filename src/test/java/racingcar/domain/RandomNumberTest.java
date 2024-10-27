package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    @Test
    void 범위내_숫자_생성() {
        //given
        int randomStartNumber = 0;
        int randomLastNumber = 9;

        //when
        int generatedNumber = RandomNumber.getRandomNumber();

        //then
        assertThat(generatedNumber).isBetween(randomStartNumber, randomLastNumber);
    }
}
