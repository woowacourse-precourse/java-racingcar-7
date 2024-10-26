package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarsNameTest extends NsTest {

    @Test
    void 빈_입력_예외_테스트() {
        예외_실행("\n", "입력이 비어 있습니다.");
        예외_실행(" ", "입력이 비어 있습니다.");
    }

    @Test
    void 자동차_이름이_중복인_예외_테스트() {
        예외_실행("a,a,b", "자동차 이름은 중복을 허용하지 않습니다.");
        예외_실행("hani,kitty,kitty", "자동차 이름은 중복을 허용하지 않습니다.");
    }

    @Test
    void 구분자_쉼표가_아닌_예외_테스트() {
        예외_실행("a:c:b", "이름은 기호를 포함할 수 없습니다.");
        예외_실행("hani*kitty*kai", "이름은 5자 이하로 입력해야 합니다.");
        예외_실행("hani*kitty*kai", "이름은 5자 이하로 입력해야 합니다.");
        예외_실행("hani,mice*kai", "이름은 5자 이하로 입력해야 합니다.");
    }

    @Test
    void 구분자로_구분할_문자열이_없는_경우_예외_테스트() {
        예외_실행("a,b,", "비어있는 자동차 이름이 있습니다.");
        예외_실행("hani,,kitty", "비어있는 자동차 이름이 있습니다.");
    }

    void 예외_실행(String input, String errorMessage) {
        assertThatThrownBy(() -> runException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
