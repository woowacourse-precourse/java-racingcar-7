package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test()
    @DisplayName("이름의 길이가 5초과면 예외를 던진다")
    void 이름_길이_검증_테스트() {
        String name = "123456";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car(name);
        });
    }
}
