package inspector;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InspectorTest extends NsTest {

    private static final String FAMILY_EMOJI = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66";

    InspectName inspectName = new InspectName();

    @DisplayName("일반적인_입력_테스트_영어")
    @Test
    void normal_input_test_english(){
        assertSimpleTest(() ->
                assertThat(inspectName.letterCounter("english")).isEqualTo("english".length())
        );
    }

    @DisplayName("일반적인_입력_테스트_한글")
    @Test
    void normal_input_test_korean(){
        assertSimpleTest(() ->
                assertThat(inspectName.letterCounter("한글")).isEqualTo("한글".length())
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
                    assertThat(inspectName.letterCounter(FAMILY_EMOJI)).isEqualTo(1)
            );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
