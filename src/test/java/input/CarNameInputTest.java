package input;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;


@DisplayName("자동차 이름 입력값 관련 테스트")
public class CarNameInputTest extends NsTest {
    @DisplayName("자동차 이름을 빈문자열로 입력한 후 엔터를 누르면 예외 발생")
    @Test
    void 실패_자동차이름입력문자열_빈값() {
        // Given
        String justEnterCarName = "\n";

        // When&Then
        assertThatThrownBy(() -> runException(justEnterCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름으로 빈 문자열은 올 수 없습니다. 자동차 이름을 입력해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
