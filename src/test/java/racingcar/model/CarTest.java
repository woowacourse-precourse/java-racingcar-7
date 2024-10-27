package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 글자수가_n자_초과일_때_글자수_제한_오류_발생함() {
        //Given
        String carName = "carABC";

        //When & Then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.");
    }
}
