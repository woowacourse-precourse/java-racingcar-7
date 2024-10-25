package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void 범위내_숫자_생성() {
        //given
        int randomStartNumber = 1;
        int randomLastNumber = 10;

        //when
        int generatedNumber = RandomNumber.getRandomNumber();

        //then
        assertThat(generatedNumber).isBetween(randomStartNumber,randomLastNumber);
    }
}
