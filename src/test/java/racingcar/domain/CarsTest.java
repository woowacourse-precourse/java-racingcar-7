package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void 자동차_생성_테스트() {
        Cars cars = new Cars(new String[]{"pobi", "woni"});

        Assertions.assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    @DisplayName("자동차 이름 중복 시 예외 발생")
    void 자동차_이름_중복_시_예외_발생() {

        Assertions.assertThatThrownBy(() -> new Cars(new String[]{"pobi", "pobi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름을 사용할 수 없습니다");

        ;
    }
}
