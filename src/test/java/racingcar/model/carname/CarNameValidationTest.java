package racingcar.model.carname;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidationTest {
    @Test
    @DisplayName("자동차 이름이 5자를 초과할때 오류 반환하는지 확인한다")
    void 자동차_이름_검증_테스트() {
        String[] carNameArray = {"pobi", "woni", "junind"};
        assertThatThrownBy(() -> CarNameValidation.carNameValidate(carNameArray)).isInstanceOf(IllegalArgumentException.class);

    }
}