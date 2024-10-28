package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitterUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a,b,c,d", "a,b,c,d,e"})
    void 스플릿_테스트(String string) {
        String[] split = SplitterUtil.splitCarNames(string);

        assertThat(split)
                .isEqualTo(string.split(","));
    }

}
