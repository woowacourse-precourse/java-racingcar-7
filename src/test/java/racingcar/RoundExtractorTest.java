package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RoundExtractorTest {

    @Test
    void 라운드_입력이_Null인지_검사() {
        String round = null;

        Assertions.assertThatThrownBy(() -> {
                    new RoundExtractor(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 입력할 수 없습니다.");
    }

    @Test
    void 라운드_입력이_빈문자열인지_검사() {
        String round = "";

        Assertions.assertThatThrownBy(() -> {
                    new RoundExtractor(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }

    @Test
    void 라운드_입력이_공백인지_검사() {
        String round = " ";

        Assertions.assertThatThrownBy(() -> {
                    new RoundExtractor(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }

    @Test
    void 라운드_입력이_숫자가_아닌_문자열인지_검사() {
        String round = "문자열";

        Assertions.assertThatThrownBy(() -> {
                    new RoundExtractor(round);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드 입력은 숫자만 가능합니다.");
    }
}
