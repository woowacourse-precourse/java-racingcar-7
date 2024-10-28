package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidationTest {

    @Test
    void 정상적인_이름목록_입력처리_테스트() {
        Application.getCarNames("pobi,woni,jun");

        assertThat(Application.cars).containsExactly("pobi", "woni", "jun");
        assertThat(Application.carScores).containsOnlyKeys("pobi", "woni", "jun");
        assertThat(Application.carScores.values()).containsOnly(0);
    }

    @Test
    void 정상적인_이동횟수_입력처리_테스트() {
        Application.getRepeatNum("5");
        assertThat(Application.repeat).isEqualTo(5);
    }

    @Test
    void 다른_구분자_입력시_예외처리_테스트() {
        assertThatThrownBy(() -> Application.getCarNames("pobi|woni,jun")) // |를 사용한 경우
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다: , 외의 구분자를 사용했습니다. 이름은 한글, 영문만으로 이루어져야 합니다.");
    }

    @Test
    void 여섯자이상의_이름입력시_예외처리_테스트() {
        assertThatThrownBy(() -> Application.getCarNames("pobi,jennifer")) // 6자 이상의 이름
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다: 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 음수인_이동횟수_입력시_예외처리_테스트() {
        assertThatThrownBy(() -> Application.getRepeatNum("-10")) // 음수 입력
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다: 이동 횟수가 음수입니다.");
    }

    @Test
    void 문자인_이동횟수_입력시_예외처리_테스트() {
        assertThatThrownBy(() -> Application.getRepeatNum("다섯")) // 문자 입력
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다: 이동 횟수에 문자가 입력되었습니다.");
    }
}
