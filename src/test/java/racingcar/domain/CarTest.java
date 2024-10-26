package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    private final Car CAR_POBI = new Car("pobi", 0);

    @Test
    void Car_객체_생성() {
        Car car = new Car("pobi", 0);
        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 전진() {
        assertThat(CAR_POBI.move(4)).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        assertThat(CAR_POBI.move(3)).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 더_큰_위치값_구하기() {
        int position = 4;
        assertThat(CAR_POBI.getLargerMove(position)).isEqualTo(4);
    }

    @Test
    void 같은_위치값인지_판단하기() {
        assertThat(CAR_POBI.isSameMaxMove(0)).isTrue();
        assertThat(CAR_POBI.isSameMaxMove(1)).isFalse();
    }

    @Test
    void 자동차_이름_반환() {
        assertThat(CAR_POBI.getName()).isEqualTo("pobi");
    }
}
