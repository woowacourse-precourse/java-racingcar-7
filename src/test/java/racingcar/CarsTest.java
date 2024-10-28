package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars.Cars;

public class CarsTest {
    @DisplayName("자동차 이름이 1개인 경우 예외가 발생한다")
    @Test
    void 자동차_이름_최소_개수_테스트() {
        assertThatThrownBy(() -> Cars.from("A")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 10개를 초과하는 경우 예외가 발생한다")
    @Test
    void 자동차_이름_최대_개수_테스트() {
        assertThatThrownBy(() -> Cars.from("A,B,C,D,E,F,G,H,I,J,K")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 중복되는 경우 예외가 발생한다")
    @Test
    void 자동차_이름_중복_테스트() {
        assertThatThrownBy(() -> Cars.from("Hippo,Hippo,B,C")).isInstanceOf(IllegalArgumentException.class);
    }
}
