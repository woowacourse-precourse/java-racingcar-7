package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static utils.LetterCounter.letterCounter;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class LetterCounterTest extends NsTest {
    private static final String FAMILY_EMOJI = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66";

    @DisplayName("일반적인_입력_테스트_영어")
    @Test
    void normal_input_test_english(){
        assertSimpleTest(() ->
                assertThat(letterCounter("english")).isEqualTo("english".length())
        );
    }

    @DisplayName("일반적인_입력_테스트_한글")
    @Test
    void normal_input_test_korean(){
        assertSimpleTest(() ->
                assertThat(letterCounter("한글")).isEqualTo("한글".length())
        );
    }

    @DisplayName("utf8mb4_length_글자_수_테스트")
    @Test
    void utf8mb4_letter_normal_counting(){
        assertSimpleTest(() ->
                assertThat(FAMILY_EMOJI.length()).isNotEqualTo(1)
        );
    }

    @DisplayName("utf8mb4_letterCounter_글자_수_테스트")
    @Test
    void utf8mb4_letter_counting(){
        assertSimpleTest(() ->
                assertThat(letterCounter(FAMILY_EMOJI)).isEqualTo(1)
        );
    }

    @DisplayName("utf8mb4_utf18_혼용_글자_수_테스트")
    @Test
    void mixed_unicode_letter_counting(){
        assertSimpleTest(() ->
                assertThat(letterCounter(FAMILY_EMOJI+"한글eng")).isEqualTo(6)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
