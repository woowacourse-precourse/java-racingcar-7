package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 객체 테스트")
class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하는 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameLongerThan5() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름에 공백 문자가 포함된 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameContainsWhiteSpace() {
        assertThatThrownBy(() -> new Car("po bi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름에 알파벳과 숫자가 아닌 문자가 포함된 경우 예외가 발생한다.")
    void should_ThrowException_When_CarNameContainsInvalidCharacters() {
        assertThatThrownBy(() -> new Car("po-bi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("p@bi"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("2~3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 규칙에 부합하는 경우 객체가 생성된다.")
    void createsCarObject_When_CarNameIsValid() {
        String testCarName = "pobi";
        Car testCar = new Car(testCarName);
        assertEquals(testCar.name(), testCarName);
    }
}
