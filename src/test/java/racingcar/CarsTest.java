package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차들 테스트")
public class CarsTest {

    @Test
    @DisplayName("쉼표로 구분된 이름으로 자동차들을 생성한다.")
    void 생성_자동차들() {
        // given
        String names = "yoon,yoo,biny";

        // when
        Cars cars = Cars.createCarsFrom(names);

        // then
        assertThat(cars.size()).isEqualTo(3);
    }
}
