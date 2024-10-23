package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.utils.ErrorMessage.INVALID_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TryCountTest {

    @Test
    @DisplayName("정상 값 테스트")
    void test1() {
        String s = "5";
        TryCount result = new TryCount(s);
        TryCount except = new TryCount(5L);

        assertThat(result).isEqualTo(except);
    }

    @Test
    @DisplayName("try 동작 테스트")
    void test2() {
        int result = 0;
        int except = 5;

        String s = "5";
        TryCount trycount = new TryCount(s);

        while (trycount.canTry()) {
            result++;
        }

        assertThat(result).isEqualTo(except);
    }

    @Test
    @DisplayName("예외 : 소수 입력")
    void test3() {
        String s = "3.5";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TryCount(s));

        assertThat(exception.getMessage()).isEqualTo(INVALID_COUNT.getMessage());
    }

    @Test
    @DisplayName("0 입력")
    void test4() {
        String s = "0";

        TryCount result = new TryCount(s);
        TryCount except = new TryCount(0L);

        assertThat(result).isEqualTo(except);
    }

    @Test
    @DisplayName("음수 입력")
    void test5() {
        String s = "-5";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TryCount(s));

        assertThat(exception.getMessage()).isEqualTo(INVALID_COUNT.getMessage());
    }
}
