package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car car = new Car();

    @Test
    @DisplayName("자동차 이름이 5글자 이하인 경우 이름 리스트 반환")
    void 이름_수_제한_통과_테스트() {
        Assertions.assertThat(car.splitByDelimiter("four,fivee"))
                .hasSize(2)
                .extracting(car -> car.getName())
                .contains("four", "fivee");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 IllegalException 반환")
    void 이름_수_제한_초과_테스트() {
        Assertions.assertThatThrownBy(() -> {
            car.splitByDelimiter("forky,eundeang");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
