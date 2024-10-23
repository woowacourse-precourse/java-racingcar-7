package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외 처리")
    void carNameExceedsFiveCharactersException() {
        String name = "car123";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우 예외 처리")
    void carNameEmptyException() {
        String name = "";

        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복일 경우 예외 처리")
    void carNameDuplicateException() {
        String names = "a,b,a";

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 수가 2대 미만일 경우 예외 처리")
    void lessThanTwoCarsException() {
        String names = "a";

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
