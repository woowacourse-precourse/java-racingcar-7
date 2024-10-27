package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름 검증 테스트")
public class CarTest {

    @Test
    @DisplayName("올바른 자동차 이름을 통해 자동차를 생성한다.")
    void 올바른_자동차_이름_생성() {
        assertThatCode(() -> new Car("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void 자동차_이름_5자초과_테스트() {
        assertThatThrownBy(() -> new Car("yoonyoobin"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 설정해주세요.");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외가 발생한다.")
    void 자동차_이름_공백_테스트() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }
}
