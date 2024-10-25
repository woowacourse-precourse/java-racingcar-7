package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;

public class FunctionWithMVCTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 이름이_공백이거나_빈칸이면_예외(String testName) {
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,holy,pobi"})
    void 중복_이름이면_예외(String testName) {
        Cars cars = new Cars();
        assertThatThrownBy(() -> cars.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않은 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiholymoly"})
    void 이름이_5자리_초과면_예외(String testName) {
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자리 이하로 입력해주세요.");
    }

    @Test
    void 차_개수가_1개_이하면_예외() {
        String testName = "pobi";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.registerCars(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("2개 이상의 차 이름을 입력해주세요.");
    }

}
