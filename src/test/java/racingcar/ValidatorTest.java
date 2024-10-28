package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ValidatorTest extends NsTest {

	@Test
    void 유효한_숫자_입력_테스트() {
        Validator.validateNumericInput("5"); 
    }

    @Test
    void 양수_시도_횟수_테스트() {
        Validator.validatePositiveTryCount(3);
    }

    @Test
    void 유효한_자동차_이름_리스트_테스트() {
        List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        Validator.validateCarNames(carNames);
    }
    
    @Test
    void 시도_횟수_문자_입력_예외_테스트() {
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validateNumericInput("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력해야 합니다.")
        );
    }

    @Test
    void 시도_횟수_입력_예외_테스트() {
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validatePositiveTryCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수여야 합니다.")
        );
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validatePositiveTryCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수여야 합니다.")
        );
    }

    @Test
    void 자동차_이름_공백_포함_예외_테스트() {
        List<String> carNames = Arrays.asList("po bi", "crong");
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백이 포함될 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_길이_초과_예외_테스트() {
        List<String> carNames = Arrays.asList("pobisuper", "crong");
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_잘못된_문자_포함_예외_테스트() {
        List<String> carNames = Arrays.asList("pobi!", "crong");
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 영문자, 숫자, 한글만 포함하고, 언더바(_)는 처음이나 끝에 위치할 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "crong");
        assertSimpleTest(() -> 
            assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
