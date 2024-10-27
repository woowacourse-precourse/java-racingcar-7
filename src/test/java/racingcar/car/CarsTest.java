package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름에 중복이 있다면 예외가 발생한다.")
    @Test
    void newCarsWithDuplicateCarName() {
        assertThatThrownBy(() -> new Cars(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복으로 입력할 수 없습니다.");
    }
}