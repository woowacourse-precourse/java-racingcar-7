package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    RandomNumberGenerator generator = new RandomNumberGenerator();

    @Test
    @DisplayName("0부터 9까지 범위의 랜덤 숫자 생성 성공")
    public void 랜덤숫자_생성_0부터9까지_범위_성공() {
        // when
        int actualResult = generator.run();

        // then
        Assertions.assertThat(actualResult).isBetween(0, 9);
    }

}