package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

public class CarNameTest {

    @Test
    @DisplayName("빈 자동차 이름을 생성하려고 하면 예외가 발생한다")
    void createEmptyCarName() {
        String name = "";
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다")
    void createCarNameExceedingLength() {
        String name = "abcdef";
        assertThatThrownBy(() -> CarName.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
