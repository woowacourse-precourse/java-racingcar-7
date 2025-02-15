package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarCollectionTest {

    @Test
    void 자동차_이름이_중복될_경우_예외_발생() {
        assertThatThrownBy(() -> CarCollection.from("차1,차1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_개수가_10개를_초과할_경우_예외_발생() {
        String carNames = "차1,차2,차3,차4,차5,차6,차7,차8,차9,차10,차11";
        assertThatThrownBy(() -> CarCollection.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 수는 10개 이하만 가능합니다.");
    }

    @Test
    void 우승자_이름을_정확히_반환() {
        CarCollection cars = CarCollection.from("차1,차2,차3");
        cars.moveAll();

        assertThat(cars.getWinnerNames()).isNotEmpty();
    }
}
