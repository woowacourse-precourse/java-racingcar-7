package racingcar.util.randomnumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("0부터 9까지의 랜덤한 한자리의 숫자를 생성한다")
    @Test
    void generateNumber() {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when
        int randomNumber = randomNumberGenerator.generateNumber();

        //then
        assertThat(randomNumber).isBetween(0, 9);
    }
}