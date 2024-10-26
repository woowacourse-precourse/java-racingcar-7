package racingcar.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberProviderTest {

    @DisplayName("랜덤 숫자를 제공한다.")
    @Test
    void getNumber() {
        // given
        RandomNumberProvider randomNumberProvider = new RandomNumberProvider();
        // when
        int randomNumber = randomNumberProvider.getNumber();
        // then
        assertThat(randomNumber).isBetween(0, 9);
    }

}