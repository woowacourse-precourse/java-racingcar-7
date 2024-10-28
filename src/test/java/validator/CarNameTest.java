package validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarNameTest extends NsTest {


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "@1"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 공백_포함_예외_테스트() {
        // 자동차 이름에 공백이 포함된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po bi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_초과_테스트() {
        // 자동차 이름이 5자를 초과한 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,superman", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_이름_테스트() {
        // 빈 문자열이 포함된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 모든 이름이 비어있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_이름_테스트() {
        // 자동차 이름이 중복된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 대소문자 구분 없이 중복된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_이름_테스트() {
        // 숫자로만 이루어진 이름이 정상 입력으로 통과하도록 설정
        assertSimpleTest(() -> runException("12345,java", "1"));
    }

    @Test
    void 한글_이름_테스트() {
        assertSimpleTest(() ->
                runException("포비,자바", "1")
        );
        // 한글은 정상 입력으로 통과해야 함
    }
    
    @Test
    void 비정상_구분자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi|java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
