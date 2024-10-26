package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    @DisplayName("시도횟수가 숫자가 아니거나 0이하일 수 없다.")
    @Test
    public void 시도횟수_에러() {
        assertThatThrownBy(() -> new Race("0", new Cars("pobi, woni")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Race("a", new Cars("pobi, woni")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최대이동거리 구하기")
    @Test
    void 최대이동거리_구하기() {
        Cars cars = new Cars(Arrays.asList(new Car("pobi", new Distance(5))
                , new Car("woni", new Distance(5)),
                new Car("jun", new Distance(4))));
        assertThat(cars.getMaxDistance()).isEqualTo(5);
    }
}
