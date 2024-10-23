package racingcar.domain.random;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성_테스트() {
        // given
        RandomNumberGenerator randomNumberGenerator = new FixedRandomNumberGenerator(4);

        // when
        Integer result = randomNumberGenerator.getRandomNumber(0, 9);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 랜덤_숫자_생성_테스트_값이_10이상이면_Exception() {
        // given & when & then
        assertThatThrownBy(() -> {
            new FixedRandomNumberGenerator(15);
        }).isInstanceOf(BusinessException.class);
    }
}
