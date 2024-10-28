package delimiter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

@DisplayName("구분자 관련 테스트")
public class InputDelimiterTest extends NsTest {
    @Test
    @DisplayName("구분자로 분리된 리스트 인자의 문자열 길이가 6 이상일 경우 예외 발생")
    void 실패_구분자로분리된하나의문자열_길이가6이상() {
        // Given
        String exampleOfStringLengthSix = "nanayah,honi,moni";

        // When&Then
        assertThatThrownBy(() -> runException(exampleOfStringLengthSix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하로 적어주세요.");
    }

    @Test
    @DisplayName("구분자로 분리된 리스트 인자의 공백 제거 후 문자열 길이가 0일 경우 예외 발생")
    void 실패_공백제거후문자열_길이가0() {
        // Given
        String exampleOfStringWithTrim = "   ,23, ";

        // When&Then
        assertThatThrownBy(() -> runException(exampleOfStringWithTrim))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름으로 공백이 올 수 없습니다. 최소 한문자 이상 적어주세요.");
    }

    @Test
    @DisplayName("구분자로 분리된 리스트 인자의 문자열들 중 중복된 문자열이 있을 경우 예외 발생")
    void 실패_구분자로분리된문자열들_중복된문자열() {
        // Given
        String exampleOfStringDuplicate = "honi,boni,honi";

        // When&Then
        assertThatThrownBy(() -> runException(exampleOfStringDuplicate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다. 중복되지 않는 자동차 이름을 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
