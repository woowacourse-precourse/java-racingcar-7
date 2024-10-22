package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_객체_생성() {
        // given
        String carName = "pobi";
        Car pobi = new Car(carName);

        // then
        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(pobi.getDistance()).isZero();
    }

    @Test
    void 난수가_4_이상이여서_자동차가_한_칸_전진() {
        // given
        String carName = "pobi";
        int randomNumber = 4;

        Car pobi = new Car(carName);

        // when
        pobi.forward(randomNumber);

        // then
        assertThat(pobi.getDistance()).isEqualTo(1);
        assertThat(randomNumber).isGreaterThanOrEqualTo(4);
    }

    @Test
    void 난수가_4_미만이여서_자동차가_움직이지_않음() {
        // given
        String carName = "pobi";
        int randomNumber = 3;

        Car pobi = new Car(carName);

        // when
        pobi.forward(randomNumber);

        // then
        assertThat(pobi.getDistance()).isZero();
        assertThat(randomNumber).isLessThan(4);
    }
}