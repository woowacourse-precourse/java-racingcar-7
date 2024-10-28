package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilTest {

    private RandomUtil randomUtil;

    @BeforeEach
    void setUp() {
        randomUtil = new RandomUtil();
    }

    @DisplayName("랜덤으로 생성되는 값은 0~9 사이이다")
    @Test
    void generateRandomNumber() {
        // given & when
        int randomNumber = randomUtil.generateRandomNumber();

        // then
        Assertions.assertThat(randomNumber).isBetween(0, 9);
    }
}