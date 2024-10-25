package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.Cars.MAX_CAR_COUNT;
import static racingcar.model.Cars.MIN_CAR_COUNT;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 양쪽_공백은_자동으로_제거처리(){
        // given
        String carNames = "    one,two,three         ";

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.getAllCars())
                .extracting(Car::getCarName)
                .containsExactly("one", "two", "three");
    }

    @Test
    void 연속된_구분자를_입력시_예외() {
        // given
        String carNames = "one,two,,three";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 콤마는 허용되지 않습니다.");
    }

    @Test
    void 중복된_자동차_이름이_있다면_예외(){
        // given
        String carNames = "one,two,three,one";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다.");
    }

    @Test
    void 처음에_구분자가_포함된다면_예외() {
        // given
        String carNames = ",one,two,three";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("처음과 마지막에 구분자를 포함시킬 수 없습니다.");

    }

    @Test
    void 마지막에_구분자가_포함된다면_예외() {
        // given
        String carNames = "one,two,three,";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("처음과 마지막에 구분자를 포함시킬 수 없습니다.");
    }

    @Test
    void 처음과_마지막에_구분자가_포함된다면_예외() {
        // given
        String carNames = ",one,two,three,";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("처음과 마지막에 구분자를 포함시킬 수 없습니다.");
    }

    @Test
    void 자동차_최대_대수를_초과시_예외() {
        // given
        String carNames = "one,two,three,four,five,six";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는" + MAX_CAR_COUNT + "대 이하로만 설정할 수 있습니다.");
    }

    @Test
    void 자동차_최소_대수를_미만시_예외() {
        // given
        String carNames = "one";

        // when
        // then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이스를 하기위해 최소" + MIN_CAR_COUNT + "대 이상의 자동차가 필요합니다.");
    }
}
