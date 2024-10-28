package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.CarNameValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarNameValidatorTest {

    @Test
    void 이름이_5자_초과일_경우_예외_테스트() {
        assertThatThrownBy(() -> CarNameValidator.getCarNames("pobi,toolongname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_이름_입력_테스트() {
        List<String> names = CarNameValidator.getCarNames("pobi,jun");
        assertThat(names).containsExactly("pobi", "jun");
    }
}
