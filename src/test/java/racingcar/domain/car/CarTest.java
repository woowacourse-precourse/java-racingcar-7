package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move메서드_true_호출시_위치가_1_움직인다() {
        //given
        Car sut = new Car("테스트용 차");

        //when
        sut.move(true);

        //then
        Assertions.assertThat(sut.getPosition()).isEqualTo(1);
    }

    @Test
    void move메서드_false_호출시_위치가_0_움직인다() {
        //given
        Car sut = new Car("테스트용 차");

        //when
        sut.move(false);

        //then
        Assertions.assertThat(sut.getPosition()).isEqualTo(0);
    }
}