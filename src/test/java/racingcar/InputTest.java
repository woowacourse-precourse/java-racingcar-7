package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class InputTest extends NsTest {

    /**
     * 정상 입력 케이스
     *   - 예시 : pobi,woni,jun
     *   - 기대 : 정상 진행
     */
    @Test
    void 정상_입력_테스트() {
        assertDoesNotThrow(() -> runException());
    }

    /**
     * 이름 길이 초과 케이스
     *   - 예시 : pobi,woooooooni,jun
     *   - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
     */
    @Test
    void 이름_길이초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woooooooni,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * - 빈 이름 포함 케이스
     *   - 예시 : pobi,,jun
     *   - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
     */
    @Test
    void 이름_공백포함_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * - 잘못된 구분자 케이스
     *   - 예시 : p;i,jun
     *   - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
     */
    @Test
    void 이름_구분자오류_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("p;i,jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * - 이동 횟수 오류 케이스
     *   - 예시 : -3
     *   - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
     */
    @Test
    void 이동횟수_범위초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,won,jun", "-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
