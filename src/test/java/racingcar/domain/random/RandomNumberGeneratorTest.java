package racingcar.domain.random;

import org.junit.jupiter.api.Test;
import racingcar.exception.BusinessException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberGeneratorTest {

    private static final int TEST_FAIL_MAX_VALUE = 20;
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int TEST_COUNT = 1000;
    private static final int ACCEPT_VALUE = 4;
    private static final int TEST_FAIL_MIN_VALUE = 11;

    @Test
    void 랜덤_숫자_생성_테스트() {
        // given
        RandomNumberGenerator randomNumberGenerator = new FixedRandomNumberGenerator(4);

        // when
        Integer result = randomNumberGenerator.getRandomNumber(MIN_VALUE, MAX_VALUE);

        // then
        assertThat(result).isEqualTo(ACCEPT_VALUE);
    }

    @Test
    void 랜덤_숫자_생성_테스트_경계값이_10이상이면_Exception() {
        // given & when & then
        assertThatThrownBy(() -> {
            new DefaultRandomNumberGenerator().getRandomNumber(TEST_FAIL_MIN_VALUE, TEST_FAIL_MAX_VALUE);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 랜덤한_숫자가_1과_9사이의_정수인지_테스트() {
        // given
        RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
        boolean isInRange = true;

        // when
        for (int i = 0; i < TEST_COUNT; i++) {
            Integer randomNumber = randomNumberGenerator.getRandomNumber(MIN_VALUE, MAX_VALUE);

            // then
            if (randomNumber < MIN_VALUE || randomNumber > MAX_VALUE) {
                isInRange = false;
                break;
            }
        }

        assertThat(isInRange).isTrue();
    }
}
