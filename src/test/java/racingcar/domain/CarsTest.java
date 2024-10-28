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

    }


    @Test
    @DisplayName("우승자 찾기 테스트")
    void 우승자_찾기_테스트() {
        Cars cars = new Cars(new String[] {"pobi","woni"});
        NumberGenerator canMove = () -> 5;
        NumberGenerator canNotMove = () -> 1;

        cars.getCars().get(0).move(canMove.generateNumber());
        cars.getCars().get(1).move(canNotMove.generateNumber());

        Assertions.assertThat(cars.getWinners()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자2명 이상 찾기 테스트")
    void 우승자_2명이상_찾기_테스트() {
        Cars cars = new Cars(new String[] {"pobi","woni"});
        NumberGenerator canMove = () -> 5;

        cars.getCars().get(0).move(canMove.generateNumber());
        cars.getCars().get(1).move(canMove.generateNumber());

        Assertions.assertThat(cars.getWinners()).isEqualTo("pobi, woni");
    }


}
