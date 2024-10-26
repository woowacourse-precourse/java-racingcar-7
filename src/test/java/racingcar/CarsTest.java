package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("중복된 이름이 존재하면 에외가 발생한다.")
    void 중복된_자동차_이름_테스트() {
        assertThatThrownBy(() -> Cars.createCarsFrom("yoon,yoo,biny,yoon"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
