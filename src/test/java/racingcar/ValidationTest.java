package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class ValidationTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void 입력형식_유효한_입력_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkInputFormat("Car1, Car2, 자동차"));
    }

    @Test
    public void 입력형식_유효하지_않은_입력_테스트() {
        assertThatThrownBy(() -> validator.checkInputFormat("Car@, Car#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 올 수 없는 문자가 포함되었습니다");
    }

    @Test
    public void 중복된_이름이_없는_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkDuplicateName("Car1, Car2, Car3"));
    }

    @Test
    public void 중복된_이름이_포함된_경우_테스트() {
        assertThatThrownBy(() -> validator.checkDuplicateName("Car1, Car2, Car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 포함되었습니다.");
    }

    @Test
    public void 이름_길이가_유효한_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkNameLength("Car1, Car2"));
    }

    @Test
    public void 이름_길이가_5를_초과하는_경우_테스트() {
        assertThatThrownBy(() -> validator.checkNameLength("Car123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이가 5 초과입니다.");
    }

    @Test
    public void 이름에_공백이_없는_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkNullName("Car1, Car2"));
    }

    @Test
    public void 이름에_공백이_포함된_경우_테스트() {
        assertThatThrownBy(() -> validator.checkNullName("Car1, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백이 될 수 없습니다.");
    }

    @Test
    public void 자동차_개수가_2대_이상인_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkCarNum("Car1, Car2"));
    }

    @Test
    public void 자동차_개수가_2대_미만인_경우_테스트() {
        assertThatThrownBy(() -> validator.checkCarNum("Car1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    public void 시도_횟수가_숫자인_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkNumber("5"));
    }

    @Test
    public void 시도_횟수가_유효하지_않은_숫자인_경우_테스트() {
        assertThatThrownBy(() -> validator.checkNumber("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수에는 숫자만 올 수 있습니다.");
    }

    @Test
    public void 시도_횟수가_양수인_경우_테스트() {
        assertThatNoException().isThrownBy(() -> validator.checkPositiveNumber("3"));
    }

    @Test
    public void 시도_횟수가_음수인_경우_테스트() {
        assertThatThrownBy(() -> validator.checkPositiveNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수만 입력이 가능합니다.");
    }
}

